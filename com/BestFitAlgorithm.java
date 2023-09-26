package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BestFitAlgorithm {

    public static List<Bin> bestFit(List<Good> itemSizes, BigDecimal binCapacity) {
        List<Bin> bins = new ArrayList<>();
        for (Good itemSize : itemSizes) {
            boolean placed = false;
            // 在已有的箱子中找到剩余容量最小的箱子
            Bin bestBin = null;
            for (Bin bin : bins) {
                if (bin.canFit(itemSize) && (bestBin == null || bin.getRemainingCapacity().compareTo(bestBin.getRemainingCapacity())<0)) {
                    bestBin = bin;
                }
            }
            // 如果找到适合的箱子，将物品放入
            if (bestBin != null) {
                bestBin.addItem(itemSize);
                placed = true;
            }

            // 如果没有适合的箱子，创建新箱子并放入
            if (!placed) {
                Bin newBin = new Bin(binCapacity);
                newBin.addItem(itemSize);
                bins.add(newBin);
            }
        }
        return bins;
    }

}
