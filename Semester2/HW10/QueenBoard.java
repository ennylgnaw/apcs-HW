//Lynne Wang
//APCS2 pd1
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-28   

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */

  //if solutions possible, returns a solution and true for an n by n board
  //else, returns false
  public boolean solve()
  {
      return solveH(0);
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
      if (col == _board.length) {
	  printSolution();
	  return true;
      }
      for (int i = 0; i < _board.length; i++)
	  if (addQueen(i,col)) {
	      if (solveH(col + 1))
		  return true;
	      else
		  removeQueen(i,col);
	  }
      return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
      String s = "";
      for (int i = 0; i < _board.length; i++) {
	  for (int x = 0; x < _board.length; x++) {
	      if (_board[i][x] <= 0)
		  s += "-\t";
	      else
		  s += "Q\t";
	  }
	  s += "\n";
      }
      System.out.println(s);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * Adds a queen to the chessboard, represented by 1. Zeroes represent 
   available spots, while negative numbers denote how many attacks from 
   other queens are possible.
   * precondition: row and col are not greater than dimensions of board
   * postcondition: returns true if queen can be placed, false if queen 
   cannot be placed
     */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * Description: Removes a queen from the board. Prior position will return 
   to zero, and that queen's paths of attack will be removed from other 
   positions on the board (+1)
   * precondition: row and col are not greater than dimensions of board
   * postcondition: returns true if queen is there and can be removed, false 
   if not
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: Board is a 2D int array
   * postcondition: Prints out contents of board
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    /*
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.addQueen(2,2);
    b.addQueen(4,3);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    */
    QueenBoard b = new QueenBoard(5);
    System.out.println(b.solve());
    QueenBoard c = new QueenBoard(2);
    System.out.println(c.solve());
    QueenBoard d = new QueenBoard(8);
    System.out.println(d.solve());
  }
    
}//end class
