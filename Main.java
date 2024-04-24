public class Main {

    public static void main(String[] args) {
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }

    public static void findAbc(String input) {
        int index = input.indexOf("abc");
        System.out.println(input.indexOf("abc", index + 4));
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            System.out.println(index);
            System.out.println("index " + index);
            // code
            String found = input.substring(index + 1, index + 4);
            System.out.println(found);
            index = input.indexOf("abc", index + 3);
            System.out.println("index after updating " + index);

        }
    }

    public static void test() {
        // findAbc("abcd");
        findAbc("abcdabc");
    }
    // public static void test() {
    // // no code yet
    // }
}

// public class Main {
// public static void main(String[] args) {
// System.out.println("Neso Alacedemy");
// }
// }