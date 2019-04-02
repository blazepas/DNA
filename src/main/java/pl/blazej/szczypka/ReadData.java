package pl.blazej.szczypka;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.blazej.szczypka.PaireCompare.result;
import static pl.blazej.szczypka.Engine.convertDNAstringsToChar;

public class ReadData {

    public static void initialiseApp() {
        String stringChain = "";
        String StringChainTwo = "";
        List<String> loadedData = readDocument();
        System.out.println("======== Read file with DNA chains ========" + "\n");
        for (String readChains : loadedData) {
            System.out.println(readChains);
        }
        System.out.println("======== End of File ========" + "\n");
        int num = 0;
        int i = 0;
        while (i < loadedData.size()) {
            if (num % 2 == 0 && i < loadedData.size()) {
                stringChain = loadedData.get(i);
                num++;
                i++;
            }
            if (num % 2 != 0 && i < loadedData.size()) {
                StringChainTwo = loadedData.get(i);
                num++;
                i++;

                if (!stringChain.equals(StringChainTwo)) {
                    //start procedure to check both DNA chains
                    convertDNAstringsToChar(stringChain, StringChainTwo);
                } else {
                    System.out.println(stringChain + " == " + StringChainTwo);
                    result = true;
                    System.out.println(result + " - Result: Both chains are exactly the same" + "\n");

                }
            }
        }
    }

    //Read DNA data from file
    public static List readDocument() {
        List<String> readFile = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("dna_chain_pairs_to_compare_data.txt"));
            String line = null;

            while (scanner.hasNext()) {
                line = scanner.nextLine();
                readFile.add(line);
            }
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return readFile;
    }
}
