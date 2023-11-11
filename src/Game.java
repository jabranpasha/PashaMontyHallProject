public class Game {
    private int door1;
    private int door2;
    private int door3;

    private String goatDoor;
    private String goatDoor2;
    private String carDoor;
    private int contestantChoice;

    public Game() {
        doorRandomizer();
        doorAssigner();
    }

    public void doorRandomizer() {
        door1 = ((int) (Math.random() * 3) + 1);
        door2 = ((int) (Math.random() * 3) + 1);
        door3 = ((int) (Math.random() * 3) + 1);

        while (door1 == door2 || door1 == door3 || door2 == door3) {
            door1 = ((int) (Math.random() * 3) + 1);
            door2 = ((int) (Math.random() * 3) + 1);
            door3 = ((int) (Math.random() * 3) + 1);
        }
    }

    public void doorAssigner() {
        int carBehind = (int) (Math.random() * 3) + 1;

        if (carBehind == 1) {
            carDoor = "door1";
            goatDoor = "door2";
            goatDoor2 = "door3";
        } else if (carBehind == 2) {
            carDoor = "door2";
            goatDoor = "door1";
            goatDoor2 = "door3";
        } else {
            carDoor = "door3";
            goatDoor = "door1";
            goatDoor2 = "door2";
        }
    }

    public void contestantChoosesDoor(int choice) {
        contestantChoice = choice;
    }

    public String switchOrKeep(String userChoice) {
        String userChoiceLower = userChoice.toLowerCase();

        if (userChoiceLower.equals("switch")) {
            // If the contestant chooses to switch, reveal one of the other goat doors
            if (contestantChoice == 1) {
                return doorNotChosenOrCar(2, 3);
            } else if (contestantChoice == 2) {
                return doorNotChosenOrCar(1, 3);
            } else {
                return doorNotChosenOrCar(1, 2);
            }
        } else {
            // If the contestant chooses to keep, reveal one of the other goat doors
            if (contestantChoice == 1) {
                return doorNotChosenOrCar(2, 3);
            } else if (contestantChoice == 2) {
                return doorNotChosenOrCar(1, 3);
            } else {
                return doorNotChosenOrCar(1, 2);
            }
        }
    }

    private String doorNotChosenOrCar(int door1, int door2) {
        if (!goatDoor.equals("door" + door1) && !carDoor.equals("door" + door1)) {
            return "door" + door1;
        } else {
            return "door" + door2;
        }
    }
    public String getCarDoor() {
        return carDoor;
    }
}

