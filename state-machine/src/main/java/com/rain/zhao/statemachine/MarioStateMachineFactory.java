package com.rain.zhao.statemachine;

import com.rain.zhao.statemachine.enums.MarioStateMachineType;

import java.util.HashMap;
import java.util.Map;

public class MarioStateMachineFactory {

    private static Map<MarioStateMachineType,Class<? extends MarioStateMachine>> stateMachineMap;

    static{
        stateMachineMap = new HashMap<>();
        stateMachineMap.put(MarioStateMachineType.PLAIN,PlainMarioStateMachine.class);
        stateMachineMap.put(MarioStateMachineType.TABLE,TableMarioStateMachine.class);
        stateMachineMap.put(MarioStateMachineType.STATE_PATTERN,StatePatternMarioStateMachine.class);
    }

    /**
     * factory method
     * return {@code null} if this type not found
     * {@link MarioStateMachineType}
     * {@link MarioStateMachine}
     * @param type  state machine type
     * @return MarioStateMachine instance
     */
    public static MarioStateMachine getMarioStateMachine(MarioStateMachineType type) throws IllegalAccessException, InstantiationException {
        return stateMachineMap.get(type).newInstance();
    }

}
