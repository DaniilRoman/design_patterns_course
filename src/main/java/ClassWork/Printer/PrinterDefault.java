package ClassWork.Printer;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.IPrinter;

public class PrinterDefault implements IPrinter {

//    @Override
//    public void print(IPrintable printable) {
//        printable.print(this);
//    }

    @Override
    public void printWord(String s) {
        System.out.print(s);
    }

    @Override
    public void printSign(String s) {
        System.out.print(s);
    }
}
