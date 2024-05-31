package org.example.strategy;

import org.example.enums.SandwichSize;

import java.math.BigDecimal;

public class RegularToppingPricingStrategy implements  PricingStrategy {

    @Override
    public BigDecimal getPrice(SandwichSize sandwichSize, BigDecimal basePrice) {
        return BigDecimal.valueOf(0);
    }
}
