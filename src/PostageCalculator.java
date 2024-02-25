public class PostageCalculator {
    public double calculatePostage(String zipcode1, String zipcode2, double weight, double length, double width, double height) {
        double cost = 3.75;
        cost += Math.floor(weight/0.1) * 0.05;
        int code1 = Integer.parseInt(zipcode1.substring(0, 3));
        int code2 = Integer.parseInt(zipcode2.substring(0, 3));
        cost += Math.abs(code1 - code2) / 100.0;

        double totalInches = length + width + height;
        if (totalInches > 36) {
            cost += Math.floor(totalInches - 36) * 0.10;
        }
        if (weight > 40) {
            cost += Math.floor(Math.floor(weight - 40)/0.1) * 0.10;
        }
        return cost;
    }

    public double calculatePostage(Address address1, Address address2, double weight, double length, double width, double height) {
        double cost = 3.75;
        cost += Math.floor(weight/0.1) * 0.05;
        int code1 = Integer.parseInt(address1.getZipCode().substring(0, 3));
        int code2 = Integer.parseInt(address2.getZipCode().substring(0, 3));
        cost += Math.abs(code1 - code2) / 100.0;

        double totalInches = length + width + height;
        if (totalInches > 36) {
            cost += Math.floor(totalInches - 36) * 0.10;
        }
        if (weight > 40) {
            cost += Math.floor(Math.floor(weight - 40)/0.1) * 0.10;
        }
        return cost;
    }

    public double calculatePostage(Package pack) {
        double cost = 3.75;
        cost += Math.floor(pack.getWeight()/0.1) * 0.05;
        int code1 = Integer.parseInt(pack.getDestinationAddress().getZipCode().substring(0, 3));
        int code2 = Integer.parseInt(pack.getOriginAddress().getZipCode().substring(0, 3));
        cost += Math.abs(code1 - code2) / 100.0;

        double totalInches = pack.getLength() + pack.getWidth() + pack.getHeight();
        if (totalInches > 36) {
            cost += Math.floor(totalInches - 36) * 0.10;
        }
        if (pack.getWeight() > 40) {
            cost += Math.floor(Math.floor(pack.getWeight() - 40)/0.1) * 0.10;
        }
        return cost;
    }
}
