import java.util.ArrayList;

public class UserHandler
{
    public static void registerUser(ArrayList<String> userNames, ArrayList<String> phoneNumbers, String name, String phoneNumber)
    {
        userNames.add(name);
        phoneNumbers.add(phoneNumber);
    }

    public static void displayAllUsers(ArrayList<String> userNames, ArrayList<String> phoneNumbers)
    {
        for (int i = 0; i < userNames.size(); i++)
        {
            System.out.println("Name: " + userNames.get(i) + " Phone Number: " + phoneNumbers.get(i));
        }
    }

    public static String searchUser(ArrayList<String> userNames, ArrayList<String> phoneNumbers, String name)
    {
        for (int i = 0; i < userNames.size(); i++)
        {
            if (userNames.get(i) == name)
            {
                return phoneNumbers.get(i);
            }
        }
        return "Error";
    }
}
