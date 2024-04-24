 

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Csvmax {
    public static void main(String[] args) {
        testHostesDay();
    }

    public static CSVRecord csvMax(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currRecord : parser) {
            largestSoFar = getLargestOfTwo(currRecord, largestSoFar);
        }
        return largestSoFar;
    }

    public static CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord currRecord : parser) {
                largestSoFar = getLargestOfTwo(currRecord, largestSoFar);
            }
        }
        return largestSoFar;
    }

    public static CSVRecord getLargestOfTwo(CSVRecord currRecord, CSVRecord largestSoFar) {
        if (largestSoFar == null) {
            largestSoFar = currRecord;
        } else {
            double curr = Double.parseDouble(currRecord.get("TemperatureF"));
            double largest = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (curr > largest) {
                largestSoFar = currRecord;
            }
        }
        return largestSoFar;
    }

    public static void testHostesDay() {
        // FileResource fr = new
        // FileResource("TemperatureLargest/data/2012/weather-2012-01-01.csv");
        // CSVRecord record = csvMax(fr.getCSVParser());
        // System.out.println("hotest temperature was " + record.get("TemperatureF") +
        // " at " + record.get("TimeEST"));

        // FileResource fr = new
        // FileResource("TemperatureLargest/data/2012/weather-2012-01-01.csv");
        CSVRecord record = hottestInManyDays();
        System.out.println("hotest temperature was " + record.get("TemperatureF") +
                " at " + record.get("DateUTC"));
    }
}
