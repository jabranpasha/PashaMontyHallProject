import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Monty Hall Door Guesser Game!");
        System.out.println("Behind one door is a car, and behind the other two are goats.");

        System.out.print("Choose a door (1, 2, or 3): ");
        String userChoice = scanner.nextLine();

        System.out.println("You chose Door " + userChoice);
        System.out.println("Now, let's see what's behind one of the other doors...");

        // Simulate revealing a goat
        int revealedGoat = (int) (Math.random() * 3) + 1;
        while (Integer.toString(revealedGoat).equals(userChoice)) {
            revealedGoat = (int) (Math.random() * 3) + 1;
        }
        System.out.println("Behind Door " + revealedGoat + " is a goat.");

        System.out.print("Do you want to switch your guess or keep your original choice? (switch/keep): ");
        String switchOrKeep = scanner.nextLine().toLowerCase();

        if (!switchOrKeep.equals("switch") && !switchOrKeep.equals("keep")) {
            System.out.println("Invalid choice. Please choose 'switch' or 'keep'.");
            return;
        }

        // Simulate game logic here based on the user's choice
        String result = getResultMessage(switchOrKeep, revealedGoat, userChoice);

        // Determine and reveal the final result
        System.out.println(result);

        scanner.close();
    }

    private static String getResultMessage(String switchOrKeep, int revealedGoat, String userChoice) {
        String result = "You chose to " + switchOrKeep + " your guess.";

        if (switchOrKeep.equals("switch")) {
            if (revealedGoat != Integer.parseInt(userChoice)) {
                result += " You win! The car was behind this door";
            } else {
                result += " You lose! The car was behind the other door ";
            }
        } else {
            if (revealedGoat == Integer.parseInt(userChoice)) {
                result += " You win! The car was behind this door";
            } else {
                result += " You lose! The car was behind the other door ";
            }
        }

        return result;
    }
}
