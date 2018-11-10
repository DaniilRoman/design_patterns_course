package BridgePattern.Matrix.Iterator;


import BridgePattern.Matrix.IMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AbstractIterator {

    private List group;

    public AbstractIterator() {
        group = new ArrayList();
    }

    public void add(IMatrix matrix) {
        group.add(matrix);
    }

    public void forEach(Function func) {
        group.forEach(el -> {func.apply(el);});
    }

}
