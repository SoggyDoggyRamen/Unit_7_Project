import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageSimulator {
    Package[] packages;
    private Scanner scanner;
    String[] zipCodes;

    public PackageSimulator() {
        File f = new File("data/zipCodes");
        try {
            scanner = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
            System.exit(1);
        }

        String fileData = "";
        while (scanner.hasNextLine()) {
            fileData += scanner.nextLine() + "\n";
        }
        zipCodes = fileData.split("\n");
    }


    public void generatePackages(int amt) {
        packages = new Package[amt];
        int idx = 0;
        for (int i = 0; i < amt; i ++) {

            //Generate Address
            int randNum1 = (int) (Math.random() * zipCodes.length);
            int randNum2 = (int) (Math.random() * zipCodes.length);

            String zipCode1 = zipCodes[randNum1];
            String zipCode2 = zipCodes[randNum2];

            Address originAddress = new Address("123", "Random Street", "3C", "City", "State", zipCode1);
            Address destinationAddress = new Address("123", "Random Street", "3C", "City", "State", zipCode2);


            //Generate w, width, height and weight
            double length = Math.random() * 9 + 12;
            double height = Math.random() * 6 + 12;
            double width = Math.random() * 6 + 6;
            double weight = Math.random() * 50 + 2;

            //Add Package
            Package pack = new Package(originAddress, destinationAddress, weight, length, height, width);
            packages[idx] = pack;
            idx ++;
        }
    }

    public double generateTotalCost() {
        double totalCost = 0;
        PostageCalculator calculator = new PostageCalculator();
        for (Package pack: packages) {
            totalCost += calculator.calculatePostage(pack);
        }
        return Math.round(totalCost * 100.0)/100.0;
    }

    public void getSimulationInfo() {
        PostageCalculator calculator = new PostageCalculator();

        System.out.println("Randomly Generated Packages Info: ");
        for (int i = 0; i < packages.length; i ++) {
            System.out.println("Package " + (i + 1) + ": ___________________________________________________");
            System.out.println("Origin Address: " + packages[i].getOriginAddress());
            System.out.println("Destination Address: " + packages[i].getDestinationAddress());
            System.out.println("Weight: " + packages[i].getWeight());
            System.out.println("Height: " + packages[i].getHeight());
            System.out.println("Length: " + packages[i].getLength());
            System.out.println("Width: " + packages[i].getWidth());
            System.out.println("Cost: $" + calculator.calculatePostage(packages[i]));
        }
        System.out.println("___________________________________________________");
        System.out.println("Total Cost of all packages: $" + generateTotalCost());
    }

    public void resetSimulation() {
        packages = new Package[0];
    }
}
