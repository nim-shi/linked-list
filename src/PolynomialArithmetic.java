import java.util.Scanner;
public class PolynomialArithmetic {
    public static void main(String[] args) {
        Scanner beep = new Scanner(System.in);
        System.out.println("Welcome! This program can do arithmetic operations to polynomial!");
        System.out.println("What do you want to do?");

        try {
            //(x^2 - x + 5) coe = 1 degree = 2 literal = x
            Polynomial p1 = new Polynomial();
            p1.addTerm(new Term (1,'x',2));
            p1.addTerm(new Term (-1,'x',1));
            p1.addTerm(new Term (5));

            //(6x^2 + 2x  - 10)
            Polynomial p2 = new Polynomial();
            p2.addTerm(new Term (6,'x',2));
            p2.addTerm(new Term (2,'x',1));
            p2.addTerm(new Term (-10));

            System.out.println(p1 + " " + p2);
            System.out.println(p1.add(p2));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
