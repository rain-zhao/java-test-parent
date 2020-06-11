package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.Event;
import com.rain.zhao.statemachine.enums.State;

import static com.rain.zhao.statemachine.enums.Event.*;
import static com.rain.zhao.statemachine.enums.State.*;
/**
 * implement using table
 *
 * shift table
 * ------------------------------------------------------------------------------
 * |state\event |got mushroom   |got cape   |got fire flower    |meet momster   |
 * |small       |super/+100     |cape/+200  |fire/+300          |/-100              |
 * |super       |/              |cape/+200  |fire/+300          |small/-100     |
 * |cape        |/              |/          |/                  |small/-200     |
 * |fire        |/              |/          |/                  |small/-300     |
 * ------------------------------------------------------------------------------
 */
public class TableMarioStateMachine extends MarioStateMachineAdapter  {

    /**
     * current state
     */
    private State currentState;

    public TableMarioStateMachine() {
        System.out.println("game start");
        currentState = SMALL;
    }

    private static State[][] transitionTable = {
            {SUPER,CAPE,FIRE,SMALL},
            {SUPER,CAPE,FIRE,SMALL},
            {CAPE,CAPE,CAPE,SMALL},
            {FIRE,FIRE,FIRE,SMALL}
    };

    private static int[][] actionTable = {
            {100,200,300,-100},
            {0  ,200,300,-100},
            {0  ,0  ,0  ,-200},
            {0  ,0  ,0  ,-300},
    };

    @Override
    public void obtainMushRoom() {
        System.out.println("obtain mushroom");
        executeEvent(OBTAIN_MASHROOM);
    }

    @Override
    public void obtainCape() {
        System.out.println("obtain cape");
        executeEvent(OBTAIN_CAPE);
    }

    @Override
    public void obtainFireFlower() {
        System.out.println("obtain fire flower");
        executeEvent(OBTAIN_FIRE_FLOWER);
    }

    @Override
    public void meetMonster() {
        System.out.println("meet monster");
        executeEvent(MEET_MONSTER);
    }

    private void executeEvent(Event event){
        int currentStateVal = currentState.getValue();
        int eventVal =  event.getValue();
        currentState = transitionTable[currentStateVal][eventVal];
        score += actionTable[currentStateVal][eventVal];
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }
}
