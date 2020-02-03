


// Classical/Lazy Java implementation of singleton
//Create object whenever getInstance() called.
//design pattern 
public class Singleton {
	private static Singleton singleton;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
}


