package utilities;



import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;

public class ExcelUtility {

    public static void writeHomeLoanTableToExcel(WebDriver driver,
                                                 String fileName,
                                                 String sheetName) {

        int rowCount = driver.findElements(
                        By.xpath("//tr[contains(@class,'yearlypaymentdetails')]"))
                .size();

        int colCount = driver.findElements(
                        By.xpath("//th[contains(@class,'col-lg-1') or contains(@class,'col-sm-2') or contains(@class,'col-sm-3')]"))
                .size();

        try {
            String path = System.getProperty("user.dir")
                    + "\\Output\\"
                    + fileName;

            FileOutputStream file = new FileOutputStream(path);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);

            // Header Row
            XSSFRow headerRow = sheet.createRow(0);

            for (int c = 1; c <= colCount; c++) {

                String header = driver.findElement(
                                By.xpath("(//th[contains(@class,'col-lg-1') or contains(@class,'col-sm-2') or contains(@class,'col-sm-3')])[" + c + "]"))
                        .getText();

                header = header.replace("\n", " ");

                headerRow.createCell(c - 1)
                        .setCellValue(header);
            }

            // Table Data
            for (int r = 1; r <= rowCount; r++) {

                XSSFRow dataRow = sheet.createRow(r);

                for (int c = 1; c <= colCount; c++) {

                    String value = driver.findElement(
                                    By.xpath("(//tr[contains(@class,'yearlypaymentdetails')])[" + r + "]//td[" + c + "]"))
                            .getText();

                    dataRow.createCell(c - 1)
                            .setCellValue(value);
                }
            }

            workbook.write(file);

            workbook.close();
            file.close();

            System.out.println("Excel file created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
