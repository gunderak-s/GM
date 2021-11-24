package com.company;

public class TaxCell extends  Cell{

private CardActivity tax;

    public TaxCell(CardActivity tax) {
        this.tax = tax;
    }

    public CardActivity getTax() {
        return tax;
    }
}
