//Lynne Wang
//APCS2 pd1
//HW #21c: Rockin’ Through the Night
//2018-03-20

public class LList implements List {

    //instance vars
    private LLNode _beg;
    private LLNode _end;
    private int _size;

    //constructor
    public LList() {
	_beg = null;
	_end = null;
	_size = 0;
    }

    public boolean add( String x ) {
	if ( _beg == null )
	  _beg = new LLNode( x, null );
	else {
	    LLNode i = _beg;
	    while( i.getNext().getCargo() != null )
		i = i.getNext();
	    _end = _beg.getNext().setNext( new LLNode( x, null ) );
	}
	_size += 1;
	return true;
    }

    public String get( int i ) {
	if ( _beg == null )
	    throw new IndexOutOfBoundsException();
	LLNode temp = _beg;
	for( int x = 0; x < i; x++ )
	    temp = temp.getNext();
	if ( temp == null )
	    throw new IndexOutOfBoundsException();
	return temp.getCargo();
    }

    public String set( int i, String x ) {
	if ( _beg == null )
	    throw new IndexOutOfBoundsException();
	LLNode temp = _beg;
	for( int a = 0; a < i; a++ )
	    temp = temp.getNext();
	if ( temp == null )
	    throw new IndexOutOfBoundsException();
	String old = temp.getCargo();
	temp.setNext( new LLNode( x, null ));
	return old;
    }

    public int size() {
	return _size;
    }

    //main
    public static void main( String[] args ) {
	LList a = new LList();
	a.add("a");
        a.add("b");
	a.add("c");
	a.set(2,"d"); 
        for(int i = 0; i < a.size(); i++)
	    System.out.println( a.get(i) );
    }
}
