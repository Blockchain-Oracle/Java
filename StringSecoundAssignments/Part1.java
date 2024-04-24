package StringSecoundAssignments;

import java.util.Scanner;

import StringsThirdAssignments.Part3;
import edu.duke.FileResource;
import edu.duke.StorageResource;
import edu.duke.URLResource;

public class Part1 {

    public static void main(String[] args) {
        System.out.println("Enter url");
        // URLResource url = new URLResource(new Scanner(System.in).nextLine());
        FileResource fr = new FileResource("StringsThirdAssignments/brca1line.fa");
        // testAllGene(url);
        testAllGene(fr);
        // // printALlGenes(fr.asString());
    }

    public static void printALlGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }

    public static String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minmumIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minmumIndex = tgaIndex;
        } else {
            minmumIndex = taaIndex;
        }
        if (minmumIndex == -1 || (tagIndex != -1 && tagIndex < minmumIndex)) {
            minmumIndex = tagIndex;
        }
        if (minmumIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minmumIndex + 3);
    }

    private static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 3);
            }
        }
        return -1;
    }

    public static StorageResource getAllgene(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;

        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            geneList.add(currGene);
            startIndex = (dna.indexOf(currGene, startIndex)) + currGene.length();

        }
        return geneList;
    }

    public static void testAllGene(FileResource fr) {
        String dna = fr.asString();
        // int count = 0;
        // int count1 = 0;
        // int count2 = 0;
        // int count3 = 0;
        // int highest = 0;

        // for (String dna : sr.lines()) {
        StorageResource sr = getAllgene(dna);
        // System.out.println(gene.size());
        // System.out.print("TESTING ALL GENE ");
        // for (String g : gene.data()) {
        // System.out.println(count);

        // count++;
        // if (Part3.isLongerThan9(g)) {
        // System.out.println(count1 + " this id for grater than 60");

        // count1++;
        // }
        // if (Part3.isCgRatioHigh(g)) {
        // System.out.println(count2 + " this id for ratio");

        // count2++;
        // }
        // System.out.println(g.length() + "is length");

        // if (g.length() > highest) {
        // System.out.println(g.length() + "is length");
        // highest = g.length();
        // System.out.println(highest + "
        // highest..........................................");

        // }
        // if (Part3.isCTG(g)) {
        // count3++;
        // }

        // System.out.println(g);
        // // }
        // }
        int countGrNine, countRatios, countLongest, countRaw, ctg;
        countGrNine = 0;
        countLongest = 0;
        countGrNine = 0;
        countRaw = 0;
        countRatios = 0;
        ctg = 0;
        for (String currentGene : sr.data()) {
            System.out.println(currentGene);
            System.out.println("....................................................☑️📿");
            if (currentGene.length() > 60) {
                countGrNine = countGrNine + 1;
            }
            if (Part3.isCgRatioHigh(currentGene)) {
                countRatios = countRatios + 1;
            }
            if (currentGene.length() > countLongest) {
                countLongest = currentGene.length();
            }
            if (Part3.isCTG(currentGene)) {
                ctg += 1;
            }
            countRaw = countRaw + 1;
        }
        System.out.println("There are " + countRaw + " genes total");
        System.out.println("There are " + countGrNine + " genes that are longer than 60 characters");
        System.out.println("There are " + countRatios + " genes with a C-G ratio higher than 0.35");
        System.out.println("The longest gene is " + countLongest + " characters");
        System.out.println("There are " + ctg + "  CTG appear in this strand of DNA");
        System.out.println(".................................................................................🇳🇬");

        // System.out.println(count);
        // System.out.println(count3 + "ctg");

        // System.out.println(count1 + " this id for grater than 60");

        // System.out.println(count2 + " this id for ratio");
        // System.out.println(highest + " highest");

    }

    public static void testAllGene(URLResource url) {

        String dna = url.asString();
        StorageResource sr = getAllgene(dna);
        int countGrNine, countRatios, countLongest, countRaw, ctg;
        countGrNine = 0;
        countLongest = 0;
        countGrNine = 0;
        countRaw = 0;
        ctg = 0;
        countRatios = 0;
        for (String currentGene : sr.data()) {
            if (currentGene.length() > 60) {
                countGrNine = countGrNine + 1;
            }
            if (Part3.isCgRatioHigh(currentGene)) {
                countRatios = countRatios + 1;
            }
            if (currentGene.length() > countLongest) {
                countLongest = currentGene.length();
            }
            if (Part3.isCTG(currentGene)) {
                ctg += 1;
            }
            countRaw = countRaw + 1;
        }
        System.out.println("There are " + countRaw + " genes total");
        System.out.println("There are " + countGrNine + " genes that are longer than 60 characters");
        System.out.println("There are " + countRatios + " genes with a C-G ratio higher than 0.35");
        System.out.println("The longest gene is " + countLongest + " characters");
        System.out.println("There are " + ctg + "  CTG appear in this strand of DNA");
        System.out.println(".................................................................................🇳🇬");

    }

    // when url is given
    public static String converUrltoString(URLResource url) {
        return url.asString();
    }
}