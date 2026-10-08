/*
Name: Erron John A Gabriel
Date 10/8/2026
 */

import java.util.LinkedList ;
public class Polynomial {
    private  LinkedList<Term>terms;

    public Polynomial()throws Exception{
        terms = new LinkedList<Term>();
    }

    public void addTerm(Term newTerm) throws Exception{
        int ctr;

        boolean found = false;
        Term currTerm = null;

        for(ctr = 0; ctr < terms.size(); ctr++){
            currTerm = terms.get(ctr);

            if(currTerm.getDegree() <= newTerm.getDegree()){
                found = true;
                break;
            }
        }

        if(!found){
            terms.add(newTerm);
        }else{
            currTerm.setCoefficient((currTerm.getCoefficient() + newTerm.getCoefficient()));
            if ( currTerm.getCoefficient() == 0){
                terms.remove(ctr);
            }
        }
    }
}
