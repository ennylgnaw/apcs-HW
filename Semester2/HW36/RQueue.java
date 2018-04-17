//Team TheTheLightDark (Shafali Gupta, Lynne Wang)
//APCS2 pd01
//HW36 - Now Let's Consider You Lot at Fake Terry's
//2018-04-17
/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

public class RQueue<T> implements Queue<T>
{
    
    //instance variables
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue()
    {
	_front = null;
	_end = null;
	_size = 0;
    }//end default constructor


    public void enqueue( T enQVal )
    {
	LLNode<T> temp = new LLNode<T>(enQVal, null);
	if ( isEmpty() )
  	    _front = _end = new LLNode<T>( enQVal, null );
  	else {
  	    _end.setNext( new LLNode<T>( enQVal, null ) );
  	    _end = _end.getNext();
	}
	_size++;

    }//end enqueue()
    //O(1)


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue()
    {
	if ( isEmpty() )
	    return null;
	sample();
	return dequeueS();
    }//end dequeue()
    //O(n)
    
    //dequeue() helper method
    //removes item at beginning of queue
    public T dequeueS()
    {
	T temp = _front.getValue();
	_front = _front.getNext();
	_size--;
	return temp;
    }//end dequeueS()
    //O(1)

    public T peekFront()
    {
	return  _front.getValue();
    }
    //O(1)


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * 1. Choose a random "index" between 0 and size - 1
     * 2. _front is always the item at the beginning of the queue
     * 3. dequeue the front node and enqueue it (attach to end of queue)
     * 4. Repeat step 3 until you reach your desired index (now at the front of 
     * the queue)
     ******************************************/
    public void sample()
    {
	int temp = (int) (Math.random() * _size);
	while (temp != 0){
	    enqueue(dequeueS());
	    temp--;
	}
    }//end sample()
    //O(n)


    public boolean isEmpty()
    {
	return _size == 0;
    } //O(1)


    // print each node, separated by spaces
    public String toString()
    {
	String retStr = "";
	LLNode<T> temp = _front;
	while (temp != null) {
	    retStr += temp + " ";
	    temp = temp.getNext();
	}
	return retStr;
    }//end toString()



    //main method for testing
    public static void main( String[] args )
    {

	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing...");
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()...");
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing...");
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing fr empty queue...");
	System.out.println( PirateQueue.dequeue() );

    }//end main

}//end class RQueue
