package com.my.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class LoadProp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		InputStream in = LoadProp.class.getClassLoader().getResourceAsStream("config/prop.properties");
		Enumeration<String> en = null;
		String key = null;
		try {			
			prop.load(in);		
			
			en = (Enumeration<String>) prop.propertyNames();
			while (en.hasMoreElements()) {
				key = (String) en.nextElement();
				System.out.println(key);				
			}			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
