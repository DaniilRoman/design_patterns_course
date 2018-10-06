package BridgePattern;

import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;

public class TestConsoleCreation {
//    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
//        Console console = System.console();
//        if (console == null && !GraphicsEnvironment.isHeadless()) {
//            String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
//            Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd", "/k", "java -jar \"" + filename + "\""});
//            System.out.println("teeeeest");
//        } else {
////                THEMAINCLASSNAMEGOESHERE.main(new String[0]);
//            System.out.println("Program has ended, please type 'exit' to close the console");
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello. Please write your name: ");
        String name = br.readLine();
        System.out.println("Your name is: "+name);
    }
}
