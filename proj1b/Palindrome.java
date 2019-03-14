public class Palindrome {

    LinkedListDeque<Character> deqWord = new LinkedListDeque<>();

    public Deque<Character> wordToDeque(String word) {

        for(int i = 0; i < word.length(); i++) {

            deqWord.addLast(word.charAt(i));
        }
        return deqWord;
    }


    public boolean isPalindrome(String word) {

        String tstString1 = "";
        String tstString2 = "";


        if (word.length() == 0 || word.length() == 1) {

            return true;

        }

        else if (word.length() > 1) {

            for(int i = 0; i < (word.length()); i++) {

                tstString1 += word.charAt(i);
            }

            for(int j = word.length() - 1; j >= 0; j--) {

                tstString2 += word.charAt(j);
            }

            if (tstString1.equals(tstString2)) {

                return true;
            }


        }
        return  false;
    }

    public static void main(String[] args) {


        Palindrome pal = new Palindrome();

        pal.isPalindrome("aba");
    }


}