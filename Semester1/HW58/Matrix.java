//Lynne Wang
//APCS1 pd1
//HW59 -- Make the Matrix Work For You
//2017-12-21

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

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return _matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object retVal = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return retVal;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	String foo = "";
	for( int i =0; i < size(); i++ ) {
	    foo += "| ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	
	return foo;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	boolean foo = false;

	if (this == rightSide) foo = true;  
	// checks for aliases  ex. m1.equals(m1) is true

	else if ( rightSide instanceof Matrix 
		  && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide; //for cleaner code later
	    foo = true;
	    outer:
	    for( int i = 0; i < size(); i++ ) {
		for( int j = 0; j < size(); j++ ) {
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j) ) ) ) {
			foo = false;
			break outer;
		    }
		    else if ( !( isEmpty(i,j) && r.isEmpty(i,j) ) ) {
			foo = false;
			break outer;
		    }
		}
	    }
	}
	return foo;
    }//end equals()



    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	c1 = c1-1;
	c2 = c2-1;
    
	for( int i = 0; i < size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
	}
    }//O(n) b/c must visit n rows


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	r1 = r1-1;
	r2 = r2-2;
	Object [] temp = _matrix[r1];
	_matrix[r1] = _matrix[r2];
	_matrix[r2] = temp; 
    }//O(1)

    
    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy of row r
    public Object[] getRow( int r )
    {
	Object[] row = _matrix[r - 1];
	return row;
    }//O(1)

    //replaces row r with 1D array newRow
    //returns old row
    public Object[] setRow( int r, Object[] newRow )
    {
	Object[] oldRow = getRow(r);
	_matrix[r - 1] = newRow;
	return oldRow;
    }//O(1)

    public Object[] setCol( int c, Object[] newCol )
    {
	Object[] oldCol = new Object[size()];
	for(int x = 0; x < size(); x++)
	    oldCol[x] = _matrix[x][c - 1];
	for(int i = 0; i < size(); i++)
	    _matrix[i][c - 1] = newCol[i];
	return oldCol;
	
    }//O(n)
    
    //M[i,j] -> M[j,i] for all i,j
    public void transpose()
    {
	for(int i = 2; i <= size(); i++)
	    for(int x = 1; x <= i; x++) {
		Object old = get(i, x);
		set(i, x, get(x, i));
		set(x, i, old);
	    }
    }//O(n^2)
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    
    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix m1 = new Matrix(); // 2 x 2
	Matrix m2 = new Matrix(10); // 10 x 10
	System.out.println("m1 size: " + m1.size());
	System.out.println("m2 size: " + m2.size());
	System.out.println("m1 get(1,1) : " + m1.get(1,1));
	System.out.println("m1 isEmpty(1,1) : " + m1.isEmpty(1,1));	

	Matrix x = new Matrix(2); // 2x2
	System.out.println(x);
	x.set(1,1,"how"); 
	x.set(1,2,"now"); 
	x.set(2,1,"bro"); 
	x.set(2,2,"cow"); 
	System.out.println(x);
	//setRow
	Object[] a = new Object[]{"ho","no"};
	x.setRow(1, a);
	System.out.println(x);
	//setCol
	Object[] b = new Object[]{"clown","frown"};
	x.setCol(1, b);
	System.out.println(x);

	Matrix m3 = new Matrix(5); //5x5
        m3.set(1,1,1);
	m3.set(1,2,2);
	m3.set(1,3,3);
	m3.set(1,4,4);
	m3.set(1,5,5);
	m3.set(2,1,6);
	m3.set(2,2,7);
	m3.set(2,3,8);
	m3.set(2,4,9);
	m3.set(2,5,10);
	m3.set(3,1,11);
	m3.set(3,2,12);
	m3.set(3,3,13);
	m3.set(3,4,14);
	m3.set(3,5,15);
	m3.set(4,1,16);
	m3.set(4,2,17);
	m3.set(4,3,18);
	m3.set(4,4,19);
	m3.set(4,5,20);
	m3.set(5,1,21);
	m3.set(5,2,22);
	m3.set(5,3,23);
	m3.set(5,4,24);
	m3.set(5,5,25);
	System.out.println(m3);
	//trampose
	m3.transpose();
	System.out.println(m3);
    }//end main()

}//end class Matrix
