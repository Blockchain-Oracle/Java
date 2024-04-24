package StringFirstAssignment;

public class Part3 {
    public static boolean twoOccurrences(String stringa, String stringb) {
        int count = 0;
        int index = 0;

        while (true) {
            index = stringb.indexOf(stringa, index);
            if (index != -1) {
                count++;
                index += stringa.length();
            } else {
                break;
            }
        }

        return count >= 2;
    }

    public static void testing() {
        String stringA;
        String stringB;
        stringA = "an";
        stringB = "banana";
        System.out.println(twoOccurrences(stringA, stringB));
        stringA = "zoo";
        stringB = "forest";
        System.out.println(twoOccurrences(stringA, stringB));

    }
}
