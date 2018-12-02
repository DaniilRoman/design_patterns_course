package RobustIterator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Element {
    private Integer value;
    public int size = 0;
    private List<Element> children;
    private Iterator iterator;

    public Element() {
        children = new ArrayList<>();
        Random random = new Random();
        value = random.nextInt(55);
    }

    public void add(Element node) {
        children.add(node);
        size++;
    }

    public void add(List<Element> nodes) {
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
        children.forEach(Element::print);
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
        children.forEach(Element::print);
    }

    public Iterator getIterator() {
        return iterator == null ?
                iterator = new Iterator() : iterator;
    }

    public class Iterator {
        Stack<Iterator> stack;
        int cursor = -1;

        public Iterator() {
            stack = new Stack<Iterator>();
            stack.push(this);
        }

        public boolean hasNext() {
            return cursor < size;
        }

        public Element next() {
            if(hasNext()) {
                if(cursor == -1) {
                    cursor++;
                    return Element.this;
                }
                return children.get(cursor++);
            }

            return null;
        }
    }
}

