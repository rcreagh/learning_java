public class ResizingArrayStack
{
  // Create array of 'Objects' which will be 'Items' which can be of any data
  // type, yet to be defined.
  private item[] a = (Item[]) new Object[1];
  private int n = 0;

  public boolean isEmpty(){
    return n == 0;
  }

  public int size(){
    return n;
  }

  public void resize(int max){
    // Copy stack to new array of size max.
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; i++){
      temp[i] = a[i];
      a = temp;
    }
  }
  // TODO: Continue from here by implementing 'pop'.
}
