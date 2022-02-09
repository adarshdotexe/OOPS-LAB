public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("adarshvarshney", "varshneyadarsh"));
        System.out.println(isAnagram("night", "thing"));
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < b.length(); i++) {
            a = a.replaceFirst(String.valueOf(b.charAt(i)), "");
        }
        return a.isEmpty() ? true : false;
    }

}