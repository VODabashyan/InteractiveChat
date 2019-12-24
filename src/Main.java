import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our interactive chat!!!");
        System.out.print("Please enter the number of chat members: ");

        Scanner in = new Scanner(System.in);
        int chatMembers = in.nextInt();

        ArrayList<Member> memberList = new ArrayList<>();
        for (int i = 0; i < chatMembers; i++) {
            memberList.add(new Member(i + 1));
        }

        int command;
        String message;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1 to send a message or 2 to exit: ");


        while (!memberList.isEmpty()) {
            message = s.nextLine();

            if (message.equals("2")) {
                System.out.println("A member left the chat!");
                memberList.remove(0);
            } else if (message.equals("1")) {
                System.out.println("Type a message!");
                continue;
            } else {
                Random r = new Random();
                Member member = memberList.get(r.nextInt(memberList.size()));
                System.out.println(member + message);
            }
        }
    }
}


