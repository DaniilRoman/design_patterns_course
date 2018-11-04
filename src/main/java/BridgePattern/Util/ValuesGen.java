package BridgePattern.Util;

import BridgePattern.Matrix.IMatrix;

import java.util.Random;

public class ValuesGen {

    private static Random r = new Random();

    public static void generate(IMatrix matrix, int count, int maxValue) {
        int rowsCount = matrix.getRows(),
            colsCount = matrix.getCols();
        int row, col;
        Integer elmt;

        if(count > rowsCount*colsCount) {
            count = rowsCount*colsCount;
        }

        for (int i = 0; i<count; i++) {
            while (true) {
                row = r.nextInt(rowsCount);
                col = r.nextInt(colsCount);
                elmt = matrix.get(row, col);
                if (elmt == null || elmt == 0) {
                    matrix.set(row, col, r.nextInt(maxValue) + 1);
                    break;
                }
            }
        }
    }

    public static int genRandom(int limit) {
        return r.nextInt(limit);
    }

}
