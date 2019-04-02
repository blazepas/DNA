package pl.blazej.szczypka;

import java.util.*;
import static pl.blazej.szczypka.PaireCompare.compareDNAPairs;

public class Engine {
    public static void convertDNAstringsToChar(String chainOne, String chainTwo) {

        List<Character> allKeysFirstChain = new LinkedList<>();
        List<Character> allKeysSecondChain = new LinkedList<>();
        List bothDNAChains = new LinkedList();

        Set<Character> uniqueSet = new HashSet<Character>();


//        if (!chainOne.equals(chainTwo)) {
        char[] chars = chainOne.toCharArray();
        char[] charsTwo = chainTwo.toCharArray();

        for (Character z : chars) {
            uniqueSet.add(z);
            allKeysFirstChain.add(z);
        }
        for (Character z : charsTwo) {
            uniqueSet.add(z);
            allKeysSecondChain.add(z);
        }
        bothDNAChains.add(allKeysFirstChain);
        bothDNAChains.add(allKeysSecondChain);

//                List<Character> union = ListUtils.union(allKeysFirstChain, allKeysSecondChain);
        List uniqueKeys = new LinkedList(uniqueSet);

        countCharacters(bothDNAChains, uniqueKeys);

    }

    public static void countCharacters(List bothDNAChains, List uniqueKeys) {
        int switcher = 1;
        Map firstChainCounted = new HashMap();
        Map secondChainCounted = new HashMap();

        //two DNA chains to compare
        for (int a = 0; a < bothDNAChains.size(); a++) {
            List allKeys = (List) bothDNAChains.get(a);
            System.out.println(allKeys + "   <-   compare both DNA chains");
            //pattern to compare - set with unique characters
            for (int i = 0; i < uniqueKeys.size(); i++) {
                int counter = 0;
                //one by one DNA chsracters are checked with pattern
                for (int j = 0; j < allKeys.size(); j++) {
                    if (uniqueKeys.get(i) == allKeys.get(j)) {
                        counter++;
                    }
                    //save character occurance from first chain
                    if (switcher == 1) {
                        firstChainCounted.put(uniqueKeys.get(i), counter);
                        //save character occurance from second chain
                    } else if (switcher == 0) {
                        secondChainCounted.put(uniqueKeys.get(i), counter);
                    }
                }
            }
            switcher--;
        }

        compareDNAPairs(firstChainCounted, secondChainCounted);
    }

}
