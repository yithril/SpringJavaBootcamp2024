package org.example;

import java.math.BigDecimal;
import org.example.enums.SideItemType;

public class SideItem {
    private int id;
    private BigDecimal price;
    private int size;
    private String name;
    private boolean isSizeVariant;
    private SideItemType sideItemType;

    public SideItem(int id, BigDecimal price, int size, String name, boolean isSizeVariant, SideItemType sideItemType) {
        this.id = id;
        this.price = price;
        this.size = size;
        this.name = name;
        this.isSizeVariant = isSizeVariant;
        this.sideItemType = sideItemType;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public boolean isSizeVariant() {
        return isSizeVariant;
    }

    public SideItemType getSideItemType() {
        return sideItemType;
    }
}
