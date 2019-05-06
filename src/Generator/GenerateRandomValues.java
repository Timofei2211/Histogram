package Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenerateRandomValues {

    private int n1;
    private int n2;
    private int n3;
    private int mean;
    private int deviation;
    private ArrayList<Double> listValues;
    public int[] heights;

    public ArrayList<Double> listAveraging;

    public double h;
    public double max;
    public double min;

    private static double second;
    private static boolean secondValid = false;

    double[] data;
    int size;

    public enum Selection {
        NORMAL, LOGNORMAL
    }

    public GenerateRandomValues(int n1, int n2, int n3, int mean, int deviation,boolean isNormal) {
        this.n1=n1;
        this.n2=n2;
        this.n3=n3;
        this.mean=mean;
        this.deviation=deviation;
        if(isNormal) {
                this.listValues = generateList(); }
                else {
            this.listValues = generateLogList();

        }
        this.listAveraging=generateListAveraging();                         //////////////////////////////////////////
        this.heights = generateHeights();
        this.max = listAveraging.get(listAveraging.size()- 1);
        this.min = listAveraging.get(0);
        int n = 20;
        this.h = (max - min) / n;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public int getN3() {
        return n3;
    }

    public int getMean() {
        return mean;
    }

    public int getDeviation() {
        return deviation;
    }

    public ArrayList<Double> getList() {
        return listValues;
    }

    public int[] getHeights() {
        return heights;
    }

    public ArrayList<Double> getListAveraging() {
        return listAveraging;
    }

    public ArrayList<Double> generateList() {
        ArrayList<Double> list = new ArrayList<>();
        {
            for (int i = 0; i < n1; i++) {
                list.add(normal(mean, deviation));
            }
        }
        Collections.sort(list);
        for (int i = 0; i < n1; i++) {
            System.out.println("кек");
            System.out.println(list.get(i));
        }
        return list;
    }

    public ArrayList<Double> generateLogList() {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            list.add(normal(mean, deviation));
        }
        ArrayList<Double> listLog = new ArrayList<>();
        {
            for (int i = 0; i < n1; i++) {
                listLog.add(Math.exp(list.get(i)));
            }
        }
        Collections.sort(listLog);
        return listLog;
    }

    public int[] generateHeights() {
        double max = listAveraging.get(listAveraging.size()- 1);
        double min = listAveraging.get(0);
        int n = 20;
        double h = (max - min) / n;

        int [] heights = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 20; i++) {
            heights[i] = 0;
            for (int j = 0; j < listAveraging.size(); j++) {
                if ((listAveraging.get(j) <= min + (i + 1) * h) && (listAveraging.get(j)> (min + (i * h)))) {
                    heights[i] += 1;
                }
            }
        }
        return heights;
    }


    public ArrayList<Double> generateListAveraging() {       ///// для вывода 2го массива в Excel
        ArrayList<Double> numberAveraging = new ArrayList<>();
        for (int i = 0; i < n3; i++) {
            ArrayList<Double> numberRandomValues = new ArrayList<>();
            for (int j = 0; j < n2; j++) {
                numberRandomValues.add(listValues.get((int) Math.floor(Math.random() * listValues.size())));
                //   System.out.println("Рандомное значение из 20000  " + array2[j]);
            }
            double sum = 0;
            for (int j = 0; j < n2; j++) {
                sum = sum + numberRandomValues.get(j);
                //   System.out.println(sum);
            }
            double meanNumberRandomValues;
            meanNumberRandomValues = sum / numberRandomValues.size();
            numberAveraging.add(meanNumberRandomValues);
            //  System.out.println("Среднее из 10 = " + array3[i]);
        }
        Collections.sort(numberAveraging);
        return numberAveraging;////сортировка массива из 2000 элементов
    }

    public static double normal(double mean, double std) {
        double v1, v2, y1, y2, x1, x2, w;

        if (secondValid) {
            secondValid = false;
            return second;
        }

        do {
            v1 = 2 * Math.random() - 1;
            v2 = 2 * Math.random() - 1;
            w = v1 * v1 + v2 * v2;
        } while (w > 1);

        y1 = v1 * Math.sqrt(-2 * Math.log(w) / w);
        y2 = v2 * Math.sqrt(-2 * Math.log(w) / w);
        x1 = mean + y1 * std;
        x2 = mean + y2 * std;
        second = x2;
        secondValid = true;
        return x1;
    }

        public static double getVariance(ArrayList<Double> list) {
            double mean = calculateMean(list);
            double temp = 0;
            for(Double number : list)
                temp += (number-mean)*(number-mean);
            return temp/(list.size()-1);
        }

        public static double getStdDev(ArrayList<Double> list) {
            return Math.sqrt(getVariance(list));
        }

    public static double calculateMean(ArrayList<Double> list) {
        Double sum = 0.0;
        for(Double number : list) {
            sum = sum + number;
        }
        return sum/list.size();
    }

}
