// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 5
// IDE Name: IntelliJ
public class RemoveDuplicates {
    public static void main(String[] args){
        java.util.Scanner scan = new java.util.Scanner(System.in);

        // tree & array list declaration
        BST<String> stringBST = new BST<>();
        java.util.ArrayList<String> textArray = new java.util.ArrayList<>();

        // MAIN MENU
        boolean runMenu = true;
        while(runMenu){
            try{
                System.out.print("""
                       \s
                       -----------------MAIN MENU---------------
                       1. Read input string
                       2. Remove duplicates and display outputs
                       3. Exit program
                       
                       Enter option number:\s""");
                int input = Integer.parseInt(scan.nextLine());

                // in case user inputs an option not on the menu
                if(input < 1 || input > 3)
                    System.out.println("Invalid menu option. Please choose options 0 - 10.");

                else{
                    switch(input){
                        /* Read Input */
                        case 1:
                            // clears tree and array list for new user input
                            stringBST.clear();
                            textArray.clear();

                            // read user input
                            System.out.print("Enter your text: ");
                            textArray.addAll(java.util.List.of(scan.nextLine().split(" "))); // splits user string into ArrayList

                            // parsing array, inserting each element into BST
                            for(String element: textArray){
                                stringBST.insert(element);
                            }
                            break;


                        /* Remove duplicates and display output */
                        case 2:
                            if(stringBST.isEmpty()){
                                System.out.println("You need to enter a text field first.");
                                break;
                            }

                            System.out.println("\nOriginal Text: ");
                            for(String element: textArray)
                                System.out.print(element+" ");

                            System.out.println("\n\nProcessed Text: ");
                            stringBST.inorder();

                            System.out.println();
                            break;

                        /* Exit */
                        default:
                            System.out.println("Exiting...");
                            runMenu = false;
                    }
                }
            // user inputs non-integer menu option
            }catch(NumberFormatException e){
                System.out.println("Invalid menu option. Please choose from options 1 - 3.");
            }
        }
    }
}
