//Lynne Wang
//APCS1 pd1
//HW37 -- Be More Rational
//2017-11-21

public class Rational {

    //instance vars
    private int num = 0;
    private int den = 0;

    //Default constructor
    public Rational() {
	num = 0;
	den = 1;
    }

    //Overloaded Constructor
    public Rational( int Num, int Den ) {
        if (Den != 0) {
	    num = Num;
	    den = Den;
	}
	else {
	    System.out.println("Invalid denominator. Number set to 0/1.");
	    num = 0;
	    den = 1;
	}
    }

    //toString
    public String toString() {
        return num + "/" + den;
    }

    //floatValue
    public double floatValue() {
	return (double) num / den;
    }

    //multiply
    public void multiply( Rational obj ) {
        num = this.num * obj.num;
	den = this.den * obj.den;
    }

    //divide
    public void divide( Rational obj ) {
	num = this.num * obj.den;
	den = this.den * obj.num;
    }

    //*************************************************************
    //Phase II

    //static gcd method with two int params
    public static int gcd( int a, int b ) {
	if (a < b) {
	    int c = a;
	    a = b;
	    b = c;
	}
	if (a % b == 0)
	    return b;
	return gcd(b, a % b);
    }

    //add Rational object to current rational object
    public void add( Rational obj ) {
	num = (this.num * obj.den) + (obj.num * this.den);
	den = this.den * obj.den;
    }

    //subtract
    public void subtract( Rational obj ) {
	num = (this.num * obj.den) - (obj.num * this.den);
	den = this.den * obj.den;
    }

    //gcd - Returns the gcd of the numerator and denominator of this Rational
    public int gcd() {
	return gcd(num, den);
    }

    //reduce - Changes this Rational to one in reduced form (should use gcd)
    public void reduce() {
	int gcd = this.gcd();
	num = this.num / gcd;
	den = this.den / gcd;
    }

    /* compareTo
       - Takes a Rational parameter and compares it to the calling object
       - Returns 0 if the two numbers are equal
       - Returns a positive integer if the calling number is larger than the parameter
       - Returns a negative integer if the calling number is smaller than the parameter
    */
    public int compareTo( Rational obj ) {
	if (this.floatValue() == obj.floatValue())
	    return 0;
	else if (this.floatValue() > obj.floatValue())
	    return 1;
	else
	    return -1;
    }

    //Main Method
    public static void main( String[] args ) {
	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2
	Rational t = new Rational(1,0); //Error, number set to 0/1

	//toString()
	System.out.println(r.toString()); // 2/3

	//floatValue()
	System.out.println(r.floatValue()); // 0.6666666666666666

	//Constructors
	System.out.println(r); //r is 2/3
	System.out.println(s); //s is 1/2

	//Multiply
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r); 
	System.out.println(s); 

	//Divide
	r.divide(s); //Divides r by s, changes r to 4/6. s remains 1/2
	System.out.println(r);
	System.out.println(s);

	//Static gcd
	System.out.println(gcd(32,36)); //4

	//add
	r.add(s); //Adds s to r; changes r to 14/12. s remains 1/2
	System.out.println(r); 
	System.out.println(s);

	//subtract
	r.subtract(s); //Substracts s from r; changes r to 16/24. s remains 1/2
	System.out.println(r); 
	System.out.println(s);

	//gcd
	System.out.println(r.gcd()); //gcd 16/24 returns 8

	//reduce
	r.reduce();
	System.out.println(r); //16/24 reduces to 2/3

	//compareTo
	Rational u = new Rational(4,6); //Stores rational number 1/2
	Rational v = new Rational(8,9); //Stores rational number 1/2
	System.out.println(r.compareTo(s)); //returns 1
	System.out.println(r.compareTo(r)); //returns 0
	System.out.println(r.compareTo(u)); //returns 0
	System.out.println(r.compareTo(v)); //returns -1
	
    }
}
