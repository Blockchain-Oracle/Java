package StringFirstAssignment;

import edu.duke.URLResource;

public class Part4 {
    public static class YouTubeUrlParser {

        private URLResource ur;

        public YouTubeUrlParser(String s) {
            setUrl(s);
        }

        public void setUrl(String s) {
            ur = new URLResource(s);
        }

        public String getUrl() {
            return ur.asString();
        }

        public void containYoutube() {
            int count = 0;
            for (String line : ur.lines()) {
                if (line.contains("youtube.com")) {
                    int startIndex = line.indexOf("youtube.com"); // Index of the start of "youtube.com"
                    int endIndex = line.indexOf("\"", startIndex); // Index of the next double quote after "youtube.com"
                    if (startIndex != -1 && endIndex != -1) {
                        count++;
                        String url = line.substring(startIndex, endIndex); // Extract the URL
                        System.out.println("YouTube URL found: " + url);
                    }
                }
            }
            if (count == 0) {
                System.out.println("YouTube URL found: " + "no url found");

            }

        }
    }

}
