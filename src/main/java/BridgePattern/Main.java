package BridgePattern;

import BridgePattern.Drawer.DrawerImpl.DrawerConsole;
import BridgePattern.Drawer.DrawerImpl.DrawerGraphic;
import BridgePattern.Matrix.Matrix;
import BridgePattern.Matrix.MatrixImpl.MatrixN;
import BridgePattern.Matrix.MatrixImpl.MatrixS;
import BridgePattern.Util.Statistic;
import BridgePattern.Util.ValuesGen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Matrix normalM = new MatrixN(5, 5);
        Matrix sparseM = new MatrixS(5,7);

        ValuesGen.generate(normalM, 10, 80);
        ValuesGen.generate(sparseM, 15, 20);

        print(new Statistic(normalM));
        print(new Statistic(sparseM));

//        for (int i=0; i<sparseM.getRows();i++){
//            for (int j=0; j<sparseM.getCols();j++){
//                System.out.println(sparseM.get(i,j));
//            }
//        }

        normalM.setDrawer(new DrawerConsole());
        normalM.draw(true);
        Thread.sleep(1000);
        normalM.setDrawer(new DrawerGraphic());
        normalM.draw(true);
    }

    private static void print(Statistic statistic) {
        System.out.println("Sum: "+statistic.getSum());
        System.out.println("Avg: "+statistic.getAvg());
        System.out.println("Max: "+statistic.maxValue());
        System.out.println("NotNulCount: "+statistic.notNullCount());

        System.out.println("-----------------------------");
    }
}


