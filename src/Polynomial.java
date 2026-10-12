/*
Name: Erron John A Gabriel
Date 10/8/2026
 */
import java.util.LinkedList ;
public class Polynomial {
    private  LinkedList<Term>terms;

    // terms are 5x^3 , 3x^2 , -1
    // a polynomial consists of a linked list of terms like 5x^3 + 3x^2 -1
    public Polynomial()throws Exception{
        terms = new LinkedList<Term>();
    }
    /**
     * Sets this polynomial to a given LinkedList of Term
     */
    public void setTerms(LinkedList<Term> t){
        terms = t;
    }
    /**
     *Returns this polynomial as a LinkedList of Term
     */

    public LinkedList<Term> getTerms() {
        return terms;
    }

    /**
     * This method adds a term in the polynomial. if there is a term that has same degree of the new term
     * then the coefficients will be added. when the coefficients are combined and reuslts to 0 then the
     * term will be removed. else the new term will be insterted and sorted by degree
     * @param newTerm
     * @throws Exception
     */
    public void addTerm(Term newTerm) throws Exception{
        // will go to the linked list and be sorted by degree
        // if the term that will be added has the same degree, the numeral coefficient will be add/subtracted depending on the operation of the term
        int counter;
        //for loop
        for(counter = 0 ; counter < terms.size(); counter ++){
            Term currentTerm = terms.get(counter); //get the data from the index of counter.

            // if the degree of the current term is = to the degree of new term then add them
            if(currentTerm.getDegree() == newTerm.getDegree()){

                // set the current term by adding the currentTerm coefficient and  the newTermddd coefficient
                currentTerm.setCoefficient(currentTerm.getCoefficient() + newTerm.getCoefficient());

                // if the coefficient of the currentTerm is 0 then we remove it. example: (5x^3 + 2x^2) +(-2x^2) = (5x^3)
                if (currentTerm.getCoefficient() == 0){
                    terms.remove(counter);
                }
                return; //get out of the method cuz we are finish doing what is needed
            }

            //if the curreentTerm's degree is less than the newTerm's degree
            if(currentTerm.getDegree() < newTerm.getDegree()){
                terms.add(counter, newTerm);
                return;
            }
        }
        //if there's no terms in the polynomial then just add the new term.
        terms.add(newTerm);
    }

    /**
     * Returns the value of this polynomial if its literal is substituted
     * by the specified given value/
     */

    public double evaluate(double value) throws Exception{
        double sum = 0;
        for (int ctr = 0; ctr < terms.size(); ctr++) {
            Term currTerm = terms.get(ctr);
            sum += currTerm.getCoefficient() * Math.pow(value, currTerm.getDegree());
        }
        return sum;
    }

    /**
     * public Polynomial add(Polynomial otherPolynomial) throws Exception
     * Adds otherPolynomial to this polynomial
     1. Declare (let) result as a Polynomial that will eventually represent the sum polynomial
     2. Construct a new LinkedList of Term(i.e. resultTerms) that will eventually hold
     the Terms of the sum Polynomial
     3. Construct a copy of each term of this (first) Polynomial
     and add the constructed Term to the constructed LinkedList (resultTerms)
     4. Let resultTerms be the terms of result(i.e. the sum polynomial)
     5. For each (get each) term of the other polynomial, construct a copy
     of the term and assign such copy to sTerm.
     6. Add sTerm to the sum polynomial (result)
     7.If result polynomial has no term, let result have the term 0x^0
     8. return result.
     */
    public Polynomial add(Polynomial otherPolynomial) throws Exception {

        Polynomial result = new Polynomial(); //where the polynomial result will be stored.
        LinkedList<Term> resultTerms= new LinkedList<Term>();// a linked list of the result terms


        //for ctr = 0 ; ctr liss than size of polynomial, ctr++
        for (int ctr = 0; ctr < this.getTerms().size(); ctr++) {

            // a term named currentTerm is assigned to the value of the this polynomials first term
            Term currentTerm = this.getTerms().get(ctr);

            //the term at index of this term will now be stored at the resultTerms
            resultTerms.add(new Term(currentTerm.getCoefficient(), currentTerm.getLiteral(),
                    currentTerm.getDegree()));
        }
        //put the term resultTerms inside the polynomial
        result.setTerms(resultTerms);

        //for ctr2 = 0, ctr2 is less than otherpolynomial's terms size, ctr2++
        for (int ctr2 = 0; ctr2 < otherPolynomial.getTerms().size(); ctr2++) {
            Term currentTerm = otherPolynomial.getTerms().get(ctr2);
            Term sTerm = new Term(currentTerm.getCoefficient(), currentTerm.getLiteral(),
                    currentTerm.getDegree());
            result.addTerm( sTerm);
        }
        if (result.getTerms().size()==0)
            result.addTerm(new Term(0,'x',0));
        return result;
    }

    /**
     * Subtracts otherPolynomial from this polynomial f
     *
     1. Declare (let) result as a Polynomial that will eventually represent the difference polynomial
     2. Construct a new LinkedList of Term(i.e. resultTerms) that will eventually hold

     the Terms of the difference Polynomial
     3. Construct a copy of each term of this (first) Polynomial
     and put the constructed Term to the constructed LinkedList (resultTerms)
     4. Let resultTerms be the terms of result(i.e. the sum polynomial)
     5. For each (get each) term of the other polynomial, construct a copy of the term
     and assign such copy to sTerm.
     6. Multiply the numerical coefficient field of sTerm by -1.
     7. Add sTerm to the difference polynomial (result)
     8.If result polynomial has no term, let result have the term 0x^0
     9. return result.
     */

    public Polynomial subtract(Polynomial otherPolynomial) throws Exception {
        Polynomial result = new Polynomial();
        LinkedList<Term> resultTerms= new LinkedList<Term>();

// to do
        return result;
    }

    /**
     * Multiplies this polynomial by otherPolynomial.
     * The method assumes that the polynomials have the same literals and
     * it follows the prescription of the Term class.
     */
    public Polynomial multiply(Polynomial otherPolynomial) throws Exception
    {
        Polynomial result=new Polynomial();
        for (int ctr = 0; ctr < this.getTerms().size(); ctr++) {
            Term currentTerm1 = this.getTerms().get(ctr);
            for (int ctr2 = 0; ctr2 < otherPolynomial.getTerms().size(); ctr2++) {
                Term currentTerm2 = otherPolynomial.getTerms().get(ctr2);
                double pCoef = currentTerm2.getCoefficient()*currentTerm1.getCoefficient();
                int pDegree = currentTerm2.getDegree()+currentTerm1.getDegree();
                result.addTerm(new Term(pCoef, currentTerm1.getLiteral(), pDegree));
// Invoke appropriate method to add a term to product polynomial
            } // end of second for ( for ctr2)
        } // end of first for (for ctr)
        if (result.getTerms().size() == 0)
            result.addTerm(new Term(0,'x',0));
        return result;
    }
    /**
     * Divides this polynomial by divisor polynomial


    public Quotient divide(Polynomial divisor) throws Exception
    {
        Quotient result=new Quotient();
        Polynomial quotient= new Polynomial();
        Polynomial remainder = new Polynomial();
        LinkedList<Term> dividend = new LinkedList<Term>();
        Term qTerm;
        Polynomial subtrahend = new Polynomial();
        for (int ctr = 0; ctr < this.getTerms().size(); ctr++) {
            Term currentTerm = this.getTerms().get(ctr);
            dividend.add(new Term(currentTerm.getCoefficient(), currentTerm.getLiteral(),
                    currentTerm.getDegree()));
        }
        remainder.setTerms(dividend);
        while (((remainder != null)) && ((remainder.getTerms().get(0)).getDegree() >= (
                divisor.getTerms().get(0)).getDegree())) {
            Term numTerm = remainder.getTerms().get(0);
            Term divTerm = divisor.getTerms().get(0);
            qTerm = new Term (numTerm.getCoefficient()/divTerm.getCoefficient(), numTerm.getLiteral(),
                    numTerm.getDegree()-divTerm.getDegree());
            quotient.addTerm(qTerm);
            LinkedList<Term> pQTerm = new LinkedList<Term>();
            pQTerm.add(qTerm);
            Polynomial multiplier = new Polynomial();
            multiplier.setTerms(pQTerm);
            subtrahend = multiplier.multiply(divisor);
            remainder = remainder.subtract(subtrahend);
        }
        if (quotient.getTerms().size()==0)
            quotient.addTerm(new Term(0,'x',0));
        result.setQuotientP(quotient);
        if (remainder.getTerms().size()==0)
            remainder.addTerm(new Term(0,'x',0));
        result.setRemainderP(remainder); // Invoke appropriate method to set remainder member of
        quotient
        return result;
    }
     */

    /**
     * returns a string a representing the polynomial with the ff sample form 3x^2 - 5x + 3
     */

    public String toString() {
        String s = "";
        // if the terms are empty then return nothing
        if (terms == null)
            return " ";

        for (int ctr = 0; ctr < terms.size(); ctr++) {

            Term currTerm = terms.get(ctr);
            //if the coefficient of the current term is greater than 0
            if (currTerm.getCoefficient() > 0) {
                //if ctr is not 0 then add + in s.
                if (ctr != 0) {
                    s = s + " +";
                }
            } else {//else add subtraction
                s = s + " -";
            }

            if (currTerm.getCoefficient() != 1 || currTerm.getDegree() == 0) {
                s = s+" "+ Math.abs(currTerm.getCoefficient());
            }
            switch (currTerm.getDegree()) {
                case 0 :
                    break;
                case 1 :
                    s = s + (terms.get(0)).getLiteral();
                    break;
                default :
                    s = s + (terms.get(0)).getLiteral() +"^" + currTerm.getDegree();
            }
        }
        return s;
    }
}

