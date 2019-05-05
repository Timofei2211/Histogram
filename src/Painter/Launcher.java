package Painter;

import Excel.ExcelWriter;
import Generator.GenerateRandomValues;
import Histogram.HistogramModel;

public class Launcher {
    public static void main(String[] args) {
        HistogramModel model = new HistogramModel(new GenerateRandomValues());

        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.saveToFile(model);

//        buildHistogram(model);
//        model.setList(GenerateRandomValues.generateLogList());
//        model.setListAveraging(GenerateRandomValues.generateListAveraging());
//        model.setHeights(GenerateRandomValues.generateHeights());
//        buildHistogram(model);
    }

    public static void buildHistogram(HistogramModel model) {
        for (int i = 0; i < 20; i++) {
            GrGis.y[i][0] = model.getHeights()[i];
        }
        GrGis gr = new GrGis();
        gr.setVisible(true);
    }
}
