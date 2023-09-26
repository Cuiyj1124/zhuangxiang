package com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.BestFitAlgorithm.bestFit;

public class test {
    public static void main(String[] args) {
        List<Good> itemSizes = new ArrayList<Good>();

        for(int i =0;i<1000;i++) {
            Random random = new Random();
            // 生成一个随机的2位小数，范围在5到100之间
            double randomValue = 5 + (100 - 5) * random.nextDouble();
            // 保留两位小数
            double roundedValue = Math.round(randomValue * 100.0) / 100.0;
            Good good = new Good(i+"",new BigDecimal(roundedValue).setScale(2, RoundingMode.HALF_UP));
            itemSizes.add(good);
        }
        BigDecimal binCapacity = new BigDecimal("100.00");

        long start = System.currentTimeMillis();
        List<Bin> bins = bestFit(itemSizes, binCapacity);
        long end = System.currentTimeMillis();
        System.out.println("所用时间："+(end-start)+"ms");

        int binNumber = 1;
        for (Bin bin : bins) {
            System.out.println("Bin " + binNumber++ + ": " + bin.toString());
        }
    }
}