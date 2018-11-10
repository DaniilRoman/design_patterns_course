package BridgePattern.Util;

import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.Matrix;

import java.util.function.Function;

public class Statistic {

    private IMatrix matrix;
    private int rowsCount, colsCount;

    public Statistic(IMatrix matrix) {
        this.matrix = matrix;
        rowsCount = matrix.getRows();
        colsCount = matrix.getCols();
    }

    public int getSum() {
        int sum = 0;
        for(int i=0; i<rowsCount; i++) {
            for(int j=0; j<colsCount; j++) {
                sum += apply(matrix.get(i, j), 0, w->w);
            }
        }
        return sum;
    }

    public int getAvg() {
        return getSum()/(rowsCount*colsCount);
    }

    public int maxValue() {
        int max = 0, value;
        for(int i=0; i<rowsCount; i++) {
            for(int j=0; j<colsCount; j++) {
                value = apply(matrix.get(i, j), max, w->w);
                if (value > max) { max = value; }
            }
        }
        return max;
    }

    public int notNullCount() {
        int count = 0;
        for(int i=0; i<rowsCount; i++) {
            for(int j=0; j<colsCount; j++) {
                count+=apply(matrix.get(i, j),0, w->1);
            }
        }
        return count;
    }

    private Integer apply(Integer valueForCheck, Integer orElse, Function<Integer, Integer> func) {
        if(valueForCheck!=null) {
            return func.apply(valueForCheck);
        }
        return orElse;
    }
}
