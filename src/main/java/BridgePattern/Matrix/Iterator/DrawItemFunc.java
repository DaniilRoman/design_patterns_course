package BridgePattern.Matrix.Iterator;

@FunctionalInterface
public interface DrawItemFunc {
    void apply(int i, int j, Integer value);
}
