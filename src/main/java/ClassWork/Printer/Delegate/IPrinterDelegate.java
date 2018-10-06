package ClassWork.Printer.Delegate;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.IPrinter;
import ClassWork.Text;

public interface IPrinterDelegate extends IPrinter {

    void print(IPrintable text);

}
