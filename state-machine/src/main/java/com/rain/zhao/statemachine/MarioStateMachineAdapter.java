package com.rain.zhao.statemachine;

/**
 * default implement of {@link MarioStateMachine}
 */
public abstract class MarioStateMachineAdapter implements MarioStateMachine {

    /**
     * current score
     */
    protected int score;

    @Override
    public void obtainMushRoom() {
        System.out.println("do nothing!");
    }

    @Override
    public void obtainCape() {
        System.out.println("do nothing!");
    }

    @Override
    public void obtainFireFlower() {
        System.out.println("do nothing!");
    }

    @Override
    public void meetMonster() {
        System.out.println("do nothing!");
    }

    @Override
    public int getScore() {
        return score;
    }

}
