import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static final ArrayList<String> userList = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);
    private static boolean quit = false;

    public static void main(String[] args)
    {
        do {
            showMenu();
            String choice = SafeInput.getRegExString(in, "Make a menu choice", "^[AaDdIiPpQq]$");

            switch (choice) {
                case "A":
                    addItem();
                    break;

                case "D":
                    deleteItem();
                    break;

                case "I":
                    insertItem();
                    break;

                case "P":
                    printList();
                    break;

                case "Q":
                    quitList();
                    break;
            }
        }while (!quit);
    }

    private static void showMenu ()
    {
        System.out.println("A – Add an item to the list\n" +
                "D – Delete an item from the list\n" +
                "I – Insert an item into the list\n" +
                "P – Print the list\n" +
                "Q – Quit the program");
    }

    private static void addItem ()
    {
        boolean answer = false;
        do {
            String addItem = SafeInput.getNonZeroLenString(in, "Enter what you would like to add");
            userList.add(addItem);
            answer = SafeInput.getYNConfirm(in, "Add another item? [Y/N]");

        }while (answer);
    }

    private static void deleteItem()
    {
        printList();
        int deleteItem = SafeInput.getRangedInt(in, "Enter the number of the item you would like to delete", 1, userList.size());
        userList.remove(deleteItem - 1);
    }

    private static void insertItem ()
    {
        printList();
        int position = SafeInput.getRangedInt(in, "Enter the number of where you want the new item", 1, userList.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter what you would like to insert");
        userList.add(position - 1, item);
    }
    private static void printList ()
    {
        if (userList.isEmpty())
        {
            System.out.println("The list is empty, choose option A to add an item!");
        }
        else
        {
            System.out.println("Current list: "); //
            for(int i = 0; i < userList.size(); i++)
            {
                System.out.println((i + 1)+". "+ userList.get(i));
            }
        }

    }

    private static void quitList ()
    {
        boolean quitList = SafeInput.getYNConfirm(in, "Are you sure you want to quit? [Y/N]");
    }


}