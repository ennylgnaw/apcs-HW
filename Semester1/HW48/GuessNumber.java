//Lynne Wang
//APCS1 pd1
//HW48 -- Keep Guessing
//2017-12-07

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = (int) (Math.random() * 100) + 1;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.print("Guess a number from " + _lo + "-" + _hi + ": " + "\033[0;1m"); //input is bold
        int input = Keyboard.readInt();
        System.out.print("\u001B[0m"); //resets text to normal

	//Base Case
        if (input == _target) {
	    System.out.println("Correct! It took " + _guessCtr + " guesses.");
	    return;
	}
	
	if (input < _lo || input > _hi)
	    System.out.println("Index out of range. Try again.");
        else if (input < _target) {
	    _lo = input + 1;
	    System.out.println("Too low, try again...");
        }
        else {
	    _hi = input - 1;
	    System.out.println("Too high, try again...");
        }
	
	_guessCtr += 1;
	playRec();
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	for(int i = 0; i < _guessCtr; i++) {
	    System.out.print("Guess a number from " + _lo + "-" + _hi + ": " + "\033[0;1m"); //input is bold
	    int input = Keyboard.readInt();
	    System.out.print("\u001B[0m"); //resets text to normal
	    if (! (input == _target)) {
		if (input < _lo || input > _hi)
		    System.out.println("Index out of range. Try again.");
		else if (input < _target) {
		    _lo = input + 1;
		    System.out.println("Too low, try again...");
		}
		else {
		    _hi = input - 1;
		    System.out.println("Too high, try again...");
		}
	    }
	    else {
	        break;
	    }
	    _guessCtr += 1;
	}
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class
