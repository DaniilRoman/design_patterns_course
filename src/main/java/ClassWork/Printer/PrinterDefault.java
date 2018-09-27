package ClassWork.Printer;

public class PrinterDefault implements IPrinter {

    @Override
    public void printWord(String s) {
        System.out.print(s);
    }

    @Override
    public void printSign(String s) {
        System.out.print(s);
    }
}
