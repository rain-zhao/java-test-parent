package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.MarioStateMachineType;

public class MarioStateMachineApplication {

    public static void main(String[] args) {
        //plain implement
        doDemo(MarioStateMachineType.PLAIN);
        //table implement
        doDemo(MarioStateMachineType.TABLE);
        //state pattern implement
        doDemo(MarioStateMachineType.STATE_PATTERN);
    }

    private static void doDemo(MarioStateMachineType type){
        MarioStateMachine machine = null;
        try {
            machine = MarioStateMachineFactory.getMarioStateMachine(type);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        machine.obtainMushRoom();
        System.out.println("current state:"+ machine.getCurrentState()+",current score:"+machine.getScore());
        machine.obtainMushRoom();
        System.out.println("current state:"+ machine.getCurrentState()+",current score:"+machine.getScore());
        machine.obtainCape();
        System.out.println("current state:"+ machine.getCurrentState()+",current score:"+machine.getScore());
        machine.meetMonster();
        System.out.println("current state:"+ machine.getCurrentState()+",current score:"+machine.getScore());
        machine.obtainFireFlower();
        System.out.println("current state:"+ machine.getCurrentState()+",current score:"+machine.getScore());
    }
}
