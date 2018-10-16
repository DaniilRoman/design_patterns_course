package BridgePattern;

import BridgePattern.Drawer.DrawerImpl.DrawerConsole;
import BridgePattern.Drawer.DrawerImpl.DrawerGraphic;

import java.util.Arrays;

public class EntryPoint {
    public static void main(String[] args) {
        DrawerGraphic drawerGraphic = new DrawerGraphic();
        DrawerConsole drawerConsole = new DrawerConsole();

        Client app = new Client(Arrays.asList(drawerConsole, drawerGraphic));
    }
}
