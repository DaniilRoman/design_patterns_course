package BridgePattern;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.Composite.Group;
import BridgePattern.Matrix.Composite.HorizontalGroup;
import BridgePattern.Matrix.Composite.VerticalGroup;
import BridgePattern.Matrix.Decorator.Renumber;
import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.MatrixImpl.MatrixN;
import BridgePattern.Matrix.MatrixImpl.MatrixS;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

import static BridgePattern.Util.ValuesGen.genRandom;
import static BridgePattern.Util.ValuesGen.generate;

public class Client extends JFrame {
    private JButton normalButton = new JButton("normal");
    private JButton sparseButton = new JButton("sparse");
    private JTextField heightInput = new JTextField("", 2);
    private JTextField widthInput = new JTextField("", 2);
    private JLabel heightLabel = new JLabel("height:");
    private JLabel widthLabal = new JLabel("width: ");
    private JCheckBox check = new JCheckBox("Available border", false);
    private JButton horizontalGroupButton = new JButton("horizontal");
    private JButton verticalGroupButton = new JButton("vertical");
    private JButton renumberButton = new JButton("renumber");
    private JButton revertButton = new JButton("revert");
    private List<IDrawer> drawers;
    private IMatrix matrix;
    private Group group;

    public Client(List<IDrawer> drawers) {
        super("Simple Example");
        this.drawers = drawers;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width/2 - 250,dimension.height/2 - 150,300,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,2,2,2));
        heightInput.setSize(20, 20);
        widthInput.setSize(20, 20);
        sparseButton.addActionListener(new SparseButtonEventListener());
        normalButton.addActionListener(new NormalButtonEventListener());
        horizontalGroupButton.addActionListener(new HorizontalGroupButtonEventListener());
        verticalGroupButton.addActionListener(new VerticalGroupButtonEventListener());
        renumberButton.addActionListener(new RenumberButtonEventListener());
        revertButton.addActionListener(new RevertButtonEventListener());
        addInContainer(container, Arrays.asList(heightLabel, heightInput, widthLabal,
                widthInput, normalButton, sparseButton, horizontalGroupButton,
                verticalGroupButton, renumberButton, revertButton));
        setVisible(true);
        Arrays.asList(normalButton, sparseButton, revertButton, renumberButton).forEach(button -> { button.setEnabled(false); });
    }

    class HorizontalGroupButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            onNewGroup(new HorizontalGroup());
        }
    }

    class VerticalGroupButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            onNewGroup(new VerticalGroup());
        }
    }

    class NormalButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            group.addMatrix(new MatrixN(Integer.valueOf(heightInput.getText()), Integer.valueOf(widthInput.getText())));
            generateAndDraw(matrix);
            Arrays.asList(revertButton, renumberButton).forEach(button -> { button.setEnabled(true); });
        }
    }

    class SparseButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            group.addMatrix(new MatrixS(Integer.valueOf(heightInput.getText()), Integer.valueOf(widthInput.getText())));
            generateAndDraw(matrix);
            Arrays.asList(revertButton, renumberButton).forEach(button -> { button.setEnabled(true); });
        }
    }

    class RenumberButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Renumber matrixDecorator = new Renumber(matrix);
            matrixDecorator.renumberCols(genRandom(matrixDecorator.getCols()),
                                         genRandom(matrixDecorator.getCols()));
            matrixDecorator.renumberRows(genRandom(matrixDecorator.getRows()),
                                         genRandom(matrixDecorator.getRows()));
            matrix = matrixDecorator;
            draw(matrix);
        }
    }

    class RevertButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            draw(matrix.getComponent());
        }
    }

    private void generateAndDraw(IMatrix matrix){
        generate(matrix, 10, 80);
        draw(matrix);
    }

    private void draw(IMatrix matrix) {
        drawers.forEach(drawer -> {
            matrix.setDrawer(drawer);
            matrix.draw(true);
        });
    }

    private void addInContainer(Container container, List<Component> components){
        components.forEach(container::add);
    }

    private void onNewGroup(Group groupType) {
        if(group != null) { groupType.addMatrix(group); }
        group = groupType;
        matrix = group;
        Arrays.asList(normalButton, sparseButton).forEach(button -> { button.setEnabled(true); });
    }
}
