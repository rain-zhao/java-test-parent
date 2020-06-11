package com.rain.zhao.statemachine.enums;

/**
 * mario state mahine type
 */
public enum MarioStateMachineType {

    /**
     * plain implement of mario state machine
     * using if/else case
     * {@link com.rain.zhao.statemachine.PlainMarioStateMachine}
     */
    PLAIN(0),

    /**
     * table implement of of mario state machine
     * {@link com.rain.zhao.statemachine.TableMarioStateMachine}
     */
    TABLE(1),

    /**
     * state pattern implement of of mario state machine
     * {@link com.rain.zhao.statemachine.StatePatternMarioStateMachine}
     */
    STATE_PATTERN(2),
    ;


    int value;

    MarioStateMachineType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
