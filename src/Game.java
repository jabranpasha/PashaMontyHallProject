public class Game {
    private int door1;
    private int door2;
    private int door3;
    private int winningDoor;

    public Game() {
        doorRandomizer();
    }

    public void doorRandomizer() {
        door1 = 1;
        door2 = 2;
        door3 = 3;

        winningDoor = ((int) (Math.random() * 3) + 1);

        while (door1 == winningDoor || door2 == winningDoor || door3 == winningDoor) {
            winningDoor = ((int) (Math.random() * 3) + 1);
        }
    }

    public String switchOrKeep(String userChoice) {
        String userChoiceLower = userChoice.toLowerCase();

        if (userChoiceLower.equals("switch")) {
            int doorToReveal = revealDoorWithoutPrize();

            while (doorToReveal == Integer.parseInt(userChoice) || doorToReveal == winningDoor) {
                doorToReveal = revealDoorWithoutPrize();
            }

            if (door1 != Integer.parseInt(userChoice) && door1 != doorToReveal) {
                userChoice = Integer.toString(door1);
            } else if (door2 != Integer.parseInt(userChoice) && door2 != doorToReveal) {
                userChoice = Integer.toString(door2);
            } else {
                userChoice = Integer.toString(door3);
            }
        }

        if (Integer.parseInt(userChoice) == winningDoor) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    public int revealDoorWithoutPrize() {
        int doorToReveal = ((int) (Math.random() * 3) + 1);

        while (doorToReveal == winningDoor) {
            doorToReveal = ((int) (Math.random() * 3) + 1);
        }

        return doorToReveal;
    }
}
