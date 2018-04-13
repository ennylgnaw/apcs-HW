//Lynne Wang
//APCS2 pd1
//HW #32: Leon Leonwood Stack
//2018-04-12

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {   
	//LLStack
	System.out.println("______LLStack______");
	Stack cakes = new LLStack<String>();
	cakes.push("Tuvan");
	cakes.push("throat");
	cakes.push("singing");
	System.out.println(cakes.peek()); //singing
	System.out.println(cakes.pop()); //singing
	System.out.println(cakes.pop()); //throat

	//empty LLStack
	Stack sadCakes = new LLStack<String>();
	System.out.println(sadCakes.peek()); //null
	System.out.println(sadCakes.pop()); //null
    

	//ALStack
	System.out.println("______ALStack______");
	Stack latkes = new ALStack<String>();
	latkes.push("Tuvan");
	latkes.push("throat");
	latkes.push("singing");
	System.out.println(latkes.peek()); //singing
	System.out.println(latkes.pop()); //singing
	System.out.println(latkes.pop()); //throat

	//empty ALStack
	Stack sadLatkes = new ALStack<String>();
	System.out.println(sadLatkes.peek()); //null
	System.out.println(sadLatkes.pop()); //null
    }

}//end class

