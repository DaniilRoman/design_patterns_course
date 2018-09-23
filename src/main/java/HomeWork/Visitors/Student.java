package HomeWork.Visitors;

import java.util.ArrayList;
import java.util.List;

public class Student implements IVisitor{
    private List<String> notebook;
    private int index;

    public Student() {
        notebook = new ArrayList<>(1);
        index = 0;
    }

    @Override
    public void listen(List<String> sound) {
        write(sound.get(index++));
    }

    private void write(String sound) {
        notebook.add(sound);
        System.out.println("Student: " + sound);
    }
}
