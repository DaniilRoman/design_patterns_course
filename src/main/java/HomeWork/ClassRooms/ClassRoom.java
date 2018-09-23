package HomeWork.ClassRooms;

import HomeWork.Visitors.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

    private List<IVisitor> visitors;
    private List<String> sounds;

    public ClassRoom() {
        visitors = new ArrayList<>(1);
        sounds = new ArrayList<>(1);
    }

    public void distribute() {
        while (true) {
            visitors.forEach(visitor -> visitor.listen(this.sounds));
        }
    }

    public void enter(List<IVisitor> visitors) {
        this.visitors.addAll(visitors);
    }
}
