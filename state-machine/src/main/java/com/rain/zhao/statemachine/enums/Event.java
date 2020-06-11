package com.rain.zhao.statemachine.enums;
/**
 * State of Mario
 */
public enum Event {
    /**
     * obtain mashroom
     */
    OBTAIN_MASHROOM(0),
    /**
     * obtain cape
     */
    OBTAIN_CAPE(1),
    /**
     * obtain fire flower
     */
    OBTAIN_FIRE_FLOWER(2),
    /**
     * meet monster
     */
    MEET_MONSTER(3),
    ;
    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}