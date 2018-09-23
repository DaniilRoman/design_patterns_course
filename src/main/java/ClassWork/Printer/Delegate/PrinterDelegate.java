package ClassWork.Printer.Delegate;


import ClassWork.Printable.IPrintable;
import ClassWork.Printer.PrinterSpecial;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PrinterDelegate extends PrinterSpecial implements IPrinterDelegate {

    @Override
    public void print(List<IPrintable> printables) {
        printables.forEach(printable -> { printable.print(this); });
    }

}
