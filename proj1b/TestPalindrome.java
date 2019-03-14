import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        String tstString_1 = "";
        String tstString_2 = "1";
        String tstString_3 = "racecar";
        String tstString_4 = "abba";

        assertEquals(palindrome.isPalindrome(tstString_1), true);
        assertEquals(palindrome.isPalindrome(tstString_2), true);
        assertEquals(palindrome.isPalindrome(tstString_3), true);
        assertEquals(palindrome.isPalindrome(tstString_4), true);

    }
}