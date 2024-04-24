
import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class ColdestHour {
    public static void main(String[] args) {
        testAverageTemperature("weather-2013-07-22.csv");
    }

    public static CSVRecord coldestHour(CSVParser parser) {
        CSVRecord lowest = null;
        for (CSVRecord currRecord : parser) {
            lowest = isLowest(currRecord, lowest);
        }
        return lowest;
    }

    public static CSVRecord isLowest(CSVRecord currRecord, CSVRecord lowest) {
        if (lowest == null) {
            lowest = currRecord;
        } else {
            double current = Double.parseDouble(currRecord.get("TemperatureF"));
            double lowestTemp = Double.parseDouble(lowest.get("TemperatureF"));
            if (current < lowestTemp && current != -9999) {
                lowest = currRecord;
            }
        }
        return lowest;
    }

    public static CSVRecord coldestHourInFiles() {
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord csvRecord : parser) {
                lowest = isLowest(csvRecord, lowest);
            }
        }
        return lowest;
    }

    public static CSVRecord isLowestHumidity(CSVRecord currRecord, CSVRecord lowest) {
        if (lowest == null) {
            lowest = currRecord;
        } else {
            if (!currRecord.get("Humidity").equals(
                    "N/A")) {
                double current = Double.parseDouble(currRecord.get("Humidity"));
                double lowestTemp = Double.parseDouble(lowest.get("Humidity"));
                if (current < lowestTemp) {
                    lowest = currRecord;
                }
            }

        }
        return lowest;
    }

    public static CSVRecord lowestHumdity(CSVParser parser) {
        CSVRecord lowestHumidity = null;
        for (CSVRecord csvRecord : parser) {
            lowestHumidity = isLowestHumidity(csvRecord, lowestHumidity);
        }
        return lowestHumidity;
    }

    public static CSVRecord lowestHumidityFiles() {
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            for (CSVRecord currRecord : parser) {
                lowest = isLowestHumidity(currRecord, lowest);
            }
        }
        return lowest;
    }

    public static double averageTemperature(CSVParser parser) {
        double totalTemp = 0;
        int count = 0;
        for (CSVRecord csvRecord : parser) {
            ++count;
            totalTemp += Double.parseDouble(csvRecord.get("TemperatureF"));
        }
        System.out.println(count + " is size");

        return totalTemp / count;
    }

    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, double graterValue) {
        double totalTemp = 0;
        double count = 0;
        for (CSVRecord csvRecord : parser) {
            ++count;
            double currentSize = Double.parseDouble(csvRecord.get("Humidity"));
            if (currentSize >= graterValue) {
                totalTemp += Double.parseDouble(csvRecord.get("TemperatureF"));
            }
        }
        return totalTemp / count;
    }

    public static void testIsLowest(String location) {
        FileResource fr = new FileResource(
                "/home/blockchain_oracle/Desktop/Coding Stuffs/JAVA-Coursera/TemperatureLargest/nc_weather/2014/"
                        + location);
        CSVRecord record = coldestHour(fr.getCSVParser());
        System.out.println("lowest temperature was " + record.get("TemperatureF") +
                " at " + record.get("DateUTC"));
    }

    public static void testIsLowestFiles() {
        CSVRecord record = coldestHourInFiles();
        System.out.println("lowest temperature was " + record.get("TemperatureF") +
                " at " + record.get("DateUTC"));
    }

    public static void testAverageTemperatureWithHighHumidityInFile(double humdity, String location) {
        FileResource fr = new FileResource(
                "/home/blockchain_oracle/Desktop/Coding Stuffs/JAVA-Coursera/TemperatureLargest/nc_weather/2013/"
                        + location);
        double average = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), humdity);
        System.out.println("Average temperature with humdity " + humdity + " grater is " + average);
        System.out.println("Temperature in fahriht is " + (((9 / 5.0) * average) + 32));

    }

    public static void testAverageTemperature(String location) {
        FileResource fr = new FileResource(
                "/home/blockchain_oracle/Desktop/Coding Stuffs/JAVA-Coursera/TemperatureLargest/nc_weather/2013/"
                        + location);
        double temperature = averageTemperature(fr.getCSVParser());
        System.out.println("average temperature is " + temperature);
        System.out.println("Temperature in fahriht is " + (((9 / 5.0) * temperature) + 32));

    }

    public static void testLowestHumdity(String location) {
        FileResource fr = new FileResource(
                "/home/blockchain_oracle/Desktop/Coding Stuffs/JAVA-Coursera/TemperatureLargest/nc_weather/2014/"
                        + location);
        CSVRecord record = lowestHumdity(fr.getCSVParser());
        System.out.println("lowest humdity was " + record.get("Humidity") +
                " at " + record.get("DateUTC") + "lowest temperature " + record.get("TemperatureF"));
    }

    public static void testLowestHumdityFiles() {
        // FileResource fr = new FileResource();
        CSVRecord record = lowestHumidityFiles();
        System.out.println("lowest humdity was " + record.get("Humidity") +
                " at " + record.get("DateUTC") + "lowest temperature " + record.get("TemperatureF"));
    }

}
