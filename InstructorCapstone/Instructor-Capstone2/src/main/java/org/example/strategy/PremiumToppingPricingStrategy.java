package org.example.strategy;

import org.example.enums.SandwichSize;

import java.math.BigDecimal;

public class PremiumToppingPricingStrategy implements  PricingStrategy {

    @Override
    public BigDecimal getPrice(SandwichSize sandwichSize, BigDecimal basePrice) {
        return basePrice.multiply(BigDecimal.valueOf(sandwichSize.getValue()));
    }
}
