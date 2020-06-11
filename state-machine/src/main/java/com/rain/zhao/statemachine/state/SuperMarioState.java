package com.rain.zhao.statemachine.state;

import com.rain.zhao.statemachine.StatePatternMarioStateMachine;
import com.rain.zhao.statemachine.enums.State;

public class SuperMarioState extends MarioStateAdapter {
    public SuperMarioState(StatePatternMarioStateMachine machine) {
        super(machine);
    }

    @Override
    public State getState() {
        return State.SUPER;
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
        machine.setState(machine.getSMALL());
        machine.addScore(-100);
    }
}
