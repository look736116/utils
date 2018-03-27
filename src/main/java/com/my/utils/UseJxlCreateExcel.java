package com.my.utils;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class UseJxlCreateExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File("D:\\java\\test\\jxlTest.xls"));
			WritableSheet sheet = book.createSheet(" 第一页 ", 0);
			Label label1 = new Label(0, 0, "姓名");
			Label label2 = new Label(1, 0, "年龄");
			sheet.addCell(label1);
			sheet.addCell(label2);
			book.write();
			book.close();

			Workbook workbook = Workbook.getWorkbook(new File("D:\\java\\test\\jxlTest.xls"));
			Sheet worksheet = workbook.getSheet(0);
			Cell cell1 = worksheet.getCell(0, 0);
			String result = cell1.getContents();
			System.out.println(result);
			workbook.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
