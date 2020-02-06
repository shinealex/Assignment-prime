package jm.shine.rbs.prime.model;

import java.util.List;

public class PrimeNumber {

    private Integer initial;
    private List<Integer> primeNumbers;

    public PrimeNumber( Integer initial, List<Integer> primeNumbers ) {
        this.initial = initial;
        this.primeNumbers = primeNumbers;
    }

    public PrimeNumber() {
    }

    public Integer getInitial() {
        return initial;
    }

    public void setInitial( Integer initial ) {
        this.initial = initial;
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers( List<Integer> primeNumbers ) {
        this.primeNumbers = primeNumbers;
    }
}
