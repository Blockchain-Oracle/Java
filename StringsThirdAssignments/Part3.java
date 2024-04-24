package StringsThirdAssignments;

import java.security.PublicKey;

import edu.duke.StorageResource;

public class Part3 {
    public void processGenes(StorageResource sr) {
        for (String gene : sr.data()) {
            System.out.println("String above 60 characters " + isLongerThan9(gene));
            System.out.println("String with cga ratio aabove 0.35 " + isCgRatioHigh(gene));
            System.out.println("CurrentLongest STR " + isLongest(gene));
        }
    }

    public static boolean isLongerThan9(String dna) {
        if (dna.length() > 60) {
            return true;
        }
        return false;
    }

    // is cg ratio higher than 0.35;

    public static boolean isCgRatioHigh(String dna) {
        float cgRatio = Part1.tgRatio(dna);
        if (cgRatio > 0.35) {
            return true;
        } else
            return false;
    }

    public static boolean isCTG(String dna) {
        if (dna.indexOf("CTG") != -1) {
            return true;
        }
        return false;
    }

    // print longest length;
    public static String isLongest(String dna) {
        int longest = 0;
        if (dna.length() > 0) {
            longest = dna.length();
            return dna;
        }
        return "";
    }
}
