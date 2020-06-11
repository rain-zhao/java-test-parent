package com.rain.zhao.statemachine.state;

import com.rain.zhao.statemachine.StatePatternMarioStateMachine;
import com.rain.zhao.statemachine.enums.State;

public class CapeMarioState extends MarioStateAdapter {
    public CapeMarioState(StatePatternMarioStateMachine machine) {
        super(machine);
    }

    @Override
    public State getState() {
        return State.CAPE;
    }

    /**
     * meet monster
     */
    @Override
    public void meetMonster(){
        machine.setState(machine.getSMALL());
        machine.addScore(-200);
    }
}
