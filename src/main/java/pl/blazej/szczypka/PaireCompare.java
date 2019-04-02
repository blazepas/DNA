package pl.blazej.szczypka;

import java.util.Map;

public class PaireCompare {
    static boolean result;
    public static void compareDNAPairs(Map firstChainCounted, Map secondChainCounted) {
        if (firstChainCounted.equals(secondChainCounted)) {
            System.out.println(firstChainCounted + " vs " + secondChainCounted);
            result = true;
            System.out.println(result + " - Result: Yes it is possible to create chain number 2 from chain number 1 because the are both compliance in structure" + "\n");
        } else {
            System.out.println(firstChainCounted + " vs " + secondChainCounted);

            result = false;
            System.out.println(result + " - Result: No it is not possible because both chains are different" + "\n");
        }
    }
}
