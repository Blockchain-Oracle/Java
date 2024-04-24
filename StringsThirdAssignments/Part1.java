package StringsThirdAssignments;

public class Part1 {

    public static float tgRatio(String dna) {
        int numCG = countCG(dna);
        float dnaLength = dna.length();
        return numCG / dnaLength;
    }

    public static int countCG(String dna) {
        int count = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                count++;
            }
        }
        return count;

    }
}