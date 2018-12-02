package RobustIterator;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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
        Stack<Iterator> stack;
        int cursor = -1;

        public Iterator() {
            stack = new Stack<Iterator>();
            stack.push(this);
        }

        public boolean hasNext() {

//            if (cursor == 0 && children.size() == 0) return false;

//            System.out.println(cursor);
//            System.out.println(size);
//            System.out.println(stack);
            return cursor < size && !stack.empty();

        }

        public Node next() {

//            Iterator current;
            if(!stack.empty()) {
//                current = stack.peek();
                if (cursor < size) {

                    if (cursor == -1) {
                        cursor++;
                        return Node.this;
                    }

                    if (children.get(cursor).getIterator().hasNext()) {
                        stack.push(children.get(cursor).getIterator());
//                        cursor++;
                        return stack.peek().next();
                    }

                    cursor++;
                    return next();


                } else {
                    stack.pop();
                    return next();
                }
            }

            return null;

//            if (cursor == -1) {
//                cursor++;
//                return Node.this;
//            }
//
//            if(hasNext()) {
//                if (children.get(cursor).getIterator().hasNext()) {
//                    return children.get(cursor).getIterator().next();
//                }
//                cursor++;
//                return next();
//            }
//            return null;
        }
    }
}
