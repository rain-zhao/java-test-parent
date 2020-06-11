package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.State;
import com.rain.zhao.statemachine.state.*;
import lombok.Getter;

/**
 * implement state machine using state pattern
 */
public class StatePatternMarioStateMachine extends MarioStateMachineAdapter {

    @Getter
    MarioState SMALL;
    @Getter
    MarioState SUPER;
    @Getter
    MarioState CAPE;
    @Getter
    MarioState FIRE;

    MarioState currentState;

    public StatePatternMarioStateMachine() {
        SMALL = new SmallMarioState(this);
        SUPER = new SuperMarioState(this);
        CAPE = new CapeMarioState(this);
        FIRE = new FireFlowerMarioState(this);
        this.currentState = SMALL;
    }

    @Override
    public void obtainMushRoom() {
        System.out.println("obtain mushroom");
        currentState.obtainMushRoom();
    }

    @Override
    public void obtainCape() {
        System.out.println("obtain cape");
        currentState.obtainCape();
    }

    @Override
    public void obtainFireFlower() {
        System.out.println("obtain fire flower");
        currentState.obtainFireFlower();
    }

    @Override
    public void meetMonster() {
        System.out.println("meet monster");
        currentState.meetMonster();
    }

    @Override
    public State getCurrentState() {
        return currentState.getState();
    }

    public void setState(MarioState state){
        currentState = state;
    }

    public void addScore(int delta){
        score += delta;
    }
}
