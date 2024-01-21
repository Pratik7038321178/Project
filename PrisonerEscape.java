import java.util.Scanner;

class PrisonerEscape {

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a prison. You have two paths ahead.");

        
        System.out.println("1. Take the left path.");
        System.out.println("2. Take the right path.");

        
        int choice = getPlayerChoice();

        
        if (choice == 1) {
            leftPath();
        } else if (choice == 2) {
            rightPath();
        } else {
            System.out.println("Invalid choice. Please try again.");
            startGame();
        }
    }

    public static int getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice (1 or 2): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

        int choice = scanner.nextInt();
        return choice;
    }

    public static void leftPath() {
        System.out.println("You chose the left path. As you walk further, you encounter a river. ");
        System.out.println("Do you:");
        System.out.println("1. Attempt to swim across.");
        System.out.println("2. Look for a bridge.");

        int choice = getPlayerChoice();

        if (choice == 1) {
            System.out.println("You try to swim across, but the strong current pulls you away.And caught by jailer. Game over!");
        } else if (choice == 2) {
            System.out.println("You find a sturdy bridge and safely cross the river. Well done! now you are free man");
        } else {
            System.out.println("Invalid choice. Please try again.");
            leftPath();
        }
    }

    public static void rightPath() {
        System.out.println("You chose the right path. You come across a cave entrance.");
        System.out.println("Do you:");
        System.out.println("1. Enter the cave.");
        System.out.println("2. Continue along the path.");

        int choice = getPlayerChoice();

        if (choice == 1) {
            System.out.println("As you enter the dark cave, you discover a hidden treasure. Congratulations, you win!");
        } else if (choice == 2) {
            System.out.println("You continue along the path, but it leads to a dead end. Game over!");
        } else {
            System.out.println("Invalid choice. Please try again.");
            rightPath();
        }
    }
}
