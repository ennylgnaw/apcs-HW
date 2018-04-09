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

public class DLLNode<T> 
{
  private T _cargo;    //cargo may only be of type String
  private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode<T> next, DLLNode<T> prev ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }

    public DLLNode<T> getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
        T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ) {
	DLLNode<T> foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    
    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class DLLNode
