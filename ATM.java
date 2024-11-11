import java.text.DecimalFormat;
import java.util.Scanner;

public class ATM {
    // Created a public method that each case in the switch block can use in order to format the numbers to improve readability.
    public static String formatBalance(double balance) {
    DecimalFormat formatter = new DecimalFormat("#,##0.00");
    return formatter.format(balance);
    }

    public static void main(String[] args) {
        // Below initialises the variables balance, withdraw and deposit.
        int balance = 100000, withdraw, deposit;



        // To get user input, a scanner class is created.
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Barclays ATM");
            System.out.println("Press a number for the operation you would like to perform");
            System.out.println("Option 1: Check Balance");
            System.out.println("Option 2: Deposit");
            System.out.println("Option 3: Withdraw");
            System.out.println("Option 4: Exit");

            // Above is the ATM menu. We need a while loop to be able to access ATM options until user chooses to exit.

            // Get user input
            int selectedOption = userInput.nextInt();

            switch (selectedOption) {
                case 1:
                    System.out.println("Your current balance is: £" + formatBalance(balance));
                    System.out.println("Would you like to perform another action? (Y/N)");
                    String option1 = userInput.next();
                    if (option1.equalsIgnoreCase("Y")) {
                        break;
                    } else if (option1.equalsIgnoreCase("N")) {
                        System.out.println("Thank you for using our services. Have a lovely day!");
                        return;
                    } else {
                        System.out.println("Sorry, that is not a valid option. You have been returned to the home screen.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the amount you would like to deposit");
                    deposit = userInput.nextInt();
                    balance = balance + deposit;
                    System.out.println("Deposit successful. Your updated balance is: £" + formatBalance(balance));
                    System.out.println("Would you like to perform another action? (Y/N)");
                    String option2 = userInput.next();
                    if (option2.equalsIgnoreCase("Y")) {
                        break;
                    } else if (option2.equalsIgnoreCase("N")) {
                        System.out.println("Thank you for using our services. Have a lovely day!");
                        return;
                    } else {
                        System.out.println("Sorry, that is not a valid option. You have been returned to the home screen.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the amount you would like to withdraw:");
                    withdraw = userInput.nextInt();
                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        System.out.println("Withdrawal successful. Your updated balance is: " + formatBalance(balance));
                    } else {
                        System.out.println("Withdrawal unsuccessful. You do not have sufficient funds to perform this action. Maximum withdrawal is: £" + formatBalance(balance) + ".");
                    }
                    System.out.println("Would you like to perform another action? (Y/N)");
                    String option3 = userInput.next();
                    if (option3.equalsIgnoreCase("Y")) {
                        break;
                    } else if (option3.equalsIgnoreCase("N")) {
                        System.out.println("Thank you for using our services. Have a lovely day!");
                        return;
                    } else {
                        System.out.println("Sorry, that is not a valid option");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our services.");
                    userInput.close();
                    return;

                default:
                    System.out.println("Sorry, that is not a valid option. You have been returned to the home screen.");
                    break;

            }


        }
    }
}
