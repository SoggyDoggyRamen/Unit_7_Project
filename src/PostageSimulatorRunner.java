import java.util.Scanner;

public class PostageSimulatorRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PackageSimulator simulator = new PackageSimulator();
        int input = 0;

        while (input != 4) {
            PostageCalculator calculator = new PostageCalculator();
            //Display menu & get user input
            System.out.println("___________________________________________________");
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate cost of one package");
            System.out.println("2. Simulate packages");
            System.out.println("3. How package costs are calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            input = Integer.parseInt(scanner.nextLine());

            //Checking user input
            if (!(input == 4)) {
                if (input == 1) {
                    //Getting user input
                    System.out.print("Enter the zip code of origin package: ");
                    String originZip = scanner.nextLine();
                    System.out.print("Enter the zip code of destination package: ");
                    String destinZip = scanner.nextLine();
                    System.out.print("Enter the weight of the package: ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the height of the package: ");
                    double height = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the length of the package: ");
                    double length = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the width of the package: ");
                    double width = Double.parseDouble(scanner.nextLine());

                    //Print result
                    System.out.println("Cost: $" + calculator.calculatePostage(originZip, destinZip, weight, length, width, height));
                }

                else if (input == 2) {
                    //Getting user input
                    System.out.print("How many packages would you like to simulate?: ");
                    simulator.generatePackages(Integer.parseInt(scanner.nextLine()));
                    simulator.getSimulationInfo();
                }

                else if (input == 3) {
                    System.out.println("___________________________________________________");
                    System.out.println("** The formula to determine the cost of shipping **\n" +
                            "The base cost is $3.75\n" +
                            "Add 5 cents for each tenth of a pound\n" +
                            "Divide the difference in county codes by 100 and add that to calculate the final total");
                    System.out.println();
                    System.out.println("** Accounting for oversize packages **\n" +
                            "Any package that exceeds a combined 36 inches will cost an additional 10 cents per inch\n" +
                            "Additionally, packages that are more than 40 pounds will be charged 10 cents per tenth of a pound over the 40 pound limit");
                }

                //Invalid cmd check
                else {
                    System.out.println("Invalid command.");
                }
            }
        }

        //end
        System.out.println("___________________________________________________");
        System.out.println();
        System.out.println("BYEBYE!");
    }
}