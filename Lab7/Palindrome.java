public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("amor roma"));
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
    }

    public static Boolean isPalindrome(String text) {
        StringBuilder builder = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        text = builder.toString();
        int len = text.length();
        for (int i = 0; i < len / 2; ++i) {
            if (text.charAt(i) != text.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}