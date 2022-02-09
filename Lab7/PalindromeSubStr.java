
public class PalindromeSubStr {
    public static void main(String[] args) {
        String str = "amor roma";
        System.out.println(countSubstrings(str));
    }

    public static int countSubstrings(String s) {
      int N = s.length();
      int ans = 0;
      for (int center = 0; center <= 2 * N - 1; ++center) {
          int left = center / 2;
          int right = left + center % 2;
          while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
              ans++;
              left--;
              right++;
          }
      }
      return ans - N;
    }

  }