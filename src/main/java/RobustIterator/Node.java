package RobustIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
    private Integer value;
    private List<Node> children;

    public Node() {
        children = new ArrayList<>();
        Random random = new Random();
        value = random.nextInt(55);
    }

    public void add(Node node) {
        children.add(node);
    }

    public void add(List<Node> node) {
        children.addAll(node);
    }

    public void printOne() {
        System.out.print("[ " + value + " ]");
    }

    public String toString() {
        return value.toString();
    }

    public void print() {
        printOne();
        if(children.size()>0) {
            System.out.print("  ");
            children.get(0).printOne();
        }
        children.stream().skip(1).forEach(Node::print);
    }

    public void print(String offset) {
        System.out.print("  ");
        printOne();
        if(children.size()>0) {
            System.out.print("  ");
            children.get(0).printOne();
        }
        System.out.println();
        children.stream().skip(1).forEach(node -> {
            System.out.print(offset);
            node.print(offset + offset);
        });
    }

    public void print(boolean flag) {
        if(flag) {
            System.out.println();
        }
        System.out.print("[ " + value + " ]");
        children.forEach(Node::print);
    }
}
