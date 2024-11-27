public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("silent", "listen"));
        System.out.println(preProcess("What? No way!!!"));
        System.out.println(randomAnagram("silent"));
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1);
        str2 = preProcess(str2);
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (countOccurrences(str1, str1.charAt(i)) != countOccurrences(str2, str1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String preProcess(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                result += Character.toLowerCase(c);
            } else if (c == ' ') {
                result += c;
            }
        }
        return result;
    }

    public static String randomAnagram(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = (int) (Math.random() * chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
        return new String(chars);
    }

    public static int countOccurrences(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) count++;
        }
        return count;
    }
}
