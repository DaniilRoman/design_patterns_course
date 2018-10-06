package ClassWork.Printer.Delegate;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.PrinterSpecial;
import ClassWork.Text;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrinterDelegate extends PrinterSpecial implements IPrinterDelegate {

    @Override
    public void print(IPrintable text) {
        text.print(this);
    }

}
