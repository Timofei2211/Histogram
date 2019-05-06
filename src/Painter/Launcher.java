package Painter;

import Excel.ExcelWriter;
import Generator.GenerateRandomValues;
import Histogram.HistogramModel;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество выбор. проб(нач.20 000)");
        int n1 = scanner.nextInt();
        System.out.println("Введите количество точек выборки(нач. 10)");
        int n2 = scanner.nextInt();
        System.out.println("Введите количество усреднений(нач. 2 000 )");
        int n3 = scanner.nextInt();
        System.out.println("Введите мат.ожидание");
        int mean = scanner.nextInt();
        System.out.println("Введите среднекв.отклонение");
        int deviation = scanner.nextInt();
        GenerateRandomValues generateRandomValues1 = new GenerateRandomValues(n1, n2, n3, mean, deviation, true);
        HistogramModel model1 = new HistogramModel(generateRandomValues1);
        for (int i = 0; i < model1.getList().size(); i++) {
            System.out.println(model1.getList().get(i));
        }
        GenerateRandomValues generateRandomValues2 = new GenerateRandomValues(n1, n2, n3, mean, deviation, false);
        HistogramModel model2 = new HistogramModel(generateRandomValues2);
        for (int i = 0; i < model2.getList().size(); i++) {
            System.out.println("пошел");
            System.out.println(model2.getList().get(i));
        }
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.saveToFile(model1, model2);


        for (int i = 0; i < 20; i++) {
            GrGis3.y[i][0] = model1.getHeights()[i];
        }
        GrGis3 gr1 = new GrGis3(model1);
        gr1.setVisible(true);

        for (int i = 0; i < 20; i++) {
            GrGis4.y[i][0] = model2.getHeights()[i];
        }
        GrGis4 gr2 = new GrGis4(model2);
        gr2.setVisible(true);
    }
}
