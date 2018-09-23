package ClassWork;

import ClassWork.Printable.IPrintable;
import ClassWork.Printer.IPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Text {
    List<IPrintable> words;

    void print(IPrinter printer) {
        words.forEach(iPrintable -> iPrintable.print(printer));
    }

}
