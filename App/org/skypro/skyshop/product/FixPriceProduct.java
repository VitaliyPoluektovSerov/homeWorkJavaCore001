package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int FIXED_PRICE;

    static {
        FIXED_PRICE = 555;
    }

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName()+": Фиксированная цена "+getPrice();
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
