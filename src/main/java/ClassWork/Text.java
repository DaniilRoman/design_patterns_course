package ClassWork;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Text {
    private List<IPrintable> words;

    public void print(IPrinter printer) {
        words.forEach(printable -> { printable.print(printer); });
    }
}
