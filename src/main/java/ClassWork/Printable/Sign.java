package ClassWork.Printable;

import ClassWork.Printer.IPrinter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sign implements IPrintable {

    private String sign;

    @Override
    public void print(IPrinter printer) {
        printer.printSign(sign);
    }
}
