import java.util.Scanner;

public class ShootHelper
{
    Scanner myScanner = new Scanner(System.in);
    String userName;
    String[] shapeName = {"triangle", "circle", "rectangle", "cross"};
    String userGuess;
    int location;

    public void printOutStars(char[] output)
    {
        location = 0;

        // Print out the stars.
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                // Print out each character.
                System.out.print(output[location]);

                // Update location.
                location++;
            }

            // Print next line.
            System.out.print("\n");
        }
    }

    public void printOutIntroduction()
    {
        // Game started.
        System.out.println("Game Started!");

        // Request for user's name.
        System.out.println("Enter name: ");
        userName = myScanner.nextLine();

        // Welcome and give instructions.
        System.out.println("\nWelcome " + userName + "! Shoot a shape in the stars. Enter a number from 0 to 15. \nO is for wrong guess. X is for right guess. ");
    }

    public String getUserInput(int randomNo)
    {
        // Print out hint
        System.out.println("\nShoot a " + shapeName[randomNo] + ": ");

        // Get user guess
        userGuess = myScanner.nextLine();
        return userGuess;
    }
}