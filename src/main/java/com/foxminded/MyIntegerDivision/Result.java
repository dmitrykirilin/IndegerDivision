package com.foxminded.MyIntegerDivision;

import java.util.Deque;

public final class Result {
    private final int dividend;
    private final int divider;
    private final int result;
    private final Deque<Integer> intermediateResults;

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public int getResult() {
        return result;
    }

    public Deque<Integer> getIntermediateResults() {
        return intermediateResults;
    }

    public Result(int dividend, int divider, int result, Deque<Integer> stack) {
        this.dividend = dividend;
        this.divider = divider;
        this.result = result;
        this.intermediateResults = stack;
    }
}
