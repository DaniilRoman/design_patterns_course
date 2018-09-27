package ClassWork.Printer.Delegate;

import ClassWork.Printer.IPrinter;
import ClassWork.Text;

public interface IPrinterDelegate extends IPrinter {

    void print(Text text);

}
