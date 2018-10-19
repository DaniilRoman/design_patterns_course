package BridgePattern;

import BridgePattern.Drawer.DrawerImpl.DrawerConsole;
import BridgePattern.Drawer.DrawerImpl.DrawerGraphic;
import BridgePattern.Drawer.DrawerImpl.DrawerHtml;

import java.util.Arrays;

public class EntryPoint {
    public static void main(String[] args) {
        DrawerGraphic drawerGraphic = new DrawerGraphic();
        DrawerConsole drawerConsole = new DrawerConsole();
        DrawerHtml drawerHtml = new DrawerHtml();

        Client app = new Client(Arrays.asList(drawerHtml, drawerGraphic));
    }
}
