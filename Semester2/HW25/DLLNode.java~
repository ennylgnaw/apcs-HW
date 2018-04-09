//Lynne Wang
//APCS2 pd1
//HW24a: On the DLL
//2018-03-26

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next, DLLNode prev ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    
    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class DLLNode
