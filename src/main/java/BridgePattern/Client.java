package BridgePattern;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.Matrix;
import BridgePattern.Matrix.MatrixImpl.MatrixN;
import BridgePattern.Matrix.MatrixImpl.MatrixS;
import BridgePattern.Util.ValuesGen;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Client extends JFrame {
    private JButton normalButton = new JButton("normal");
    private JButton sparseButton = new JButton("sparse");
    private JTextField heightInput = new JTextField("", 2);
    private JTextField widthInput = new JTextField("", 2);
    private JLabel heightLabel = new JLabel("height:");
    private JLabel widthLabal = new JLabel("width: ");
    private JCheckBox check = new JCheckBox("Available border", false);
    private List<IDrawer> drawers;

    public Client(List<IDrawer> drawers) {
        super("Simple Example");
        this.drawers = drawers;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width/2 - 250,dimension.height/2 - 150,300,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        heightInput.setSize(20, 20);
        widthInput.setSize(20, 20);
        sparseButton.addActionListener(new SparseButtonEventListener());
        normalButton.addActionListener(new NormalButtonEventListener());
        addInContainer(container, Arrays.asList(heightLabel, heightInput,
                widthLabal, widthInput, normalButton, sparseButton));

        setVisible(true);
    }

    class NormalButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MatrixN matrixN = new MatrixN(Integer.valueOf(heightInput.getText()), Integer.valueOf(widthInput.getText()));
            drawAndGenerate(matrixN);
        }
    }

    class SparseButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MatrixS matrixS = new MatrixS(Integer.valueOf(heightInput.getText()), Integer.valueOf(widthInput.getText()));
            drawAndGenerate(matrixS);
        }
    }

    private void drawAndGenerate(Matrix matrix){
        ValuesGen.generate(matrix, 10, 80);
        drawers.forEach(drawer -> {
            matrix.setDrawer(drawer);
            try {
                matrix.draw();
            } catch (InterruptedException | IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void addInContainer(Container container, List<Component> components){
        components.forEach(container::add);
    }

}
