package org.example.strategy;

import org.example.enums.SandwichSize;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice(SandwichSize sandwichSize, BigDecimal basePrice);
}
