//Insomniaxellence (Kendrick Liang, Lynne Wang)
//APCS2 pd1
//HW #23: Give and Take
//2018-03-22

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }

    //insert a node containing newVal at position index
    public void add(int index, String newVal){
	LLNode tmp = _head;
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	LLNode newNode = new LLNode(newVal, null);
	if (size() == 0 && _head == null)
	    _head = newNode;
	else{
	    for (int i = 0; i < index - 1; i++)
		tmp = tmp.getNext();
	    LLNode nodeBefore = tmp;
	    LLNode nodeAfter = nodeBefore.getNext();
	    newNode.setNext(nodeAfter);
	    nodeBefore.setNext(newNode);
	}
	
	_size++;
    }

    //remove node at pos index, return its cargo
    public String remove(int index){
	String result = null;
	LLNode tmp = _head;
	if ((index >= 1) && (index <= size())){
	    if (size() != 0 || _head != null){
		for (int i = 0; i < index - 1; i++)
		    tmp = tmp.getNext();
		LLNode nodeBefore = tmp;
		LLNode nodeToRemove = nodeBefore.getNext();
		LLNode nodeAfter = nodeToRemove.getNext();
		nodeBefore.setNext(nodeAfter);
		result = nodeToRemove.getCargo();
	    }
	    
	    _size--;
	}
	
	return result;
    }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ){
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	james.add(3, "huge");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add(4, "now");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	
	james.remove(2);
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.remove(1);
	System.out.println( james );
	System.out.println( "size: " + james.size() );
    }

}//end class LList


