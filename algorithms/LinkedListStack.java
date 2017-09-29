// This program implements a stack using a linked list implementation.
import java.util.Iterator;
import java.util.Random;

public class LinkedListStack<Item> implements Iterable<Item>{
    private Node first;
    private int n = 0;
    
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {return n == 0;}
    public int size() {return n;}

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current.next != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
        Random rand = new Random();
        int count = 0;
        for(int i = 0; i < 10; i++){
            double random = rand.nextFloat();
            System.out.println(random);
            if(random < 0.25 && count > 0){
                int popped_item = lls.pop();
                System.out.println(popped_item);
                count--;
            }
            else{
                lls.push(i);
                count++;
            }
        }
    }
}
