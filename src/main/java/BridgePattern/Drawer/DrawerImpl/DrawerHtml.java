package BridgePattern.Drawer.DrawerImpl;

import BridgePattern.Drawer.IDrawer;

import java.io.IOException;
import java.util.Optional;

public class DrawerHtml implements IDrawer {

    String html = "<html>\n<head></head>\n<body>";

    private String[][] matrix;
    private int height, width;

    @Override
    public void drawBorder(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new String[height][width];

        System.out.println(html);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
            System.out.print("<div> ");
                this.matrix[i][j] = " ";
            System.out.print(" </div>");
            }
            System.out.println();
        }

    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        this.matrix[yCord][xCord] = Optional.ofNullable(value).orElse(0).toString();

        System.out.println(html);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                System.out.print("<div>");
                System.out.print(this.matrix[i][j]);
                System.out.print("</div>  ");
            }
            System.out.println();
        }

        System.out.println("</body>\n</html>");
        System.out.println();
    }
}
