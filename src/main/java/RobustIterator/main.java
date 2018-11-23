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

        for (int i = 0; i < 15; i++) {
            System.out.println(tree.getIterator().next());
        }

//        System.out.println();
//        System.out.println(nodes);
//
//        int i = 0;
//
//        for (Iterator<Node> iter = nodes.iterator(); iter.hasNext(); ) {
//            i++;
//            Node a = iter.next();
//            if(i==3) {iter.remove();}
//        }
//
//        System.out.println(nodes);
    }
}
