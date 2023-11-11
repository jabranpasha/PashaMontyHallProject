import java.util.Scanner;

public class GameRunner{
    public static void main(String[] args) {
        System.out.println("Welcome to the Monty Hall Game!");
        System.out.println("Behind one of these doors is a car, and behind the other two are goats.");

        Game montyHallGame = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a door (1, 2, or 3):");
        int userChoice = scanner.nextInt();
        montyHallGame.contestantChoosesDoor(userChoice);

        System.out.println("You chose door " + userChoice + ". Let's see what's behind one of the other doors...");

        // Simulate Monty revealing a goat behind one of the other doors
        String revealedGoatDoor = montyHallGame.switchOrKeep("revealGoat");
        System.out.println("Behind " + revealedGoatDoor + " is a goat.");

        // Ask the user if they want to switch or keep their original choice
        System.out.println("Do you want to stick with your choice or switch to the other unopened door?");
        String userSwitchChoice = scanner.next();

        // Get the final result based on the user's choice
        String finalResult = montyHallGame.switchOrKeep(userSwitchChoice);

        // Reveal the final result
        System.out.println("Behind the door you " + userSwitchChoice + "ed to is...");

        // Check if the user won or lost
        if (finalResult.equals(montyHallGame.getCarDoor())) {
            System.out.println("Congratulations! You won the car!");
        } else {
            System.out.println("Sorry, behind door " + finalResult + " is a goat. The car was behind door " + montyHallGame.getCarDoor() + ". Better luck next time!");
        }

    }
}
