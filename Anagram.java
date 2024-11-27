public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("silent", "listen"));
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller"));
        System.out.println(isAnagram("Madam Curie", "Radium came"));
        System.out.println(preProcess("What? No way!!!"));
        System.out.println(randomAnagram("silent"));
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = preProcess(str1);
        str2 = preProcess(str2);
        if (str1.length() != str2.length()) return false;

        int[] charCounts = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i) - 'a']++;
            charCounts[str2.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) return false;
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
}
