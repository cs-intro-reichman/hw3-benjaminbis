public class Anagram {

    public static String preProcess(String str) {
        return str.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1).replace(" ", "");
        str2 = preProcess(str2).replace(" ", "");

        if (str1.length() != str2.length()) return false;

        while (!str1.isEmpty()) {
            char c = str1.charAt(0);
            int index = str2.indexOf(c);
            if (index == -1) return false;
            str1 = str1.substring(1);
            str2 = str2.substring(0, index) + str2.substring(index + 1);
        }
        return true;
    }

    public static String randomAnagram(String str) {
        str = preProcess(str);
        StringBuilder result = new StringBuilder(str);

        for (int i = result.length() - 1; i > 0; i--) {
            int j = customRandom(0, i + 1);
            char temp = result.charAt(i);
            result.setCharAt(i, result.charAt(j));
            result.setCharAt(j, temp);
        }
        return result.toString();
    }

    private static int customRandom(int min, int max) {
        long currentTime = System.nanoTime();
        return (int) ((currentTime % (max - min)) + min);
    }

    public static void main(String[] args) {
        System.out.println(preProcess("Nag a Ram!"));
        System.out.println(preProcess("Hello   World!"));
        System.out.println(preProcess("ABCdef"));
        System.out.println(preProcess(""));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("hello", "world"));
        System.out.println(isAnagram("Nag a Ram", "anagram"));

        System.out.println(randomAnagram("java"));
        System.out.println(randomAnagram("hello world"));
    }
}
