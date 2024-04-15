package org.example;

public class House {
    private String color;
    private float size;
    private int price;
    private String style;
    private boolean hasChimney;

    public House(String color, float size, int price, String style, boolean hasChimney) {
        this.color = color;
        this.size = size;
        this.price = price;
        this.style = style;
        this.hasChimney = hasChimney;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isHasChimney() {
        return hasChimney;
    }

    public void setHasChimney(boolean hasChimney) {
        this.hasChimney = hasChimney;
    }
}
