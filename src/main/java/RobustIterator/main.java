package RobustIterator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<Node> nodes = Stream.generate(Node::new).limit(10).collect(Collectors.toList());
        List<Node> nodes1 = Stream.generate(Node::new).limit(3).collect(Collectors.toList());
        nodes.get(3).add(nodes1);
        Node tree = nodes.get(0);
        nodes.stream().skip(1).forEach(tree::add);

        tree.print();

        System.out.println();
        System.out.println(nodes);

        for (Iterator<Node> iter = nodes.listIterator(); iter.hasNext(); ) {
            Node a = iter.next();
            iter.remove();
        }

        System.out.println(nodes);
    }
}
