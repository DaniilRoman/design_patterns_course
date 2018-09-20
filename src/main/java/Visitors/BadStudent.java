package Visitors;

import java.util.ArrayList;
import java.util.List;

public class BadStudent implements IVisitor {
    private List<String> notebook;
    private int index;

    public BadStudent() {
        notebook = new ArrayList<>(1);
        index = 0;
    }

    @Override
    public void listen(List<String> sound) {
        write(sound.get(index++));
    }

    private void write(String sound) {
        if (index % 2 == 0) {
            notebook.add(sound);
            System.out.println("BadStudent: " + sound);
        }
    }
}
