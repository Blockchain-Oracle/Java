package FileResources;

import edu.duke.FileResource;

public class CheckEachLineFile {
    public static void main(String[] args) {
        System.out.println("This program prints all line in the file");
        printLine();
        printIfGraterThan20();
    }

    static void printLine() {
        FileResource file = new FileResource("./hello_unicode.txt");
        for (String line : file.lines()) {
            System.out.print(line);
        }
    }

    /**
     * The below code only prints words in each line grater than 20
     */

    static void printIfGraterThan20() {
        FileResource file = new FileResource("./hello_unicode.txt");
        for (String line : file.lines()) {
            if (line.length() > 20) {
                System.out.println(line);
            }
        }
    }
}