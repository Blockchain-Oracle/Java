package CsvParser;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class MainCSV {

    public static void listOfExports(CSVParser parser, String listOfItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(listOfItem)) {
                System.out.println(++count);
                String country = record.get("Country");
                System.out.println(country + " has listItem " + listOfItem);
                System.out.println("..............................................👼");
            }
        }
    }

    public static void whoExportsCoffe() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listOfExports(parser, "coffee");
    }

    public static String countryInfo(CSVParser parser, String _country) {
        // String country =
        for (CSVRecord csvRecord : parser) {
            String countrys = csvRecord.get("Country");
            if (countrys.contains(_country)) {
                return countrys + " :" + csvRecord.get("Exports");
            }
        }
        return "not found";

    }

    public static void listExportersTwoProducts(CSVParser parser, String export1, String export2) {
        int count = 0;

        for (CSVRecord csvRecord : parser) {
            String export = csvRecord.get("Exports");
            if (export.contains(export1) && export.contains(export2)) {
                String country = csvRecord.get("Country");
                System.out.println(country + " has both" + export1 + export2);
                count += 1;
                System.out.println(count);
                System.out.println("..............................................👼");

            } else {
                System.out.println("not found");
                System.out.println("..............................................👼");

            }
        }
    }

    public static CSVParser tester() {
        FileResource fr = new FileResource("CsvParser/exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        return parser;
    }

    public static void testAll(String inputs, String inputs2) {
        CSVParser parser = tester();
        // listOfExports(parser, inputs);
        // listExportersTwoProducts(parser, inputs, inputs2);
        // System.out.println(countryInfo(parser, inputs));
        gratest(parser, 17);
    }

    public static void gratest(CSVParser parser, int amount) {
        int count = 0;
        for (CSVRecord csvRecord : parser) {
            if (csvRecord.get("Value (dollars)").length() > amount) {
                System.out.print(++count + " ");
                System.out.println(csvRecord.get("Country"));
            }
        }
    }

    public static void main(String[] args) {
        testAll("cocoa", "flowers");
    }
}