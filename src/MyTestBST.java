// Name: Tyler Stroud
// Class: CS 3305/section W01
// Term: Spring 2025
// Instructor: Emin Mary Abraham
// Assignment: 5
// IDE Name: IntelliJ
public class MyTestBST {
    public static void main(String[] args){
        java.util.Scanner scan = new java.util.Scanner(System.in);

        // tree declarations
        BST<Integer> intBST = new BST<>();
        BST<String> stringBST = new BST<>();
        String treeType = " ";

        // MAIN MENU
        boolean runMenu = true;
        while(runMenu){
            try{
                System.out.print("""
                       \s
                       ----------------MAIN MENU---------------
                       0. Enter Tree Data Type (integer or string)
                       1. Insert Data Element
                       2. Delete Data Element
                       3. Search for Data Element
                       4. Print Tree Size
                       5. Path from Root to Data Element
                       6. Check if Empty Tree
                       7. Print Preorder Traversal
                       8. Print Inorder Traversal
                       9. Print Postorder Traversal
                       10. Exit program
                       
                       Enter option number:\s""");
                int input = Integer.parseInt(scan.nextLine());

                // in case user inputs an option not on the menu
                if(input < 0 || input > 10)
                    System.out.println("Invalid menu option. Please choose options 0 - 10.");

                // in case user inputs an option other than 0 without declaring a tree data type
                else if(treeType.equals(" ") && input != 0)
                    System.out.println("Please enter a valid tree data type first.");

                // menu functions
                else {
                    switch (input) {
                        /* Tree Data Type */
                        case 0:
                            treeType = " ";
                            // checks for valid input of tree data type
                            while(!treeType.equalsIgnoreCase("string") && !treeType.equalsIgnoreCase("integer"))
                            {
                                System.out.print("\nEnter a tree data type (String or Integer): ");
                                treeType = scan.nextLine().toUpperCase();

                                if (!treeType.equals("STRING") && !treeType.equals("INTEGER"))
                                    System.out.println("Invalid data type.");
                            }
                            System.out.println("Your tree data type is: "+treeType);
                            break;

                        // cases 1-9 will be uniformly split between integer and string outputs by if/else
                        // if(int) else(string)

                        /* Insert Element */
                        case 1:
                            // -- int tree --
                            if(treeType.equals("INTEGER")){
                                try {
                                    System.out.print("Enter the <Integer> data element you want to insert: ");
                                    int element = Integer.parseInt(scan.nextLine());

                                    // output
                                    System.out.print("\nTesting method Insert Data Element (option 1)\n" +
                                                     "BST before inserting "+element+" (Inorder):\t");
                                    intBST.inorder();
                                    intBST.insert(element); // inserts element
                                    System.out.print("\nBST after inserting "+element+" (Inorder):\t");
                                    intBST.inorder(); // prints new BST
                                    System.out.println();
                                    break;

                                }catch(NumberFormatException e){ // in case user doesn't input an Integer element
                                    System.out.println("That is not a valid data element for this tree.");
                                    break;
                                }
                            }

                            // -- string tree --
                            else{
                                System.out.print("Enter the <String> data element you want to insert: ");
                                String element = scan.nextLine();

                                // output
                                System.out.print("\nTesting method Insert Data Element (option 1)\n" +
                                                  "BST before inserting "+element+" (Inorder):\t");
                                stringBST.inorder();
                                stringBST.insert(element); // inserts element
                                System.out.printf("\nBST after inserting "+element+" (Inorder):\t");
                                stringBST.inorder(); // prints new BST
                                System.out.println();
                            }
                            break;

                        /* Delete Element */
                        case 2:
                            if(treeType.equals("INTEGER")){
                                try {
                                    System.out.print("Enter the <Integer> data element you want to delete: ");
                                    int element = Integer.parseInt(scan.nextLine());

                                    // output
                                    System.out.print("\nTesting method Delete Data Element (option 2)\n" +
                                                     "BST before deleting "+element+" (Inorder):\t");
                                    intBST.inorder();
                                    intBST.delete(element); // deletes element
                                    System.out.print("\nBST after delete "+element+" (Inorder):\t");
                                    intBST.inorder(); // prints new BST
                                    System.out.println();
                                    break;

                                }catch(NumberFormatException e){ // in case user doesn't input an Integer element
                                    System.out.println("That is not a valid data element for this tree.");
                                    break;
                                }
                            }

                            else{
                                System.out.print("Enter the <String> data element you want to delete: ");
                                String element = scan.nextLine();

                                // output
                                System.out.print("\nTesting method Delete Data Element (option 2)\n" +
                                                  "BST before deleting "+element+" (Inorder):\t");
                                stringBST.inorder();
                                stringBST.delete(element); // deletes element
                                System.out.printf("\nBST after deleting "+element+" (Inorder):\t");
                                stringBST.inorder(); // prints new BST
                                System.out.println();
                            }
                            break;

                        /* Search for Element */
                        case 3:
                            if(treeType.equals("INTEGER")){
                                try {
                                    System.out.print("Enter the <Integer> data element you want to find: ");
                                    int element = Integer.parseInt(scan.nextLine());

                                    // output
                                    System.out.print("\nTesting method Search for Data Element (option 3)\n" +
                                            "Is element "+element+" in the tree? "+intBST.search(element)+"\n");
                                    break;

                                }catch(NumberFormatException e){ // in case user doesn't input an Integer element
                                    System.out.println("That is not a valid data element for this tree.");
                                    break;
                                }
                            }

                            else{
                                System.out.print("Enter the <String> data element you want to find: ");
                                String element = scan.nextLine();

                                // output
                                System.out.print("\nTesting method Search for Data Element (option 3)\n" +
                                        "Is element "+element+" in the tree? "+stringBST.search(element)+"\n");
                            }
                            break;

                        /* Tree Size */
                        case 4:
                            if(treeType.equals("INTEGER"))
                                System.out.println("Testing method Tree size (Option 4)\nTree size: "+ intBST.getSize());

                            else
                                System.out.println("Testing method Tree size (Option 4)\nTree size: "+ stringBST.getSize());

                            break;

                        /* Path to Element */
                        case 5:
                            if(treeType.equals("INTEGER")){
                                try {
                                    System.out.print("Enter the <Integer> data element you want to find the path to: ");
                                    int element = Integer.parseInt(scan.nextLine());

                                    // checking for element in tree
                                    if(!intBST.search(element))
                                        System.out.println("That element does not exist within this tree.");

                                    // output
                                    else {
                                        System.out.print("\nTesting method Path from Root to Data Element (option 5)\n" +
                                                "Path from root to " + element + ": ");

                                        // creating printable ArrayList for .path() output
                                        java.util.ArrayList<BST.TreeNode<Integer>> path = intBST.path(element);
                                        // printing path data
                                        for(BST.TreeNode<Integer> obj: path){
                                            System.out.print(obj.element+" ");
                                        }
                                        System.out.println();
                                    }
                                    break;

                                }catch(NumberFormatException e){ // in case user doesn't input an Integer element
                                    System.out.println("That is not a valid data element for this tree.");
                                    break;
                                }
                            }

                            else{
                                System.out.print("Enter the <String> data element you want to find the path to: ");
                                String element = scan.nextLine();

                                // checking for element in tree
                                if(!stringBST.search(element))
                                    System.out.println("That element does not exist within this tree.");

                                // output
                                else {
                                    System.out.print("\nTesting method Path from Root to Data Element (option 5)\n" +
                                            "Path from root to " + element + ": ");

                                    // creating printable ArrayList for .path() output
                                    java.util.ArrayList<BST.TreeNode<String>> path = stringBST.path(element);
                                    // printing path data
                                    for(BST.TreeNode<String> obj: path){
                                        System.out.print(obj.element+" ");
                                    }
                                    System.out.println();
                                }
                            }
                            break;

                        /* Check Empty Tree */
                        case 6:
                            System.out.println("Testing method Check if Empty Tree (Option 6)\n" +
                                    "Is empty tree? "+(intBST.isEmpty() && stringBST.isEmpty()));

                            break;

                        /* Print Preorder */
                        case 7:
                            if(treeType.equals("INTEGER")){
                                System.out.print("\nTesting method Preorder Traversal (Option 7)\nPreorder: ");
                                intBST.preorder();
                                System.out.println();
                            }

                            else{
                                System.out.print("\nTesting method Preorder Traversal (Option 7)\nPreorder: ");
                                stringBST.preorder();
                                System.out.println();
                            }
                            break;

                        /* Print Inorder */
                        case 8:
                            if(treeType.equals("INTEGER")){
                                System.out.print("\nTesting method Inorder Traversal (Option 7)\nInorder: ");
                                intBST.inorder();
                                System.out.println();
                            }

                            else{
                                System.out.print("\nTesting method Inorder Traversal (Option 7)\nInorder: ");
                                stringBST.inorder();
                                System.out.println();
                            }
                            break;

                        /* Print postorder */
                        case 9:
                            if(treeType.equals("INTEGER")){
                                System.out.print("\nTesting method Postorder Traversal (Option 7)\nPostorder: ");
                                intBST.postorder();
                                System.out.println();
                            }

                            else{
                                System.out.print("\nTesting method Postorder Traversal (Option 7)\nPostorder: ");
                                stringBST.postorder();
                                System.out.println();
                            }
                            break;

                        /* Exit */
                        default:
                            System.out.println("Exiting...");
                            runMenu = false;
                    }
                }
            // user inputs non-integer menu option
            }catch(NumberFormatException e){
                System.out.println("Invalid menu option. Please choose options 0 - 10.");
            }
        }
    }
}
