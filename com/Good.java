package com;

import java.math.BigDecimal;

public class Good {

    public String no;
    public BigDecimal weight;


    public Good(String no, BigDecimal weight) {
        this.no = no;
        this.weight = weight;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  no ;
    }
}
