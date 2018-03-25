package com.my.utils;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//define config file path 
		//String path = this.getClass().getClassLoader().getResource("").getPath()+"config/userConfig.xml";
		String path = "src/main/resources/config/userConfig.xml";
		
		
        SAXReader reader = new SAXReader();
		reader.setEncoding("utf-8");
		Document document = null;
		try {
			document = reader.read(new File(path));
			
			Element root = document.getRootElement();
			
			//get user list 
			List<Element> list = root.elements("user");
			Element use1 = list.get(0);
			
			//get user info
			System.out.println(use1.element("userName").getStringValue());
			System.out.println(use1.element("password").getStringValue());
			System.out.println(use1.element("systemId").getStringValue());

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
