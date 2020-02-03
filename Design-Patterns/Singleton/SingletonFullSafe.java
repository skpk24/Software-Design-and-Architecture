package com.ilinks.practice.designpattern.singleton;

import java.io.Serializable;

public class SingletonFullSafe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7604766932017737115L;
	
	private static SingletonFullSafe instance;
	
	private SingletonFullSafe() {
		if(instance != null) {
			throw new RuntimeException("Please use the static getInstance() method to create object "+instance.getClass().getName());
		}
	}
	
	public static SingletonFullSafe getInstance() {
		
		if(instance == null) {
			synchronized(SingletonFullSafe.class) {
				if(instance == null) {
					instance = new SingletonFullSafe();
				}
			}
		}
		
		return instance;
	}
	
	
	//Implement the readResolve() method to overcome the deserialization duplicacy. 
	//Make sure that return type should be Object, otherwise it will not work.
	protected Object readResolve() {
	    return getInstance();
	}
}
