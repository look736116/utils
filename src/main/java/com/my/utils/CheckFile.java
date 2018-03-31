package com.my.utils;

import java.io.File;

public class CheckFile {
	public static void main(String[] args) {
		String path = "D://java//jdk";
		File folder= new File(path);
		checkFile(folder);
	}

	private static void checkFile(File folder) {
		
		File[] fileList =folder.listFiles();
		
		for (File file : fileList) {
			if(file.isDirectory()){
				checkFile(file);
			}else {
				System.out.println(file.getName());
			}			
		}

	}
}
