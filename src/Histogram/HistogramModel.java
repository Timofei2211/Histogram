package Histogram;

import Generator.GenerateRandomValues;

import java.util.ArrayList;

public class HistogramModel {
    private int n1;
    private int n2;
    private int n3;
    private int mean;
    private int deviation;
    private ArrayList<Double> list;
    private int[] heights;
    private ArrayList<Double> listAveraging;

    public HistogramModel(GenerateRandomValues generateRandomValues) {
        this.n1 = generateRandomValues.getN1();
        this.n2 = generateRandomValues.getN2();
        this.n3 = generateRandomValues.getN3();
        this.mean = generateRandomValues.getMean();
        this.deviation = generateRandomValues.getDeviation();
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

    public void setList(ArrayList<Double> list) {
        this.list = list;
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
}
