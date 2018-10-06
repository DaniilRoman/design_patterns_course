package BridgePattern.Util;

import BridgePattern.Matrix.Matrix;

import java.util.Random;

public class ValuesGen {

    public static void generate(Matrix matrix, int count, int maxValue) {
        int rowsCount = matrix.getRows(),
            colsCount = matrix.getCols();
        Random r = new Random();
        int row, col;
        Integer elmt;

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

}
