package BridgePattern;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGui extends JFrame {
    private JButton normalButton = new JButton("normal");
    private JButton sparseButton = new JButton("sparse");
    private JTextField heightInput = new JTextField("", 5);
    private JTextField widthInput = new JTextField("", 5);
    private JLabel heightLabel = new JLabel("height:");
    private JLabel widthLebal = new JLabel("width: ");
    private JCheckBox check = new JCheckBox("Available border", false);

    public TestGui() {
        super("Simple Example");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2 - 250,dimension.height/2 - 150,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(heightLabel);
        container.add(heightInput);
        container.add(check);
        container.add(widthLebal);
        container.add(widthInput);

        normalButton.addActionListener(new ButtonEventListener());
        sparseButton.addActionListener(new ButtonEventListener());
        container.add(normalButton);
        container.add(sparseButton);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + heightInput.getText() + "\n";
            message += "CheckBox is " + ((check.isSelected())
                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        TestGui app = new TestGui();
        app.setVisible(true);
    }
}
