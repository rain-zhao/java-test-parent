package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.State;

/**
 * state machine interface
 */
public interface MarioStateMachine {
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
     * get current score
     * @return curr score
     */
    int getScore();

    /**
     * get current state
     * @return current state
     */
    State getCurrentState();

}
