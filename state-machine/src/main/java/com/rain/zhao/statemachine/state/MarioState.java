package com.rain.zhao.statemachine.state;

import com.rain.zhao.statemachine.enums.State;

public interface MarioState {

    /**
     * eat mushroom
     */
    void obtainMushRoom();

    /**
     * get cape
     */
    void obtainCape();

    /**
     * eat fire flower
     */
    void obtainFireFlower();

    /**
     * meet monster
     */
    void meetMonster();

    /**
     * get current state
     * @return current state
     */
    State getState();
}
