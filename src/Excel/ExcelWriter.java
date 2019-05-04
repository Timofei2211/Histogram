package Excel;

import Generator.GenerateRandomValues;
import Histogram.HistogramModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelWriter {
    public void saveToFile(HistogramModel model) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Normal");
        ArrayList<Double> numberAveraging = GenerateRandomValues.listAveraging;
        for (int i = 0; i <numberAveraging.size() ; i++) {
            System.out.println("sfdhfg");
            System.out.println(numberAveraging.get(i));
        }
        int[] ar20 = model.getHeights();
        for (int i = 0; i < model.getN1(); i++) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(model.getList().get(i));

            if (i == 0) {
                Cell cell1 = row.createCell(2);
                cell1.setCellValue("МатОжидание");
            }
            if (i == 1) {
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(model.getMean());
            }
            if (i == 0) {
                Cell cell1 = row.createCell(6);
                cell1.setCellValue("РеалМатОжидание1");
            }
            if (i == 1) {
                Cell cell2 = row.createCell(6);
                cell2.setCellValue(GenerateRandomValues.calculateMean(model.getList()));
            }
            if (i == 0) {
                Cell cell1 = row.createCell(7);
                cell1.setCellValue("РеалСреднеКвадратОтклон1");
            }
            if (i == 1) {
                Cell cell2 = row.createCell(7);
                cell2.setCellValue(GenerateRandomValues.getStdDev(model.getList()));
            }

            if (i == 0) {
                Cell cell1 = row.createCell(8);
                cell1.setCellValue("РеалМатОжидание2");
            }
            if (i == 1) {
                Cell cell2 = row.createCell(8);
                cell2.setCellValue(GenerateRandomValues.calculateMean(GenerateRandomValues.listAveraging));
            }
            if (i == 0) {
                Cell cell1 = row.createCell(9);
                cell1.setCellValue("РеалСреднеКвадратОтклон2");
            }
            if (i == 1) {
                Cell cell2 = row.createCell(9);
                cell2.setCellValue(GenerateRandomValues.getStdDev(GenerateRandomValues.listAveraging));
            }
            if (i == 2) {
                Cell cell3 = row.createCell(2);
                cell3.setCellValue("Среднекв.отклонение");
            }
            if (i == 3) {
                Cell cell4 = row.createCell(2);
                cell4.setCellValue(model.getDeviation());
            }
            for (int j = 0; j < model.getN3(); j++) {
                if (i==j){
                Cell cell5 = row.createCell(1);
                cell5.setCellValue(numberAveraging.get(j));
                }
            }
            for (int j = 0; j < 20; j++) {
                if (i==j){
                    Cell cell6 = row.createCell(4);
                    cell6.setCellValue(ar20[j]);
                }
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:/"+String.valueOf(GenerateRandomValues.n1)+"_"+String.valueOf(GenerateRandomValues.n2)+"_"+String.valueOf(GenerateRandomValues.n3)
                    +"_"+String.valueOf(GenerateRandomValues.mean)+"_"+String.valueOf(GenerateRandomValues.deviation)+".xls");
            wb.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
