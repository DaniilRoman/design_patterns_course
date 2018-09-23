package ClassWork.Printer;


public class PrinterSpecial extends PrinterDefault {

    @Override
    public void printWord(String printable) {
        System.out.print("(");
        super.printWord(printable);
        System.out.print(")");
    }
}
