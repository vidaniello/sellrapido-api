package com.github.vidaniello.sellrapido;

import java.lang.reflect.Field;

public abstract class ReflectionUtilities {
	
	
	public String getField(String fieldName) {
		
		try {
		
			Field field = getClass().getDeclaredField(fieldName);

			if(field!=null) {
				field.setAccessible(true);
				return field.get(this).toString();
			}
		} catch (Exception e) {
			//LOG
		}
		
		return "";
	}
	
	
}
