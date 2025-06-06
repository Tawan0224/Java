/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package Week06;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public RationalNumber (int n, int d){
        this. numerator = n;
        if (d <= 0){
            this.denominator = 1;
        } else {
            this.denominator = d;
        }
    }
    public void add(RationalNumber r) {
        this.numerator = (this.numerator * r.denominator) + (this.denominator * r.numerator);
        this.denominator = (this.denominator * r.denominator);
    }
    public void substract(RationalNumber r){
        this.numerator = (this.numerator * r.denominator) - (this.denominator * r.numerator);
        this.denominator = (this.denominator * r.denominator);
    }
    public void multiply(RationalNumber r){
        this.numerator = (this.numerator * r.numerator);
        this.denominator = (this.denominator * r.denominator);
    }
    public void divide(RationalNumber r){
        this.numerator = (this.numerator * r.denominator);
        this.denominator = (this.denominator * r.numerator);
    }
    public void invert(){
        int temp = this.denominator;
        this.denominator = this.numerator;
        this.numerator = temp;

    }
    public double toDouble(){
        double r = (double)this.numerator / this.denominator;
        return r;
    }
    public void reduce(){
        int gcdvalue = gcd(this.numerator, this.denominator);
        numerator /= gcdvalue;
        denominator /= gcdvalue;
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    private int gcd (int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        RationalNumber r1 = new RationalNumber(3,6);
        RationalNumber r2 = new RationalNumber(2,6);

        r1.add(r2);
        System.out.println("Addition: " + r1);

        r1 = new RationalNumber(3,6);
        r1.substract(r2);
        System.out.println("Substraction: " + r1);

        r1 = new RationalNumber(3,6);
        r1.multiply(r2);
        System.out.println("Multiplication: " + r1);

        r1 = new RationalNumber(3,6);
        r1.divide(r2);
        System.out.println("Division: " + r1);

        r1 = new RationalNumber(3,6);
        r1.invert();
        System.out.println("After invert: " + r1);

        r1 = new RationalNumber(3,6);
        r1.reduce();
        System.out.println("After reduce: " + r1);

        r1 = new RationalNumber(3,6);
        System.out.println("As a double: " + r1.toDouble());
    }
}