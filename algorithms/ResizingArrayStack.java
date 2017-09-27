import java.util.Iterator;
import java.util.Random;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
  // Create array of 'Objects' which will be 'Items' which can be of any data
  // type, yet to be defined.
  private Item[] a = (Item[]) new Object[1];
  private int n = 0;

  public boolean isEmpty() {return n == 0;}

  public int size() {return n;}

  public void resize(int max){
    // Copy stack to new array of size max.
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; i++){
      temp[i] = a[i];
    }
    a = temp;
  }
  public void push(Item item){
    // Add item to the top of the stack.
    if(n == a.length){resize(2*a.length);}
    a[n++] = item;
  }
  public Item pop(){
    Item item = a[--n];
    a[n] = null; // This is to remove loitering.
    if(n > 0 && n == a.length/4){
      resize(a.length/2);
    }
  return item;
  }
  // Iterator implemented so that 'foreach item in the stack' can be
  // called on the stack, and the array implementation does not need
  // to be known.
  public Iterator<Item> iterator(){
    return new ReverseArrayIterator();
  }
  private class ReverseArrayIterator implements Iterator<Item>{
    private int i = n - 1;
    public boolean hasNext() {return i >= 0;}
    public Item next() {return a[i--];}
  }
  // Create test client.
  public static void main(String[] args){
    ResizingArrayStack<Integer> ras = new ResizingArrayStack<Integer>();
    Random rand = new Random();
    int count = 0;
    for(int i = 0; i < 10; i++){
      double random = rand.nextFloat();
      System.out.println(random);
      if(random < 0.25 && count > 0){
        int popped_item = ras.pop();
        System.out.println(popped_item);
        count--;
      }
      else{
        ras.push(i);
        count++;
      }
    }
    System.out.println(ras.size());
  }
}
