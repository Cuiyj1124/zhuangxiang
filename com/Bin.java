package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bin {


    private BigDecimal capacity;
    private BigDecimal remainingCapacity;
    private List<Good> items;

    public Bin(BigDecimal capacity) {
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean canFit(Good good) {
        if(remainingCapacity.compareTo(good.weight)>0||remainingCapacity.compareTo(good.weight)==0){
            return true;
        }
        return false;
    }

    public void addItem(Good good) {
        if (canFit(good)) {
            items.add(good);
            remainingCapacity = remainingCapacity.subtract(good.weight);
        }
    }

    public BigDecimal getRemainingCapacity() {
        return remainingCapacity;
    }

    public List<Good> getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "{" +
                " totalWeight=" + (capacity.subtract(remainingCapacity)) +
                ", items=" + items +
                '}';
    }
}
