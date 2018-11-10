package BridgePattern.Matrix;


public interface IDrawbleEx extends IDrawble{
    void drawBorder(int height, int width);
    void drawItem(int yCord, int xCord, Integer value);
}
