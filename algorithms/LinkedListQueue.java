// This program implements a queue using a linked list.
import java.util.Random;
import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n; // Defaults to zero.
    
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {return n == 0;}
    public int size() {return n;}

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {first = last;}
        else {oldlast.next = last;}
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) {last = null;}
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> llq = new LinkedListQueue<Integer>();
        Random rand = new Random();

        for(int i = 0; i < 10; i++) {
            double random = rand.nextFloat();
            System.out.println(random);
            if (random < 0.25 && !llq.isEmpty()) {
                int dequeued_item = llq.dequeue();
            System.out.println(dequeued_item);
            }
            else {llq.enqueue(i);}
        }
        for(Integer i: llq) {System.out.println(i);}
    }
}
