public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("silent", "listen"));  
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); 
        System.out.println(isAnagram("Madam Curie", "Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); 
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
            }
        }
        return result;
    }
}
