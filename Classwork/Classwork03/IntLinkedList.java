/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  IntLinkedList.java
* Purpose    :  In class exercise workign witin linked lists
* @author    :  B.J. Johnson & M. McPartlan
* Date       :  2018-09-19
* Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
* Notes      :  None
* Warnings   :  None
*
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**/
import java.util.Arrays;


public class IntLinkedList {

  private Node head;
  private int  size;

  // the constructor
  IntLinkedList() {
    head = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public void prepend( int dataToAdd ) {
    Node currentHead = head;
    head = new Node( dataToAdd );
    head.next = currentHead;
    size++;
  }

  public void insertAt( int index, int value) {
    Iterator insLoc = getIteratorAt(index);
    Node newNode = new Node(value);
    newNode.next = insLoc.getNode();
    insLoc = getIteratorAt(index - 1);
    insLoc.currentNode.next = newNode;
  }

  public int removeAt( int index ) {
    Iterator remLoc = getIteratorAt(index - 1);
    Iterator remLocF = getIteratorAt(index + 1);
    Iterator remRet = getIteratorAt(index);
    remLoc.currentNode.next = remLocF.currentNode;
    return remRet.getCurrentInt();
  }

  private class Node {

    int data;            // remember this is an IntLinkedList
    Node next;           // here's the self-referential part

    // constructor
    Node( int d ) {
      data = d;
      next = null;
    }
  }

  public Iterator getIteratorAt( int index ) {
    if ((index > size) || (index < 0)) {
      throw new IllegalArgumentException();
    }
    Iterator it = new Iterator();
    while( index > 0 ) {
      it.next();
      index--;
    }
    return it;
  }

  public class Iterator {
    private Node currentNode;

    Iterator() {
      currentNode = head;
    }

    public void next() {
      if( currentNode == null ) {
        return;
      } else {
        currentNode = currentNode.next;
      }
    }

    public Node getNode() {
      return currentNode;
    }

    public boolean hasNext() {
      return ((currentNode != null) && (currentNode.next != null));
    }

    public int getCurrentInt() {
      return currentNode.data;
    }

  }
}
