package StringFirstAssignment;

import java.util.Scanner;

public class RunPart4 {
    public static void main(String[] args) {
        String url = enterUrl();
        Part4.YouTubeUrlParser youTubeUrlParser = new Part4.YouTubeUrlParser(url);
        // System.out.println("url is " + youTubeUrlParser.getUrl());

        youTubeUrlParser.containYoutube();

    }

    static String enterUrl() {
        System.err.println("Enter url");
        return new Scanner(System.in).nextLine();
    }
}
