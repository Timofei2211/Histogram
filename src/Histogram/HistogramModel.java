package Histogram;

import Generator.GenerateRandomValues;

import java.util.ArrayList;

public class HistogramModel {
    public static int n1;
    public static int n2;
    public static int n3;
    public static int mean;
    public static int deviation;

    private ArrayList<Double> list;
    private int[] heights;
    private ArrayList<Double> listAveraging;

    public double h;
    public double max;
    public double min;

    public HistogramModel(GenerateRandomValues generateRandomValues) {
        n1 = generateRandomValues.getN1();
        n2 = generateRandomValues.getN2();
        n3 = generateRandomValues.getN3();
        mean = generateRandomValues.getMean();
        deviation = generateRandomValues.getDeviation();
        this.list = generateRandomValues.getList();
        this.heights = generateRandomValues.getHeights();
        this.listAveraging=generateRandomValues.getListAveraging();
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
        return list;
    }

    public int[] getHeights() {
        return heights;
    }

    public ArrayList<Double> getListAveraging() {
        return listAveraging;
    }

    public double getH() {
        int n = 20;
        return (getMax()-getMin())/n;
    }

    public double getMax() {
        return listAveraging.get(listAveraging.size()-1);
    }

    public double getMin() {
        return listAveraging.get(0);
    }
}
