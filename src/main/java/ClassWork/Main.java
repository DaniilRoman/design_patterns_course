package ClassWork;

import ClassWork.Printable.Sign;
import ClassWork.Printable.Word;
import ClassWork.Printer.Delegate.IPrinterDelegate;
import ClassWork.Printer.Delegate.PrinterDelegate;
import ClassWork.Printer.IPrinter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IPrinterDelegate prn = new PrinterDelegate();
        Word word = new Word("word");
        Sign sign = new Sign("!");
        Text text = new Text(Arrays.asList(word, sign));
        prn.print(text);
    }
}
