package BridgePattern.Vector;

public interface IVector {
    Integer getSize();
    Integer get(int pos);
    void set(int pos, int value);
    IVector createVector(int col);
}
