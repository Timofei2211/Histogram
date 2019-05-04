package Painter;

import Generator.GenerateRandomValues;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

import static java.awt.Color.RED;

public class DrawingComponent extends JPanel{

    private Graphics gh;

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;

        //горизонтальные линии и обозначения
        for (int i=2; i<9; i++) {
            drp.drawLine(50, 2+50*i, 1100, 2+50*i);
            int vs = 800 - i*100;
            drp.drawString(vs+"", 30, 2+50*i);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i <19 ; i++) {

            drp.drawString(String.valueOf(df.format((GenerateRandomValues.min) + (i * GenerateRandomValues.h))), 110+50*i, 420);

        }

        drp.drawString("Количество выбор. проб(нач.20 000) = "+GenerateRandomValues.n1 , 80, 30);
        drp.drawString("Количество точек выборки(нач. 10) = " +GenerateRandomValues.n2, 80, 50);
        drp.drawString("Количество усреднений(нач. 2 000 ) = "+GenerateRandomValues.n3 , 80, 70);
        drp.drawString("Мат.ожидание = " +GenerateRandomValues.mean  , 680, 40);
        drp.drawString("Среднекв.откл. = " +GenerateRandomValues.deviation, 680, 60);

        drp.setColor(Color.BLUE);
        drp.fillRect(80, 30, 10, 10);
        drp.setColor(RED);
        drp.fillRect(80, 50, 10, 10);
        drp.setColor(Color.GREEN);
        drp.fillRect(80, 70, 10, 10);

        for (int i=0; i<10; i++) {
            //строим саму гистограмму
            //извлекаем цвет для каждого графика
            Color color1 = RED;
            for (int j=0;j<20;j++) {
                try {
                    Field field = Class.forName("java.awt.Color").getField(GrGis.col[j].toLowerCase());
                    color1 = (Color)field.get(null);
                } catch (Exception e) {}
                drp.setColor(color1);
                //переводим полученные данные в реальные координаты
                int realY = (int) (400- GrGis.y[j][i]/2)+3;
                drp.fillRect(70+50*j+100*i, realY, 50,(int) (GrGis.y[j][i]/2));
            }
        }
    }
}