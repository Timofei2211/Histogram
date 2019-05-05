package Painter;

import Excel.ExcelWriter;
import Generator.GenerateRandomValues;
import Histogram.HistogramModel;

public class Launcher {
    public static void main(String[] args) {

        HistogramModel modelNormal = new HistogramModel(new GenerateRandomValues(GenerateRandomValues.Selection.NORMAl));
        ExcelWriter excelWriter1 = new ExcelWriter();
        excelWriter1.saveToFile(modelNormal);
        buildHistogram(modelNormal);

        HistogramModel modelLogNormal = new HistogramModel(new GenerateRandomValues(GenerateRandomValues.Selection.LOGNORMAL));
        ExcelWriter excelWriter2 = new ExcelWriter();
        excelWriter2.saveToFile(modelNormal);
        buildHistogram(modelLogNormal);
    }

    public static void buildHistogram(HistogramModel model) {
        for (int i = 0; i < 20; i++) {
            GrGis.y[i][0] = model.getHeights()[i];
        }
        GrGis gr = new GrGis();
        gr.setVisible(true);
    }
}
