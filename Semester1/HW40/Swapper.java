//Lynne Wang
//APCS1 pd1
//HW #40: Make It Better
//2017-11-27

/*
Operational Summary:
********************
- populate: populates 2D String array with a String, of value between 100 and 9999
- retStr: prints out the array. Each row has its own line.
- Switch: takes in a String array, row of first term, column of first term, row of second term, and column of second term as parameters. Switches their positions in the array. Asterisks around changed items.
- main: creates array, prompts user to enter row and column of first term and row and column of second term. If invalid inputs entered, returns "Invalid" message to terminal. If valid inputs, returns array with modifications.


Improvements:
*********************
- row and column number displayed in terminal, colored yellow
- switched items are marked by asterisks
- switches items in array instead of characters in a String
- switch only switches (doesn't print); retStr prints
- try/catch instead of if/else (for invalid inputs)
*/

import cs1.Keyboard;

public class Swapper {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void populate( String[][] arr ) {
	for(int i = 0; i < arr.length; i++)
	    for(int x = 0; x < arr[0].length; x++)
		arr[i][x] = "" + (int)(Math.random() * 9900 + 100);
    }

    public static void retStr( String[][] arr ) {
	System.out.print(ANSI_YELLOW + "\t");
	for(int i = 0; i < arr[0].length; i++)
	    System.out.print(i + "\t");
	System.out.println(ANSI_RESET);
	for(int i = 0; i < arr.length; i++) {
	    System.out.print(ANSI_YELLOW + i + "\t" + ANSI_RESET);
	    for(int x = 0; x < arr[0].length; x++)
	        System.out.print(arr[i][x] + "\t");
	    System.out.println("");
	}
    }
    
    public static void Switch( String[][] arr, int a, int b, int c, int d ) {
        String e = "*" + arr[a][b] + "*";
	arr[a][b] = "*" + arr[c][d] + "*";
	arr[c][d] = e;
    }

    public static void main( String[] args ) {

        String[][] arr = new String[5][5];
	populate(arr);
	retStr(arr);

	System.out.println("Switchee time! Enter in two items you'd like to switch:");
        System.out.print("Select the row of the first term: ");
        int row = Keyboard.readInt();

	System.out.print("Select the column of the first term: ");
	int col = Keyboard.readInt();

        System.out.print("Select the row of the second term: ");
	int a = Keyboard.readInt();

        System.out.print("Select the column of the second term: ");
	int b = Keyboard.readInt();	

        try {
	    Switch(arr, row, col, a, b);
	    retStr(arr);
	}
        catch (Exception e) {
	    System.out.println("\n!!!Invalid index!!!");
	}
    }
}
