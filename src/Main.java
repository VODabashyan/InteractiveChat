import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to our interactive chat!!!");
        System.out.print("Please enter the number of chat members: ");
        Scanner numberScanner = new Scanner(System.in);
        int chatMembers = 0;

        if (!numberScanner.hasNextInt()) {
            System.out.println("Invalid input! Only numbers are allowed!");
            return;
        }

        Scanner nameScanner = new Scanner(System.in);
        chatMembers = numberScanner.nextInt();
        ArrayList<Member> memberList = new ArrayList<>();

        for (int i = 0; i < chatMembers; i++) {
            System.out.println("Enter a name: ");
            Member member = new Member(nameScanner.nextLine());
            memberList.add(member);
        }

        int command;
        String message;
        Scanner messageScanner = new Scanner(System.in);

        while (!memberList.isEmpty()) {
            Random r = new Random();
            Member selectedMember = memberList.get(r.nextInt(memberList.size()));
            System.out.print(selectedMember.getName() + ", please enter 1 to send a message or 2 to exit: ");
            command = numberScanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println(selectedMember.getName() + " is typing...");
                    message = messageScanner.nextLine();
                    System.out.println(selectedMember.getName() + ": " + message);
                    break;

                case 2:
                    System.out.println(selectedMember.getName() + " has left the chat.");
                    for (int i = 0; i < memberList.size(); i++) {
                        if (memberList.get(i).getName() == selectedMember.getName()) {
                            memberList.remove(i);

                            if(memberList.isEmpty()) {
                                System.out.println("All the chat members have left the chat. Goodbye!");
                            }
                        }
                    }
                    break;
            }
        }
        numberScanner.close();
        nameScanner.close();
        messageScanner.close();
    }
}