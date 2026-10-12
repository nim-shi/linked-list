public class Term implements Comparable<Term>{

    private double coefficient;
    private char literal;
    private  int degree;


    /*** constructor of term with coef, degree set to 0 and literal x*/
    public Term(){
        coefficient = 0;
        literal = 'x';
        degree = 0;

    }
    public Term(double coefficient){
        this.coefficient = coefficient;
        literal = ' ';
        degree = 0;
    }

    /**
     * Construct a term that sets its  coefficient. literal, and degree
     * to given the coefficient, literal and degree
     * @param coefficient
     * @param literal
     * @param degree
     */
    public Term(double coefficient,  char literal,int degree){
        this.coefficient = coefficient;
        this.literal = literal;
        this.degree = degree;
    }

    /**
     * Returns the number coefficient of the term
     * @return
     */
    public double getCoefficient() {return coefficient;}

    /**
     * return of the degree of the term
     * @return
     */
    public int getDegree() {
        return degree;
    }

    /**
     * return of the literal of the term
     * @return
     */
    public char getLiteral() {
        return literal;
    }

    /**
     * set the coefficient of the term
     * @param coefficient
     */
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * set the degree of the term
     * @param degree
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * set the literal of the term
     * @param literal
     */
    public void setLiteral(char literal) {
        this.literal = literal;
    }

    /**
     * this returns 0 if the degree of the term is equal to the degree of the another term
     * other than that it returns an integer that's greater than 0 if degree of this term is greater
     * than the another term, else returns a integer that's less than = if degree of this term is
     * lower than the degree of another term
     *
     * @param another
     * @return
     */
    public int compareTo(Term another) {
        if (this.getDegree() == another.getDegree())
            return 0;

        else if (this.getDegree() > another.getDegree())
            return -1;
        else
            return 1;
    }

    /**
     * return string representtation of term
     * taht has a format of 4x^2
     * @return
     */
    public String toString() {
        if(coefficient == 0)
            return ""+literal;
        else
            if(coefficient == 1 && degree == 1)
                return ""+literal;
        else
            if(coefficient == 1 && degree != 1)
                return ""+ literal+"^"+degree;
            else
                return (coefficient+literal+"^"+degree);
    }
}
