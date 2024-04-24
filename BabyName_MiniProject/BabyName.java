package BabyName_MiniProject;

import java.io.File;
import java.time.Year;

import javax.print.attribute.standard.Fidelity;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class BabyName {

    static void totalBirths(FileResource fr) {
        CSVParser parser = fr.getCSVParser(false);
        int totalBirth = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int numberOfBoys = 0;
        int numberOfGirls = 0;
        for (CSVRecord record : parser) {
            totalBirth += Integer.parseInt(record.get(2));
            if (record.get(1).equals("M")) {
                numberOfBoys++;
                totalBoys += Integer.parseInt(record.get(2));
            } else {
                numberOfGirls++;
                totalGirls += Integer.parseInt(record.get(2));
            }
        }
        System.out.println("Total birth = " + totalBirth +
                "\n" + " totalBoysBirth = " + totalBoys +
                "\n" + " totalGirlsBirth = " + totalGirls +
                "\n" + " totalNumber of boys = " + numberOfBoys +
                "\n" + " totalNumber of Girls = " + numberOfGirls);
    }

    static int getRank(int year, String name, String gender) {
        FileResource fr = location(year);
        int countGender = 0;
        boolean isFound = false;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                countGender++;
            }
            if (record.get(0).contains(name) && record.get(1).equals(gender)) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            return countGender;
        } else {
            return -1;
        }

    }

    static String getName(int year, int rank, String gender) {
        FileResource fr = location(year);
        int countGender = 0;
        String name = "";
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                ++countGender;
                if (countGender == rank) {
                    System.out.println(countGender);
                    name = record.get(0);
                }
            }
        }
        if (name.isBlank()) {
            return "name not found";
        } else {
            return name;

        }
    }

    static void whatIsNameInYear(String name, int year, int newYear, String gender) {
        /**
         * get rank of name first using the following parameters
         * name year gender =>> rank
         * 
         */

        int rank = getRank(year, name, gender);
        // using the rank returned get New name

        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year +
                " would be " + newName +
                " born in " + newYear);

    }

    static int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int curRank = Integer.MAX_VALUE;
        int years;
        int highestRankYear = -1;

        for (File file : dr.selectedFiles()) {
            String fileName = file.getName();
            years = getYear(fileName);
            int rank = getRank(years, name, gender);
            if (rank != -1 && rank < curRank) {
                curRank = rank;
                highestRankYear = years;
            }
        }
        return highestRankYear;
    }

    static double getAverageRank(String name, String gender) {
        int totalCount = 0;
        double totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            int year = getYear(file.getName());
            int rank = getRank(year, name, gender);
            if (rank != -1) {
                totalCount++;
                totalRank += rank;
            }
        }
        if (totalRank == 0) {
            return -1.0;
        } else {
            return totalRank / totalCount;

        }
    }

    static int getTotalBirthsRankedHigher(int year, String name, String Gender) {
        FileResource fr = location(year);
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        int rank = getRank(year, name, Gender);
        System.out.println("rank " + rank);
        int totalBirthRankHigher = 0;
        for (CSVRecord csvRecord : parser) {
            if (rank != -1 && csvRecord.get(1).equals(Gender)) {
                ++count;
                // for (int i = 0; i < rank; i++) {
                if (count == rank) {
                    break; // Stop looping once the desired rank is reached
                }
                totalBirthRankHigher += Integer.parseInt(csvRecord.get(2));
                // }

            }
        }
        if (totalBirthRankHigher != 0) {
            return totalBirthRankHigher;
        } else {
            return -1;
        }
    }

    static FileResource location(int year) {
        return new FileResource("BabyName_MiniProject/data/yob" + year + ".csv");
    }

    static int getYear(String fileName) {
        // System.out.println(fileName);
        // System.out.println(fileName.substring(3, 7));
        return Integer.parseInt(fileName.substring(3, 7));
    }

    static void testTotalBirths(int year) {
        totalBirths(location(year));
    }

    static void testRank(int year, String name, String gender) {
        System.out.println("rank is = " + getRank(year, name, gender));
    }

    static void testGetName(int year, int rank, String gender) {
        System.out.println("name is " + getName(year, rank, gender));
    }

    static void testWhatIsNameInYear(String name, int year, int newYear, String gender) {
        whatIsNameInYear(name, year, newYear, gender);
    }

    static void testYearOfHighestRank(String namec, String gender) {
        System.out.println("year of highest rank is " + yearOfHighestRank(namec, gender));
    }

    static void testGetAverageRank(String name, String gender) {
        System.out.println("Average rank = " + getAverageRank(name, gender));
    }

    static void testgetTotalBirthsRankedHigher(int year, String name, String gender) {
        System.out.println("totalBirth ranked higher is " + getTotalBirthsRankedHigher(year, name, gender));
    }

    public static void main(String[] args) {
        // testTotalBirths(1905);
        // testGetName(1980, 350, "F");
        // testWhatIsNameInYear("Owen", 1974, 2014, "M");
        // testGetAverageRank("Robert", "M");
        // testYearOfHighestRank("Mich", "M");
        testgetTotalBirthsRankedHigher(1990, "Drew", "M");
    }

}
