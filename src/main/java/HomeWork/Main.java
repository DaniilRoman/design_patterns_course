package HomeWork;

import HomeWork.ClassRooms.ClassRoom;
import HomeWork.Visitors.BadStudent;
import HomeWork.Visitors.Lector;
import HomeWork.Visitors.Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        Student student = new Student();
        BadStudent badStudent = new BadStudent();
        Lector lector = new Lector();
        classRoom.enter(Arrays.asList(lector, student, badStudent));
        classRoom.distribute();
    }
}
