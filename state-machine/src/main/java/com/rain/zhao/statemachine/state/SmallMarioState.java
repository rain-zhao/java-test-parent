package com.rain.zhao.statemachine.state;

import com.rain.zhao.statemachine.StatePatternMarioStateMachine;
import com.rain.zhao.statemachine.enums.State;

public class SmallMarioState extends MarioStateAdapter {
    public SmallMarioState(StatePatternMarioStateMachine machine) {
        super(machine);
    }

    @Override
    public State getState() {
        return State.SMALL;
    }

    /**
     * eat mushroom
     */
    @Override
    public void obtainMushRoom(){
        machine.setState(machine.getSUPER());
        machine.addScore(100);
    }

    /**
     * get cape
     */
    @Override
    public void obtainCape(){
        machine.setState(machine.getCAPE());
        machine.addScore(200);
    }

    /**
     * eat fire flower
     */
    @Override
    public void obtainFireFlower(){
        machine.setState(machine.getFIRE());
        machine.addScore(300);
    }

    /**
     * meet monster
     */
    @Override
    public void meetMonster(){
        machine.addScore(-100);
    }
}
