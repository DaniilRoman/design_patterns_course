package BridgePattern.Matrix.Iterator;


import java.util.function.Consumer;
import java.util.function.Function;

public interface IIterator {

    void iterate(DrawItemFunc func);

}
