package com.my.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelByPoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\java\\test\\test.xls";
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(path);

			HSSFWorkbook workbook = new HSSFWorkbook(stream);// 读取现有的Excel
			HSSFSheet sheet = workbook.getSheet("teacher");// 得到指定名称的Sheet
			for (Row row : sheet) {
				for (Cell cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
