import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *  Makes a Linked List that is used in other files.
 * 
 *  @author Abdikarim Abdirahman
 *  @param <T> the Generic T for the type 
 * 
 */

public class AttachedList<T> implements List<T> {
 /**
  *  Node class.
  *  @param <T> the Generic T for the type 
  * 
  */

 private static class Node<T> {


  /** value.
   *  @param T
   *  the value of the node.
   */
  T value;

  /** next.
   *  @param T
   * the memory pointing to the next node.
   */
  Node<T> next;
  public Node(int data)
  {
    
  }


 }

 /**
  * head node.
  * @param T
  * head of the LinkedList.
  * 
  * 
  */
 private Node<T> head = null;
 /**
  * tail node.
  * @param T
  * tail of the LinkedList.
  * 
  * 
  */
 private Node<T> tail= null;
 /** 
  * size of the LinkedList.
  * 
  * 
  */
 private int size=0;








 /**
  *  default constructor.
  */
 public AttachedList() 
 {


 }

 /**
  *  tells you the size of AttachedList.
  *  @return size returns the size.
  */
 @Override
 public int size() {
  return size;

 }

 /**
  *  tells you if the list is empty.
  *  @return bool.
  */
 @Override 
 public boolean isEmpty() {
  boolean bool =false;
  if (size()==0)
  {
   bool=true;
  }

  return bool;

 }


 /**
  *  tells you the index of a Object.
  *  @param  o the object you are looking for.
  *  @return index it returns the index of a Object.
  */
 @Override
 public int indexOf(Object o) {
  int index=-1;
  int count=0;
  
  Node<T> temp= new Node<T> (5);
  temp= head;
  while(temp!=null)
  {
   if (!(temp.value==o))
   {
    count++;

   }
   if (temp.value==o)
   {
    index=count;
    break;
   }



   temp=temp.next;
  }


  return index;

 }

 /**
  *  tells you if a object is in a AttachedList.
  *  @param  o the object you are looking for.
  *  @return bool.
  */
 @Override

 public boolean contains(Object o) {

  boolean bool=false;
  Node<T> temp= head;
  while(temp!=null)
  {
   if (temp.value==(o))
   {
    bool=true;
   }
   temp=temp.next;

  }
  return bool;

 }

 /**
  *  adds something at the end of AttachedList.
  *  @param e what you want to append.
  *  @return true.
  */
 @Override
 public boolean add(T e) {
  Node<T> node= new Node<T>();

  node.next=null;
  node.value=e;

  if (head==null)
  {
   head=node;
   tail=head;


  }


  else
  {
   tail.next=node;
   tail=node;

  }





  size++;

  return true;

 }

 /**
  *  adds something at the end of BetterArray.
  *  @param index where you want to add it 
  *  @param element what you want to add it
  */
 @Override
 public void add(int index, T element) {
  String error="Index: "+index+", Size: "+size();

  if (index< 0 || index > size())
  {
   throw new IndexOutOfBoundsException(error);

  }
  Node<T> temp= head;
  Node<T> node= new Node<T>();
  node.next=null;
  node.value=element;


  if (index==0)
  {
   node.next = head;
   head = node;


   if (node.next==null)
   {
    tail=node;
   }


  }




  else
  {

   int count=0;
   while(temp!=null)
   {

    if (count==index-1)
    {

     node.next=temp.next;
     temp.next=node;
     if (node.next==null)
     {
      tail=node;
     }
    }

    temp=temp.next; 
    count++;

   }

  }
  size++;

 }

 /**
  *  removes something in AttachedList at an index.
  *  @param index what you want to append
  *  @return old it returns the thing you remove
  */
 @Override
 public T remove(int index) {
  String error="Index: "+index+", Size: "+size();


  if (index< 0 || index >= size())
  {
   throw new IndexOutOfBoundsException(error);
  }
  T old =null;

  int count=0;
  if (index==0)
  {
   old=head.value;
   head=head.next;


  }

  else
  {
   Node<T> temp= head;


   while(temp!=null)
   {

    if (count==index-1)

    {
     old=temp.next.value;
     temp.next=temp.next.next;
     if (temp.next==null)
     {
      tail=temp;
     }


    }


    count++;
    temp=temp.next;

   }

  }
  size--;



  return old;


 }

 /**
  *  checks the object type.
  *  @param o what you want to remove
  *  @return bool
  */
 public boolean check(Object o)
 {

  if (o==null)
  {

   return false;
  }


  else
  {
   return true;
  }   





 }


 /**
  *   checks the next value.
  *  @param o the object I look at 
  *  @param temp the node I check
  *  @return true
  */

 public boolean nullc(Object o, Node<T> temp)
 {

  if (temp.value==null)
  {

   return false;
  }


  if (temp.value.equals(o))
  {
   return true;
  }   

  else
  {
   return false;
  }



 }

 /**
  *  removes something in AttachedList at an Object.
  *  @param o what you want to remove
  *  @return true
  */
 @Override
 public boolean remove(Object o) {
  boolean bool=false;


  if (o==null)

  {
   if (head.value==null)
   {

    head=head.next;

   }
  }




  if (head.value.equals(o))
  {
   head=head.next;
  }



  else
  {
   if (check(o))
   {

    int count=0;
    Node<T> temp =head;
    while(count<size()-1 && !(nullc(o,temp.next)))
    {

     temp=temp.next;
     count++;
    }


    if (count==size()-1)
    {
     return false;

    }


    if(nullc(o,temp.next))

    {

     temp.next=temp.next.next;
    }

    if (temp.next==null)
    {
     tail=temp;
    }
   }



   if (!check(o))
   {
    int count=0;

    Node<T> temp =head;
    while(count<size()-1 && temp.next.value!=null)
    {

     temp=temp.next;
     count++;

    }
    if (count==size()-1)
    {
     return false;

    }
    if(temp.next.value==null)

    {

     temp.next=temp.next.next;
    }

    if (temp.next==null)
    {
     tail=temp;
    }
   }




  }



  size--;

  return true;

 }

 /**
  *  clears AttachedList.
  */
 @Override
 public void clear() {
  Node<T> temp = null;
  head=temp;
  size=0;

 }

 /**
  *  gets something in AttachedList at an index.
  *  @param index what you want to get in AttachedList.
  *  @return temp.value
  */
 @Override
 public T get(int index) {

  String error="Index: "+index+", Size: "+size();

  if (index< 0 || index >=size())
  {
   throw new IndexOutOfBoundsException(error);
  }

  Node<T> temp= head;
  int count=0;
  while(count<index)
  {
   count++;
   temp=temp.next;
  }


  return temp.value;



 }

 /**
  *  sets something at the index with an element .
  *  @param index what you want to change 
  *  @param element what you want to change it to
  *  @return temp.value what you set it to 
  */
 @Override
 public T set(int index, T element) {


  String error="Index: "+index+", Size: "+size();
  if (index< 0 || index >=size())
  {
   throw new IndexOutOfBoundsException(error);
  }
  Node<T> temp= head;
  int count=0;
  while(count<index)
  {
   count++;

   temp=temp.next;
  }
  temp.value=element;
  return temp.value;

 }

 /**
  *  slices the original list from a index to another one.
  *  @param fromIndex where you start to slice
  *  @param toIndex where you end the slice
  *  @return list it returns the length of the array same as  capacity
  */
 public AttachedList<T> slice(int fromIndex, int toIndex) {

  if (fromIndex> toIndex)
  {
   throw new UnsupportedOperationException("Not supported.");
  }

  String error="fromIndex: "+fromIndex+" inIndex: "+toIndex+", Size: "+size();
  if ((fromIndex< 0 || fromIndex >=size()) || (toIndex< 0 || toIndex >=size()) )
  {
   throw new UnsupportedOperationException(error);
  }



  Node<T> temp= head;
  AttachedList<T>  list= new AttachedList<T> ();
  AttachedList<T>  var= new AttachedList<T> ();

  int index=0;
  while(temp!=null)
  {
   if ((index>=fromIndex && index<=toIndex))
   {
    list.add(temp.value);
   }
   else
   {
    var.add(temp.value);

   }
   head=var.head;
   tail=var.tail;
   index++;
   temp=temp.next;
   size=var.size();


  }
  return list;

 }




 /**
  *  makes a copy of the list and reverses it.
  *  @return list returns a copy of the reversed list 
  */

 public AttachedList<T> reverseCopy() {
  AttachedList<T>  list= new AttachedList<T>();

  Node<T> temp= head;

  while(temp!=null)
  {
   list.add(0,temp.value);
   temp=temp.next;

  } 


  return list;

 }
 /**
  *  gets a 2-D AttachedList and "flattens" it and makes it 1-D.
  *  @param packedList the 2-D AttachedList
  *  @param <E> E.
  *  @return list the 1-D AttachedList
  */

 public static <E> AttachedList<E> flatten(AttachedList<AttachedList<E>> packedList) {
  AttachedList<E> list= new AttachedList<E>();
  for (int i=0;i<packedList.size();i++)
  {

   for (int j=0;j<packedList.get(i).size();j++)
   {

    list.add(packedList.get(i).get(j));
   }

  }

  return list;
 }



 /**
  *  Gets a 1-D AttachedList and makes it a 2-D AttachedList based on if the number changes.
  *  @param flatList the 1-D AttachedList
  *  @param <E> E.
  *  @return one the 2-D AttachedList 
  */
 public static <E> AttachedList<AttachedList<E>> pack(AttachedList<E> flatList) {

  AttachedList<AttachedList<E>> one= new AttachedList<AttachedList<E>>();

  int i=0;
  int a=0;
  while (i<flatList.size())
  {
   AttachedList<E> two= new AttachedList<E>();
   while (flatList.get(i)==flatList.get(a))
   {
    two.add(flatList.get(i));
    a+=1;
    if (a>=flatList.size())
    {
     break;
    }
   }


   i=a;
   one.add(two);


  }

  return one;





 }

 /**
  *  Iterator.
  *  @return Iterator.
  */
 @Override
 public Iterator<T> iterator() {

  return new Iterator<T>() {
   /**
    * the head/current.
    *  @param T
    * head of the LinkedList.
    */


   private Node<T> current = head;

   /**
    *  checks if the AttachedList has next.
    *  @return bool 
    */
   @Override
   public boolean hasNext() {
    boolean bool=false;

    if (current!=null)
    {
     bool=true;
    }
    else
    {
     bool=false;
    }
    return bool;

   }

   /**
    *  returns what is next in the AttachedList.
    *  @return current.value what is next the value
    */
   @Override
   public T next() {


    if (!hasNext())
    {
     throw new NoSuchElementException("NoSuchElementException");
    }
    T ans=current.value;


    current=current.next;


    return ans;

   }
  };
 }


 // --------------------------------------------------------
 // testing code goes here... edit this as much as you want!
 // --------------------------------------------------------
 /**
  *  toString.
  *  @return super.toString()
  */
 public String toString() {
  //you may edit this to make string representations of your
  //list for testing
  return super.toString();
 }


 /**
  *  main method.
  *  @param args main method
  */
 public static void main(String[] args) {
 }


 // --------------------------------------------------------
 // DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
 // --------------------------------------------------------


 /**
  *  toArray(). 
  *  @return items
  */

 @Override
 public Object[] toArray() {
  Object[] items = new Object[this.size()];

  int i = 0;
  for(T val : this) {

   items[i++] = val;
  }

  return items;
 }

 /**
  *  toArray().
  *  @param a a.
  *  @return (T[]) this.toArray()
  */

 @Override
 @SuppressWarnings("unchecked")
 public <T> T[] toArray(T[] a) {
  return (T[]) this.toArray();
 }

 @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
 @Override public boolean addAll(Collection<? extends T> c) { throw new UnsupportedOperationException("Not supported."); }
 @Override public boolean addAll(int index, Collection<? extends T> c) { throw new UnsupportedOperationException("Not supported."); }
 @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
 @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException("Not supported."); }
 @Override public int lastIndexOf(Object o) { throw new UnsupportedOperationException("Not supported."); }
 @Override public ListIterator<T> listIterator() { throw new UnsupportedOperationException("Not supported."); }
 @Override public ListIterator<T> listIterator(int index) { throw new UnsupportedOperationException("Not supported."); }
 @Override public List<T> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException("Not supported."); }
}