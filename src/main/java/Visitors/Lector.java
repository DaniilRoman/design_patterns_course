package Visitors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lector implements IVisitor {

    private LinkedList<String> lections;

    public Lector() {
        lections = new LinkedList<>(
                Arrays.asList("one", "two", "three", "four", "five")
        );
    }

    @Override
    public void listen(List<String> sound) {
        say(sound);
    }

    private void say(List<String> sounds){
        String newSound = lections.poll();
        if (newSound == null) {
            System.exit(0);
        }
        sounds.add(newSound);
        System.out.println("Lector: "+newSound);
    }

}
