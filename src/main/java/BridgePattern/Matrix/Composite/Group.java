package BridgePattern.Matrix.Composite;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

abstract public class Group implements IMatrix {
    protected List<IMatrix> group;
    protected IDrawer drawer;
    protected Integer currentMax = 0, currentIndex = 0, currentOffset = 0;
    protected Map<Integer, Integer> getaway, offsets;

    public Group() {
        group = new ArrayList<>();
        getaway = new HashMap<Integer, Integer>();
        offsets = new HashMap<Integer, Integer>();
    }

    protected void addMatrix(IMatrix matrix, int border) {
        group.add(matrix);
        for (int i=0; i<border; i++) {
            getaway.put(currentMax++, currentIndex);
        }
        offsets.put(currentIndex, currentOffset);
        currentOffset+=border;
        currentIndex++;
    }

    protected int getSum(Function<IMatrix, Integer> func) {
        int sum = 0;
        for (IMatrix matrix: group) {
            sum += func.apply(matrix);
        }
        return sum;
    }

    protected int getMax(Function<IMatrix, Integer> func) {
        int max = 0;
        Integer border;
        for (IMatrix matrix: group) {
            border = func.apply(matrix);
            if(border>max) {
                max = border;
            }
        }
        return max;
    }
}
