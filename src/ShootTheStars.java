import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class ShootTheStars
{
    public static void main (String[] args)
    {
        Stars myStars = new Stars();
        ShootHelper myHelper = new ShootHelper();
        Scanner myScanner = new Scanner(System.in);
        String userGuess;
        String replay;
        char[] output;
        int result;
        int RESULT_LOST = 0;
        int RESULT_PLAY = 1;
        int RESULT_WIN  = 2;
        int score = 0;
        int totalScore = 0;

        // Show introduction to user.
        myHelper.printOutIntroduction();

        do
        {
            //Pick a random number from 0 to 3.
            Random randomGenerator = new Random();
            int randomNo = randomGenerator.nextInt(3);

            myStars.defineAnswer(randomNo);

            // Get output and print out stars.
            output = myStars.getOutput();
            myHelper.printOutStars(output);

            do
            {
                // Get user guess.
                userGuess = myHelper.getUserInput(randomNo);

                // There will be 3 conditions of the result. 0 for game over, 1 for repeat, 2 for next level.
                result = myStars.checkResult(userGuess);

                // Get output and print out stars.
                output = myStars.getOutput();
                myHelper.printOutStars(output);
            }
            while (result == RESULT_PLAY);

            // If user lost.
            if (result == RESULT_LOST)
            {
                // Print game over.
                System.out.println("Game over! Total score: " + totalScore);

                // Set total score to 0.
                totalScore = myStars.getScore();

                // Give user chance to play again.
                System.out.println("Do you want to play again? Y/N");
                replay = myScanner.nextLine();

                if (Objects.equals(replay, "y") || Objects.equals(replay, "Y"))
                {
                    result = RESULT_PLAY;
                }
                else if (Objects.equals(replay, "n") || Objects.equals(replay, "N"))
                {
                    result = RESULT_LOST;
                }
            }
            // If user move to next level, total up totalScore.
            if (result == RESULT_WIN)
            {
                score = myStars.getScore();
                totalScore = totalScore + score;
                System.out.println("\nCongratulation, you score " + score + " marks! Total score: " + totalScore);
            }

        }while (result != RESULT_LOST);
    }
}
