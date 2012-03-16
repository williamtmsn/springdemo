package com.ares.util;

import java.io.IOException;
import java.io.InputStream;

public class JSON {
	public static final String serialize(Object obj) {
		CustomObjectMapper mapper = new CustomObjectMapper();
		
		String res = null;
		try {
			res = mapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static final <T> T deserialize(String json, Class<T> classType) {
		CustomObjectMapper mapper = new CustomObjectMapper();
		T obj = null;
		try {
			obj = mapper.readValue(json, classType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static final <T> Object deserialize(InputStream is, Class<T> classType) {
		CustomObjectMapper mapper = new CustomObjectMapper();
		Object obj = null;
		try {
			obj = mapper.readValue(is, classType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}