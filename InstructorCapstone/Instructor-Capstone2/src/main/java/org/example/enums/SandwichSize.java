package org.example.enums;

public enum SandwichSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int value;

    SandwichSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
