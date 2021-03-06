/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String _cargo;
    private LLNode _nextNode;

    // constructor 
    public LLNode( String content, LLNode nextNode ) {
	_cargo = content;
	_nextNode = nextNode;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return _cargo;
    }

    public LLNode getNext()
    {
	return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCar )
    {
	String old = this.getCargo();
	_cargo = newCar;
	return old;
    }

    public LLNode setNext( LLNode newNext )
    {
	LLNode old = this.getNext();
	_nextNode = newNext;
	return old;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
	return this.getCargo();
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...

	LLNode beg = new LLNode( "a", null );

        beg.setNext( new LLNode( "b", null ) );

        beg.getNext().setNext( new LLNode( "c", null ) );

	LLNode i = beg; 
	while( i != null ) {
	    System.out.println( i );
	    i = i.getNext();
	}
	
    }//end main

}//end class LLNode
