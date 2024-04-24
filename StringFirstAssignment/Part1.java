package StringFirstAssignment;

public class Part1 {

    static String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA");
        if (stopIndex == -1) {
            return "";
        }
        String gene = dna.substring(startIndex, stopIndex + 3);
        if (gene.length() % 3 == 0) {
            return gene;

        }
        return "";
    }

    static void testSimpleDna() {
        String dna;
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        String dnaPattern = findSimpleGene(dna);
        System.out.println(dnaPattern);
    }

    public static void main(String[] args) {
        testSimpleDna();
    }
}