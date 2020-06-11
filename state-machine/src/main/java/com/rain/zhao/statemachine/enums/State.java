package com.rain.zhao.statemachine.enums;

/**
 * State of Mario
 */
public enum State {
    /**
     * small mario
     */
    SMALL(0),
    /**
     * super mario
     */
    SUPER(1),
    /**
     * fire mario
     */
    CAPE(2),
    /**
     * mario with cape
     */
    FIRE(3),
    ;
    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
