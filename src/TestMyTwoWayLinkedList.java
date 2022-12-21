import java.util.ListIterator;
import java.util.Random;

public class TestMyTwoWayLinkedList {
    public static void main(String[] args) {
        int p = 5;

        // adding values from 1 to p
        System.out.println(p + " random elements btw 0 and 99:");
        MyTwoWayLinkedList<Double> list = new MyTwoWayLinkedList<>();
        Random objGenerator = new Random();

        for (int i = 0; i < p; i++) {
            list.add((double) objGenerator.nextInt(100));
        }
        System.out.println(list+"\n");

        ListIterator<Double> iterator = list.iterator();

        // move forward with next() and set()
        System.out.println("adding 1 to every ele with next() and set()");
        while (iterator.hasNext()) {
            Double n = iterator.next();
            iterator.set(n + 1);
        }
        System.out.println(list+"\n");

        // move backward with previous() and set()
        System.out.println("multiply each element with 3 via previous() and set()");
        while (iterator.hasPrevious()) {
            Double n = iterator.previous();
            iterator.set(n + n + n);
        }
        System.out.println(list+"\n");

        // remove all elements that are multiples of 5 via next() and remove()
        System.out.println("=>  elements after removing multiples of 5 via next() and remove()");
        while (iterator.hasNext()) {
            Double n = iterator.next();
            if (n % 5 == 0) iterator.remove();
        }
        System.out.println(list+"\n");
    }
}
