package BridgePattern.Drawer.DrawerImpl;

import BridgePattern.Drawer.IDrawer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class DrawerGraphic extends JFrame implements IDrawer {

    private JPanel panel;
    private JButton[][] buttons;
    private Integer[][] matrix;
    private int height, width;

    public DrawerGraphic() {
        super("Matrix");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void drawBorder(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new Integer[height][width]; // вынести!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        buttons = new JButton[height][width];
        if(panel != null) { remove(panel); };
        panel = new JPanel();
        panel.setLayout(new GridLayout(height, width));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                buttons[i][j] = new JButton();
                panel.add(buttons[i][j]);
            }
        }
        add(panel);
        setVisible(true);
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) throws IOException {
        buttons[yCord][xCord].setText(Optional.ofNullable(value).orElse(0).toString());
//        panel.updateUI();
//        setVisible(true);
    }

}
