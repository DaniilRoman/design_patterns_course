package RobustIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
    private Integer value;
    private int size = 0;
    private List<Node> children;
    private Iterator iterator;

    public Node() {
        children = new ArrayList<>();
        Random random = new Random();
        value = random.nextInt(55);
    }

    public void add(Node node) {
        children.add(node);
        size++;
    }

    public void add(List<Node> nodes) {
        children.addAll(nodes);
        size += nodes.size();
    }

    public void printOne() {
        System.out.print("[ " + value + " ]");
    }

    public String toString() {
        return value.toString();
    }

    public void print() {
        printOne();
        if (children.size() == 0) return;
        System.out.print(" |");
        children.forEach(Node::print);
        System.out.print("|| ");
    }

    public void print(String offset) {
        System.out.print("  ");
        printOne();
        if (children.size() > 0) {
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
        if (flag) {
            System.out.println();
        }
        System.out.print("[ " + value + " ]");
        children.forEach(Node::print);
    }

    public Iterator getIterator() {
        return iterator == null ?
                iterator = new Iterator() : iterator;
    }

    public class Iterator {
        int cursor = -1;

        public boolean hasNext() {

            if (cursor == 0 && children.size() == 0) return false;

            return cursor < size;

        }

        public Node next() {
            if (cursor == -1) {
                cursor++;
                return Node.this;
            }

            if(hasNext()) {
                if (children.get(cursor).getIterator().hasNext()) {
                    return children.get(cursor).getIterator().next();
                }
                cursor++;
                return next();
            }
            return null;
        }
    }
}
