package org.example.strategy;

import org.example.enums.SandwichSize;

import java.math.BigDecimal;
import java.util.*;

public class BreadPricingStrategy implements PricingStrategy {
    private static final Map<Integer, BigDecimal> breadPrices = Map.of(
            1, BigDecimal.valueOf(5.50), // Small
            2, BigDecimal.valueOf(7.00), // Medium
            3, BigDecimal.valueOf(8.50)  // Large
    );


    @Override
    public BigDecimal getPrice(SandwichSize sandwichSize, BigDecimal basePrice) {
        if(!breadPrices.containsKey(sandwichSize.getValue())){
            throw new IllegalArgumentException("Not a valid size for bread!");
        }
        return breadPrices.get(sandwichSize.getValue());
    }
}
