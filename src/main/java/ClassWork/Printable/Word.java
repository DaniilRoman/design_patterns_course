package ClassWork.Printable;

import ClassWork.Printer.IPrinter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Word implements IPrintable {

    private String word;

    @Override
    public void print(IPrinter printer) {
        printer.printWord(word);
    }
}
