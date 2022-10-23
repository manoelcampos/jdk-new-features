package samples.jdk09;

import samples.jdk16.Country;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jdk09 {
    /**
     * Shows how to use Collection Factories
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1, 2, 3, 4);
        System.out.println(numberList);

        List<Country> countryList = List.of(
            new Country("Brazil", "South America"),
            new Country("Portugal", "Europe")
        );
        System.out.println(countryList);

        Map<Integer, String> numbersMap = Map.of(1, "One", 2, "Two", 3, "Three");

        Set<Character> charSet = Set.of('a', 'e', 'i', 'o', 'u');
        System.out.println(charSet);
    }
}
