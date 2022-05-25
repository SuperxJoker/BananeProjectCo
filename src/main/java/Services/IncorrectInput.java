package Services;

import Exceptions.EnterAValidNumber;

public class IncorrectInput {
    private boolean correctNumber;

    public void getCorrectNumber(boolean value)
    {
        correctNumber=value;
    }

    public void checkIncorrect() throws EnterAValidNumber {
        if(!correctNumber)
            throw new EnterAValidNumber();
    }
}
