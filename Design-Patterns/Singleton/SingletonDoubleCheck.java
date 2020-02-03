package com.ilinks.practice.designpattern.singleton;


public class SingletonDoubleCheck{
	
	private static volatile SingletonDoubleCheck instance;
	
	private SingletonDoubleCheck() {
		if(instance != null) {
			throw new RuntimeException("Must use the getInstance() method to get the instances of this class. "+this.getClass().getName());
		}
	}
	
	public static SingletonDoubleCheck getInstance() {
		
		if(instance == null) {
			
			synchronized(SingletonDoubleCheck.class) {
				if(instance == null) {
					instance = new SingletonDoubleCheck();
				}
			}
		}
		
		return instance;
	}
}
