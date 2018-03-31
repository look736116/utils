package com.my.utils;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class UsePoiCreateExcle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\java\\test\\test.xls";

		// create workbook
		Workbook workbook = new HSSFWorkbook();

		// create sheet
		Sheet sheet1 = workbook.createSheet("teacher");
		Sheet sheet2 = workbook.createSheet("student");

		workbook.setActiveSheet(0);

		Row row = sheet1.createRow(0);

		Cell cell1 = row.createCell(0);
		Cell cell2 = row.createCell(1);
		Cell cell3 = row.createCell(2);

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);

		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBottomBorderColor(HSSFColor.RED.index);

		style.setFillPattern(CellStyle.ALT_BARS);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		cell1.setCellValue("姓名");
		cell1.setCellStyle(style);
		cell2.setCellValue("年龄");
		cell3.setCellValue("性别");
		System.out.println("=============");
		try {
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
