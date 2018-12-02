import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Stars
{
    int RESULT_LOST = 0;
    int RESULT_PLAY = 1;
    int RESULT_WIN  = 2;

    int numOfGuess = 0;
    int numOfRight = 0;
    int numOfWrong = 0;
    int score = 0;

    // Initialize the output.
    int targetSize;
    char[] output = {'*','*','*','*',
            '*','*','*','*',
            '*','*','*','*',
            '*','*','*','*'};

    // Declare ArrayList.
    ArrayList shapeLocation = new ArrayList();
    ArrayList answered = new ArrayList();

    public void defineAnswer(int randomNo)
    {
        // For new game, reset.
        numOfGuess = 0;
        numOfRight = 0;
        numOfWrong = 0;
        score = 0;
        shapeLocation.clear();
        answered.clear();
        output = new char[]
                        {'*', '*', '*', '*',
                        '*', '*', '*', '*',
                        '*', '*', '*', '*',
                        '*', '*', '*', '*'};

        Integer[] triangleLocation = {0,1,2,3,5,7,10,11,15};
        Integer[] circleLocation = {1,2,4,7,8,11,13,14};
        Integer[] squareLocation = {0,1,2,3,4,7,8,11,12,13,14,15};
        Integer[] crossLocation = {0,3,5,6,9,10,12,15};

        switch (randomNo)
        {
            case 0: Collections.addAll(shapeLocation, triangleLocation); break; // Insert value from triangleLocation into shapeLocation.
            case 1: Collections.addAll(shapeLocation, circleLocation); break; // Insert value from triangleLocation into shapeLocation.
            case 2: Collections.addAll(shapeLocation, squareLocation); break; // Insert value from triangleLocation into shapeLocation.
            case 3: Collections.addAll(shapeLocation, crossLocation); break; // Insert value from triangleLocation into shapeLocation.
        }
        // Get the shape location's size.
        targetSize = shapeLocation.size();
    }

    public int checkResult(String userGuess)
    {
        int guess;

        // Check if user guess is not numbers or out of range.
        switch (userGuess)
        {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "11":
            case "12":
            case "13":
            case "14":
            case "15":
                // Change user guess to integer.
                guess = Integer.parseInt(userGuess);
                break;

            default:
                // User guess is not numbers or out of range.
                System.out.println("The answer is out of range! Please enter other value. ");
                return RESULT_PLAY;
        }

        //Check if user guess is same as previous.
        boolean isAnswered = answered.contains(guess);
        if (isAnswered)
        {
            System.out.println("You already answered this location! Please enter other value. ");
            return RESULT_PLAY;
        }

        // Put the answered guess in an ArrayList.
        answered.add(guess);

        //Check if user guess is same as shapelocation
        boolean isIn = shapeLocation.contains(guess);

        // Decide right or wrong.
        if (isIn)
        {
            output[guess] = 'X';
            //shapeLocation.remove(guess);
            numOfRight++;
        }
        else
        {
            output[guess] = 'O';
            numOfWrong++;
        }

        // Decide result.
        if(numOfRight == targetSize)
        {
            // User can move to next level.
            return RESULT_WIN;
        }
        if (numOfWrong == 5)
        {
            // Game over.
            return RESULT_LOST;
        }
        else
        {
            // Continue playing.
            return RESULT_PLAY;
        }
    }

    public char[] getOutput()
    {
        return output;
    }

    public int getScore()
    {
        // For each wrong answer, 10 marks will be deducted.
        score = 50 - (numOfWrong*10);
        return score;
    }
}
