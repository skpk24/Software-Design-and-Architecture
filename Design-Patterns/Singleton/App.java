package com.ilinks.practice.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {

	public static void main(String[] args) {
		
		//Classic implementation of singleton 
		//================== [START] TEST CASE FOR CLASSIC/LAZY IMPL ==================  
		System.out.println("================== [START] TEST CASE FOR CLASSIC/LAZY IMPL ==================");
		Singleton singleton = Singleton.getInstance();
		System.out.println("Main Thread : "+singleton.hashCode());
		System.out.println("Main Thread only : "+Singleton.getInstance().hashCode());
		
		//New thread might create a problem, as we have 2 threads now main and this thread, some times either thread can get the new object.
		new Thread(()->{System.out.println("Thread 1 : "+Singleton.getInstance().hashCode());}).start();
		
		
		//Now create the pool, might get any one of the object 
//		ExecutorService service = Executors.newFixedThreadPool(3);
//		for(int i = 0; i < 10; i++) {
//			service.execute(()->{System.out.println(Singleton.getInstance().hashCode());});
//		}
		
		//Now do some reflection 
		System.out.println(getReflectionHashCode(Singleton.class));
		System.out.println("\n================== [END] TEST CASE FOR CLASSIC/LAZY IMPL ==================");
		//================== [END] TEST CASE FOR CLASSIC/LAZY IMPL ==================
		
		//================== [START] TEST CASE FOR EAGER IMPL ================== 
		//we might face the same problem here, when thread enters. 
		System.out.println("================== [START] TEST CASE FOR EAGER IMPL ==================");
		SingletonEagerLoading eager = SingletonEagerLoading.getInstance();
		System.out.println("Main Thread eager : "+eager.hashCode());
		new Thread(()->{System.out.println("Thread 1 eager : "+SingletonEagerLoading.getInstance().hashCode());}).start();
		
		//Now do some reflection 
		System.out.println(getReflectionHashCode(SingletonEagerLoading.class));
		//System.out.println("Main Thread eager : "+new SingletonEagerLoading());
		System.out.println("\n ================== [END] TEST CASE FOR EAGER IMPL ==================");
		//================== [END] TEST CASE FOR EAGER IMPL ==================
		
		//================== [START] TEST CASE FOR Thread Safe IMPL ================== 
		System.out.println("================== [START] TEST CASE FOR Thread Safe IMPL ==================");
		SingletonThreadSafe obj = SingletonThreadSafe.getInstance();
		
		System.out.println("Thread Safe : "+obj.hashCode());
		
		new Thread(()->{System.out.println("Thread Safe in thread: "+SingletonThreadSafe.getInstance().hashCode());});
		
		System.out.println(getReflectionHashCode(SingletonThreadSafe.class));
		System.out.println("\n================== [END] TEST CASE FOR Thread Safe IMPL ==================");
		//================== [END] TEST CASE FOR Thread Safe IMPL ================== 
		
		
		//================== [START] TEST CASE FOR Thread Safe IMPL ================== 
		System.out.println("================== [START] TEST CASE FOR Thread Safe/Reflection safe IMPL ==================");
		SingletonDoubleCheck doubleCheck = SingletonDoubleCheck.getInstance();
		
		System.out.println("Doulbe check : "+doubleCheck.hashCode());
		
		new Thread(()->{System.out.println("Double check : "+SingletonDoubleCheck.getInstance().hashCode());});
		
		//System.out.println(getReflectionHashCode(SingletonDoubleCheck.class));
		System.out.println("\n================== [END] TEST CASE FOR Thread Safe/Reflection safe IMPL ==================");
		//================== [END] TEST CASE FOR Thread Safe IMPL ================== 
		
		//Now test the singleton for serialization 
		System.out.println("================== [START] TEST CASE FOR Serialization ==================");
		SingletonDoubleCheck doubleCheck2 = SingletonDoubleCheck.getInstance();
		serializeObject(doubleCheck2);
		System.out.println("ser : "+doubleCheck2.hashCode());
		SingletonDoubleCheck deObj = (SingletonDoubleCheck) deserializeObject(doubleCheck2);
		System.out.println("deObj : "+deObj.hashCode());
		
		//Final Singleton class that is thread, reflection and serialization safe
		System.out.println("================== [START] TEST CASE FOR Singleton class that is thread, reflection and serialization safe ==================");
		
		SingletonFullSafe fullSafe = SingletonFullSafe.getInstance();
		
		System.out.println("FUll SAFE : "+fullSafe.hashCode());
		
		new Thread(()->{
			System.out.println("FULL SAFE THREAD : "+SingletonFullSafe.getInstance().hashCode());
		}).start();
		
		serializeObject(fullSafe);
		
		SingletonFullSafe deFullSafe = (SingletonFullSafe) deserializeObject(fullSafe);
		
		System.out.println("Deserialized : "+deFullSafe.hashCode());
		
		System.out.println(getReflectionHashCode(SingletonFullSafe.class));
		
	}
	
	public static void serializeObject(Object obj) {
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(obj.getClass().getSimpleName()+".ser"));
			out.writeObject(obj);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object deserializeObject(Object obj) {
		try {
			ObjectInput in = new ObjectInputStream(new FileInputStream(obj.getClass().getSimpleName()+".ser"));
			obj = in.readObject();
			in.close();
			return obj;
					
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	public static String getReflectionHashCode(Class clazz) {
		try {
			Constructor constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			//You can see the new object all together.
			System.out.println("Reflection : "+constructor.newInstance().hashCode());
			return "Reflection : "+constructor.newInstance().hashCode();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return "Reflection : Safe";
		
	}

}
