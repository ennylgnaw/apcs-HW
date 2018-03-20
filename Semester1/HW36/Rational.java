//Lynne Wang
//APCS1 pd1
//HW36 -- Be Rational
//2017-11-20 

public class Rational {

    //instance vars
    private int num = 0;
    private int den = 0;

    //Default constructor
    public Rational() {
	num = 0;
	den = 1;
    }

    //Constructor
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
        num = num * obj.num;
	den = den * obj.den;
    }

    //divide
    public void divide( Rational obj ) {
	num = num * obj.den;
	den = den * obj.num;
    }

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
    }
}
