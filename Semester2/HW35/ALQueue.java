//TheLightDark - Lynne Wang and Calvin Aw
//APCS2 pd01
//HW 35 -- ...Nor do Aussies
//2018-04-16

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

    private ArrayList<T> _arrList;
    private int _beginVal = 0;

    public ALQueue(){
	_arrList = new ArrayList<T>();
	_beginVal = 0;
    }

    //dequeues at O(1);
    public T dequeue(){
	if (isEmpty())
	    return null;
	
	T retVal = _arrList.get(_beginVal);
	_beginVal += 1;
	return retVal;
    }

    //enqueues at O(1)
    public void enqueue(T x){
	_arrList.add(x);
    }

    public boolean isEmpty(){
	return _arrList.size() == _beginVal;
    }
    
    public T peekFront(){
	return _arrList.get(_beginVal);
    }
    
    public static void main(String[] args){
	ALQueue<String> test = new ALQueue<String>();
        
        System.out.println(test.isEmpty()); //TRUE
        test.enqueue("apple");
        test.enqueue("brick");
        test.enqueue("sky");
        
        System.out.println(test.isEmpty()); //FALSE
        
        System.out.println(test.peekFront()); //apple
        System.out.println(test.dequeue()); //apple
        
        System.out.println(test.peekFront()); //brick
        System.out.println(test.dequeue()); //brick
        
        System.out.println(test.peekFront()); //sky
        System.out.println(test.dequeue()); //sky

        System.out.println(test.isEmpty()); //TRUE
        System.out.println(test.dequeue()); //null

	test.enqueue("home");
	System.out.println(test.peekFront()); //home
        System.out.println(test.dequeue()); //home
    }
}
