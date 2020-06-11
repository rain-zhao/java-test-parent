package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.State;

import static com.rain.zhao.statemachine.enums.State.*;

public class PlainMarioStateMachine extends MarioStateMachineAdapter {

    /**
     * current state
     */
    private State currentState;

    public PlainMarioStateMachine() {
        System.out.println("game start");
        currentState = SMALL;
    }

    @Override
    public void obtainMushRoom() {
        System.out.println("obtain mushroom");
        if (currentState == SMALL) {
            score += 100;
            currentState = State.SUPER;
        }
    }

    @Override
    public void obtainCape() {
        System.out.println("obtain cape");
        if (currentState == SMALL || currentState == SUPER) {
            score += 200;
            currentState = CAPE;
        }
    }

    @Override
    public void obtainFireFlower() {
        System.out.println("obtain fire flower");
        if (currentState == SMALL || currentState == SUPER) {
            score += 300;
            currentState = FIRE;
        }
    }

    @Override
    public void meetMonster() {
        System.out.println("meet monster");
        if (currentState == SMALL || currentState == SUPER) {
            score -= 100;
        } else if (currentState == CAPE) {
            score -= 200;
        } else if (currentState == FIRE) {
            score -= 300;
        }

        currentState = State.SMALL;
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }
}
