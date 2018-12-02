package RobustIterator.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

    List<Element> nodes;
    int size = 0;
    Iterator iterator;
    Element root;

    public Tree() {
        nodes = new ArrayList<>();
    }

    public void add(Element node) {
        nodes.add(node);
        size++;
    }

    public void add(List<Element> nodes) {
        this.nodes.addAll(nodes);
        size += nodes.size();
    }

    public void setRoot(Element node) {
        root = node;
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
            return cursor < size || !stack.empty();
        }

        public Element next() {
            if(root.getIterator().hasNext()) {
                root.getIterator().next();
            }
            return null;
        }
    }
}
