package StringFirstAssignment;

public class Part2 {
    String findSimpleGene(String dna, int startCodon, int stopCodon) {
        // int startIndex = dna.indexOf("ATG");
        if (startCodon == -1) {
            return "";
        }
        // int stopIndex = dna.indexOf("TAA");
        if (stopCodon == -1) {
            return "";
        }
        String gene = dna.substring(startCodon, stopCodon + 3);
        if (gene.length() % 3 == 0) {

            return gene.toUpperCase();

        }

        return "";
    }

}
