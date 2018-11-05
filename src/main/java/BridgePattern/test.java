package BridgePattern;

import BridgePattern.Drawer.DrawerImpl.DrawerConsole;
import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.Composite.HorizontalGroup;
import BridgePattern.Matrix.Composite.VerticalGroup;
import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.Matrix;
import BridgePattern.Matrix.MatrixImpl.MatrixN;
import BridgePattern.Matrix.MatrixImpl.MatrixS;
import BridgePattern.Util.ValuesGen;

public class test {
    public static void main(String[] args) {
        Matrix normalM = new MatrixN(8, 5);
        Matrix sparseM = new MatrixS(5,7);

        ValuesGen.generate(normalM, 10, 80);
        ValuesGen.generate(sparseM, 15, 20);
        VerticalGroup matrix = new VerticalGroup();
        matrix.addMatrix(normalM);
        matrix.addMatrix(sparseM);
        IDrawer drawer = new DrawerConsole();
        matrix.setDrawer(drawer);
        matrix.draw();
    }
}
