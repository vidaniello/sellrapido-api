package com.github.vidaniello.sellrapido;

import java.lang.reflect.Field;

public abstract class ReflectionUtilities {
	
	/**
	 * If request for example 'id' or 'code', it return the string representation of these
	 * variables.
	 * <br>
	 * If request 'courier_info.courier_box_type', it assume that the first part 'courier_info' is an object, than
	 * return the string reprensentation 'courier_box_type' of the object 'courier_info'
	 * @param fieldName
	 * @return
	 */
	public String getField(String fieldName) {
		
		try {
			
			boolean nestedObject = false;
			String fildN = fieldName;
			String remainFiled = "";
			
			if(fieldName.contains(".")) {
				nestedObject = true;
				fildN = fieldName.substring(0, fieldName.indexOf("."));
				remainFiled = fieldName.substring(fieldName.indexOf(".")+1);
			}
			
			Field field = getClass().getDeclaredField(fildN);

			if(field!=null) {
				field.setAccessible(true);
				
				if(nestedObject) {
					
					ReflectionUtilities rui = (ReflectionUtilities) field.get(this);
					
					return rui.getField(remainFiled);
					
				} else				
					return field.get(this).toString();
			}
				
			
		} catch (Exception e) {
			//LOG
		}
		
		return "";
	}
	
	
}
