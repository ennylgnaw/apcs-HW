//Lynne Wang
//APCS1 pd1
//HW57 -- How Deep Does the Rabbit Hole Go?
//2017-12-20

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    //runtime: O(1)
    private int size()
    {
        return matrix.length;
    }


    //return the item at the specified row & column
    //runtime: O(1)
    private Object get( int r, int c )
    {
	return matrix[r - 1][c - 1];
    }


    //return true if this matrix is empty, false otherwise
    //runtime: O(n^2)
    private boolean isEmpty() 
    {
        boolean empty = true;
	for(Object[] row : matrix)
	    for(Object item : row)
		if (item != null) {
		    empty = false;
		    break;
		}
	return empty;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    //runtime: O(1)
    private Object set( int r, int c, Object newVal ) 
    {
	Object old = this.get(r, c);
        matrix[r - 1][c - 1] = newVal;
	return old;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    //runtime: O(n^2)
    public String toString() 
    {
	String str = "";
	for(Object[] row : matrix) {
	    for(Object item : row)
		str += item + " ";
	    str += "\n";
	}
	str += "";
	return str;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    //runtime: O(n^2)
    public boolean equals( Object rightSide ) 
    {
	if (this.size() != ((Matrix) rightSide).size())
	    return false;
        for(int i = 1; i < this.size() + 1; i++)
	    for (int x = 1; x < this.size() + 1; x++)
		if (! (this.get(i , x)).equals(((Matrix) rightSide).get(i, x)))
		    return false;
	return true;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    //runtime: O(n)
    public void swapColumns( int c1, int c2  ) 
    {
	for(int i = 1; i < this.size() + 1; i++) {
	    Object oldc1 = this.get(i, c1);
	    this.set(i, c1, this.get(i, c2));
	    this.set(i, c2, oldc1);
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    //runtime: O(1)
    public void swapRows( int r1, int r2  ) 
    {
	Object[] oldr1 = matrix[r1 - 1];
        matrix[r1 - 1] = matrix[r2 - 1];
	matrix[r2 - 1] = oldr1;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	System.out.println("Initializing new matrix z...");
	Matrix z = new Matrix();
	System.out.print("Is matrix z empty? " + z.isEmpty());
	System.out.println("Printing matrix z...");
	System.out.println(z);

	System.out.println("Initializing new matrix a...");
	Matrix a = new Matrix(3);
	System.out.println("Is matrix a empty? " + a.isEmpty());
	a.set(1,1,6);
	a.set(1,2,5);
	a.set(1,3,4);
	a.set(2,1,3);
	a.set(2,2,2);
	a.set(2,3,1);
	a.set(3,1,1);
	a.set(3,2,2);
	a.set(3,3,3);
	System.out.println("Is matrix a empty? " + a.isEmpty());
        System.out.println("Printing matrix a...");
	System.out.println(a);

	
        Matrix b = new Matrix(3);
	
	b.set(1,1,6);
	b.set(1,2,5);
	b.set(1,3,4);
	b.set(2,1,3);
	b.set(2,2,2);
	b.set(2,3,1);
	b.set(3,1,1);
	b.set(3,2,2);
	b.set(3,3,3);

	System.out.println("Printing matrix b...");
	System.out.println(b);


	Matrix c = new Matrix(3);
	
	c.set(1,1,6);
	c.set(1,2,5);
	c.set(1,3,4);
	c.set(2,1,3);
	c.set(2,2,2);
	c.set(2,3,1);
	c.set(3,1,1);
	c.set(3,2,2);
	c.set(3,3,7);

	System.out.println("Printing matrix c...");
	System.out.println(c);

	System.out.println("Does a = b? --> " + a.equals(b));
	System.out.println("Does a = c? --> " + a.equals(c));

	System.out.println("\n\nMatrix a:");
	System.out.println(a);
	System.out.println("Swapping columns 1 and 2...");
	a.swapColumns(1, 2);
	System.out.println(a);
	System.out.println("Swapping rows 1 and 2...");
	a.swapRows(1, 2);
	System.out.println(a);
    }

}//end class Matrix
