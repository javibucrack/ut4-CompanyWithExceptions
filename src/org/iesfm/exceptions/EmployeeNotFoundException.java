package org.iesfm.exceptions;

public class EmployeeNotFoundException extends Exception{
    private String nif;

    public EmployeeNotFoundException(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
