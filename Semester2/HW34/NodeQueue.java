//Lynne Wang
//APCS2 pd1
//HW #34: The English Do Not Wait In Line
//2018-04-16

public class NodeQueue<T> implements Queue<T> {

    private LLNode<T> _head, _tail;
    
    public NodeQueue() {
	_head = null;
	_tail = null;
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue() {
	LLNode<T> temp = _head;
	_head = _head.getNext();
	return temp.getValue();
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ) {
	if (isEmpty()) {
	    _head = new LLNode(x, null);
	    _tail = _head;
	}
	else {
	    LLNode<T> temp = _head;
	    while (! temp.equals(_tail))
		temp = temp.getNext();
	    _tail = new LLNode(x, null);
	    temp.setNext(_tail);
	}
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
	return _head == null;
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront() {
	if (isEmpty())
	    return null;
	return _head.getValue();
    }

    public static void main( String[] args ) {
        NodeQueue line = new NodeQueue();
	line.enqueue("guava");
	line.enqueue("pomelo");
	line.enqueue("durian");
	System.out.println(line.peekFront()); //guava
	System.out.println(line.dequeue()); //guava
	System.out.println(line.dequeue()); //pomelo
	System.out.println(line.dequeue()); //durian
	System.out.println(line.peekFront()); //
    }
    
}
