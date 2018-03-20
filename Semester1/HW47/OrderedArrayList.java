//Lynne Wang
//APCS1 pd1
//HW #47:_ascending
//2017-12-06

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;
    private int _size;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
      _data = new ArrayList<Comparable>();
  }


  public String toString()
  {
      return _data.toString();
  }


  public Comparable remove( int index )
  {	
      return _data.remove(index);
  }


  public int size()
  { 
      return _data.size();
  }

    
  public Comparable get( int index )
  { 
      return _data.get(index);
  }


    //uses linear search
  public void add(Comparable newVal)
  { 
      for(int i = 0; i < _data.size(); i++)
	  if (newVal.compareTo(_data.get(i)) < 0) {
	      _data.add(i, newVal);
	      return;
	  }
      _data.add(newVal);
  }



  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }

  }//end main()

}//end class OrderedArrayList
