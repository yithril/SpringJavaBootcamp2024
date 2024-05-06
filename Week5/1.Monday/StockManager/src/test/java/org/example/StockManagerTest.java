package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockManagerTest {
    private StockManager stockManager;

    @BeforeEach
    void setUp() {
        stockManager = new StockManager();
    }

}