package samples.jdk09;

import samples.jdk16.Country;

import java.util.*;

public class Jdk09 {
    /**
     * Shows how to use Collection Factories
     * @param args
     */
    public static void main(String[] args) {
        collectionFactories();
        // traditionalCollectionCreation();
    }

    private static void traditionalCollectionCreation() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        System.out.println(numberList);

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Brazil", "South America"));
        countryList.add(new Country("Portugal", "Europe"));
        System.out.println(countryList);

        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        System.out.println(numberMap);

        Set<Character> charSet = new HashSet<>();
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');
        System.out.println(charSet);
    }

    private static void collectionFactories() {
        List<Integer> numberList = List.of(1, 2, 3, 4);
        System.out.println(numberList);

        List<Country> countryList = List.of(
            new Country("Brazil", "South America"),
            new Country("Portugal", "Europe")
        );
        System.out.println(countryList);

        Map<Integer, String> numberMap = Map.of(1, "One", 2, "Two", 3, "Three");
        System.out.println(numberMap);

        Set<Character> charSet = Set.of('a', 'e', 'i', 'o', 'u');
        System.out.println(charSet);
    }
}
