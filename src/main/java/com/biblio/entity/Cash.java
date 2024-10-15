package com.biblio.entity;

import java.io.Serializable;

public class Cash implements Serializable {
    //region Attributes
    private double cashReceived;
    private double change;
    //endregion

    //region Constructors

    public Cash(double cashReceived, double change) {
        this.cashReceived = cashReceived;
        this.change = change;
    }

    //endregion

    //region Getters & Setters

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    //endregion
}
