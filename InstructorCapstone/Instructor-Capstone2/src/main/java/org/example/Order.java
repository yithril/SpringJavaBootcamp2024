package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private ArrayList<SideItem> sideItems;
    private ArrayList<Sandwich> sandwiches;

    public Order(){
        sideItems = new ArrayList<>();
        sandwiches = new ArrayList<>();
    }

    public ArrayList<SideItem> getSideItems() {
        return sideItems;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich sandwich){
        this.sandwiches.add(sandwich);
    }

    public void addSideItem(SideItem sideItem){
        this.sideItems.add(sideItem);
    }

    public void removeSandwich(Sandwich sandwich){
        this.sandwiches.remove(sandwich);
    }

    public void removeSideItem(SideItem sideItem) {
        this.sideItems.remove(sideItem);
    }

    public BigDecimal getOrderTotal(){
        var sandwichTotal = this.sandwiches.stream().map(x -> x.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        var sideItemTotal = this.sideItems.stream().map(x -> x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

        return sandwichTotal.add(sideItemTotal);
    }
}
