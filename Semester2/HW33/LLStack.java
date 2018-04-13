//Lynne Wang
//APCS2 pd1
//HW #32: Leon Leonwood Stack
//2018-04-12

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {

    //instance vars
    private LinkedList<T> _stack;

    //constructor
    public LLStack() {
	_stack = new LinkedList<T>();
    }

    //Methods

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
	return (_stack.size() == 0); 
    }

    //Return top element of stack without popping it.
    public T peek() {
	if (isEmpty())
	    return null;
	return _stack.get(_stack.size() - 1);
    }

    //Pop and return top element of stack.
    public T pop() {
	if (isEmpty())
	    return null;
	return _stack.remove(_stack.size() - 1);
    }

    public void push( T x ) {
	_stack.add( x );
    }
    
}
