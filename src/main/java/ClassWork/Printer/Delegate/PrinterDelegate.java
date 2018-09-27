package ClassWork.Printer.Delegate;

import ClassWork.Printer.PrinterSpecial;
import ClassWork.Text;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrinterDelegate extends PrinterSpecial implements IPrinterDelegate {

    @Override
    public void print(Text text) {
        text.print(this);
    }

}
