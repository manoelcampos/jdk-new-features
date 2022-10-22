package samples.jdk16;

public class Jdk16 {
    public static void main(String[] args) {
        var country = new CountryRecord("Portugal", "Europe");
        //Prints using the default toString() method.
        System.out.println(country);

        //Prints by calling each getter method provided automatically.
        System.out.printf("%s is in %s%n", country.name(), country.continent());
    }
}
