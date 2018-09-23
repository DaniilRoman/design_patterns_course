package ClassWork;

import ClassWork.Printable.Sign;
import ClassWork.Printable.Word;
import ClassWork.Printer.Delegate.IPrinterDelegate;
import ClassWork.Printer.Delegate.PrinterDelegate;
import ClassWork.Printer.IPrinter;
import ClassWork.Printer.PrinterDefault;
import ClassWork.Printer.PrinterSpecial;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Word word = new Word("word");
        Sign sign = new Sign("!");
        Text text = new Text(Arrays.asList(word, sign));
        PrinterDefault printerDefault = new PrinterDefault();
        PrinterSpecial printerSpecial = new PrinterSpecial();
//        text.print(printerDefault);
//        text.print(printerSpecial);
        IPrinter prn = new PrinterDelegate();
//        text.print(prn);
//        text.getWords().forEach(prn::print);
        ((PrinterDelegate)prn).print(text.getWords());
    }
}
