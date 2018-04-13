//Lynne Wang
//APCS2 pd1
//HW #33: What a Racket
//2018-04-12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the expression at the whitespace into a String array
 *   2. Instantiate a stack
 *   3. Increment through the array from right to left
        a. If the String at the current index of the array equals "(", 
           pop the stack. The popped String is the operator. Apply this 
           operator to numbers in the stack until you hit a ")". Pop the ")".
           Push the result onto the stack.
        b. Else, push String at current index onto stack
     4. Pop the stack (this is the result)
 *
 * STACK OF CHOICE: LLStack by Lynne Wang
 * b/c ... I considered the runtimes of the methods I'd use (peek, pop, push). 
   According to the Java API, Linked List methods are for doubly-linked lists. 
   Since we only want to access the top of our stack for each method, all of 
   these methods are O(1) (constant time). Once again, this is because we only 
   interact with one end of the linked list stack.

   On the other hand, an array-based stack has a fixed storage space and must 
   be expanded for more space. An ArrayList-based is also costlier when the 
   stack grows large (must expand). Overall, a LinkedList-based stack grows 
   the easiest.
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
      String[] exprArr = expr.split("\\s+");
      LLStack<String> stack = new LLStack<String>();
      for (int i = exprArr.length - 1; i > -1; i--) {
	  if (exprArr[i].equals("(")) {
	      String op = stack.pop();
	      if (op.equals("+"))
		  stack.push(unload(1, stack));
	      else if (op.equals("-"))
		  stack.push(unload(2, stack));
	      else
		  stack.push(unload(3, stack));
	  }
	  else
	      stack.push(exprArr[i]);
      }
      return stack.pop();
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, LLStack<String> numbers ) 
  {
      int ans = Integer.valueOf(numbers.pop());
      while (! numbers.peek().equals(")")) {
	  if (op == 1)
	      ans += Integer.parseInt(numbers.pop());
	  else if (op == 2)
	      ans -= Integer.parseInt(numbers.pop());
	  else
	      ans *= Integer.parseInt(numbers.pop());
      }
      numbers.pop(); //pop "("
      return "" + ans;
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
