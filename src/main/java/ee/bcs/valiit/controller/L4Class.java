package ee.bcs.valiit.controller;

public class L4Class {
    private String accountNr;
    private String name;
    private Double balance;
    private boolean locked;

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
