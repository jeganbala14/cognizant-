import java.util.HashMap;
import java.util.Scanner;

public class pro25 {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student ID and name (type 'exit' to stop):");
        while (true) {
            System.out.print("Enter student ID: ");
            String idInput = scanner.nextLine();
            if (idInput.equalsIgnoreCase("exit")) break;

            int id;
            try {
                id = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid integer.");
                continue;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to retrieve name: ");
        int searchId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
