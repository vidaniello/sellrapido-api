package com.github.vidaniello.sellrapido;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtility {

	
	public static Gson getDefault() {
		return new GsonBuilder().create();
	}
}
