package Painter;

import Histogram.HistogramModel;

import javax.swing.*;
import java.awt.*;

public class GrGis4 extends JFrame {
    public static double y[][] = new double[20][10];
    public static String col[] = {"BLUE", "YELLOW", "GREEN","BLUE", "RED", "YELLOW","BLUE", "RED", "GREEN","YELLOW","RED", "GREEN","BLUE", "YELLOW", "GREEN","BLUE", "RED", "YELLOW","BLUE"};//массив цветов

    public HistogramModel histogramModel;

    public GrGis4(HistogramModel histogramModel) {
        super("Обычная гистограмма");
        this.histogramModel = histogramModel;
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent4(histogramModel), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}