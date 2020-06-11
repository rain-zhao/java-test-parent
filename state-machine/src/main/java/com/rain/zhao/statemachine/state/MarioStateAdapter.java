package com.rain.zhao.statemachine.state;

import com.rain.zhao.statemachine.StatePatternMarioStateMachine;

public abstract class MarioStateAdapter implements MarioState {

    StatePatternMarioStateMachine machine;

    public MarioStateAdapter(StatePatternMarioStateMachine machine) {
        this.machine = machine;
    }

    /**
     * eat mushroom
     */
    public void obtainMushRoom(){
        System.out.println("do nothing!");
    }

    /**
     * get cape
     */
    public void obtainCape(){
        System.out.println("do nothing!");
    }

    /**
     * eat fire flower
     */
    public void obtainFireFlower(){
        System.out.println("do nothing!");
    }

    /**
     * meet monster
     */
    public void meetMonster(){
        System.out.println("do nothing!");
    }

}
