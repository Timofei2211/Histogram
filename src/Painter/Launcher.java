package Painter;

import Excel.ExcelWriter;
import Generator.GenerateRandomValues;
import Histogram.HistogramModel;


public class Launcher {
    public static void main(String[] args) {

        HistogramModel model = new HistogramModel(new GenerateRandomValues());

        for (int i = 0; i < 20; i++) {

            GrGis.y[i][0] = model.getHeights()[i];
        }

        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.saveToFile(model);

        GrGis gr = new GrGis();
        gr.setVisible(true);
    }
}
