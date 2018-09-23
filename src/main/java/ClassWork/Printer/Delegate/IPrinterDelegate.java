package ClassWork.Printer.Delegate;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.IPrinter;

import java.util.List;

public interface IPrinterDelegate extends IPrinter {

    void print(List<IPrintable> iPrintable);

}
