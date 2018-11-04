package BridgePattern.Vector.VectorImpl;

import BridgePattern.Vector.IVector;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class VectorS implements IVector{

    private Map<Integer, Integer> values;
    private int length;

    public VectorS(int length) {
        values = new HashMap<>(length);
        this.length = length;
    }

    @Override
    public Integer getSize() {
        return length;
    }

    @Override
    public Integer get(int pos) {
        return values.get(pos);
    }

    @Override
    public void set(int pos, Integer value) {
        values.put(pos, value);
    }

    @Override
    public IVector createVector(int col) {
        return new VectorS(col);
    }
}
