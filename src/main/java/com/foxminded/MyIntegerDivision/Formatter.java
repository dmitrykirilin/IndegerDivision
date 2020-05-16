package com.foxminded.MyIntegerDivision;

import java.util.StringJoiner;

public class Formatter {

    private Result result;

    public String format(Result result) {
        this.result = result;
        StringJoiner outputString = new StringJoiner("");
        outputString.add("_" + result.getDividend() + "|" + result.getDivider() + "\n");

        int countOfDigitsInDividend = getCountOfDigits(result.getDividend());
        int countOfDigitsInPeek = getCountOfDigits(getPeekNumber());
        int countOfSpaces = countOfDigitsInDividend - countOfDigitsInPeek;
        int countOfDigitsInResult = getCountOfDigits(result.getResult());
        outputString.add(" " + result.getIntermediateResults().pop() + repeatSymbol(countOfSpaces, " ")
                                + "|" + repeatSymbol(countOfDigitsInResult, "-") + "\n");

        outputString.add(" " + repeatSymbol(countOfDigitsInDividend - countOfSpaces, "-") + repeatSymbol(countOfSpaces, " ")
                                + "|" + result.getResult() + "\n");

        outputString.add(displayCalculatingSausage(countOfDigitsInPeek));
        return outputString.toString();
    }

    private String displayCalculatingSausage(int countOfDigitsInPrevious) {
        StringJoiner sausage = new StringJoiner("");
        int countOfDigits = getCountOfDigits(getPeekNumber());
        int numberOfSort = countOfDigitsInPrevious + 1;
        while (result.getIntermediateResults().size() > 1) {
            numberOfSort++;
            int countOfSpaces = numberOfSort - countOfDigits;

            sausage.add(repeatSymbol(countOfSpaces - 1, " ") + "_" + result.getIntermediateResults().pop() + "\n");
            sausage.add(repeatSymbol(countOfSpaces, " ") + result.getIntermediateResults().pop() + "\n");
            sausage.add(repeatSymbol(countOfSpaces, " ") + repeatSymbol(countOfDigits, "-") + "\n");

            countOfDigits = getCountOfDigits(getPeekNumber());

        }
        sausage.add(repeatSymbol(numberOfSort - getCountOfDigits(getPeekNumber()), " ") + result.getIntermediateResults().pop());
        return sausage.toString();
    }

    protected String repeatSymbol(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    protected int getCountOfDigits(int number){
        if (number == 0){
            return 1;
        }
        return (int)Math.log10(number) + 1;
    }

    protected int getPeekNumber(){
        if(!result.getIntermediateResults().isEmpty()){
            return result.getIntermediateResults().peek();
        }else{
            throw new NullPointerException("List is empty!");
        }
    }
}
