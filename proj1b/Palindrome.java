public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            L.addLast(word.charAt(i));
        }
        return L;
    }

    private boolean isPalindromehelper1(Deque<Character> wordInDeck) {
        if (wordInDeck.isEmpty() || wordInDeck.size() == 1) {
            return true;
        }
        Character first = wordInDeck.removeFirst();
        Character last = wordInDeck.removeLast();
        if (first != last) {
            return false;
        }
        return isPalindromehelper1(wordInDeck);
    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordInDeck = wordToDeque((word));
        return isPalindromehelper1(wordInDeck);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        }

        for (int i = 0; i < word.length() / 2; i += 1) {
            int endIndex = word.length() - 1 - i;
            if (!cc.equalChars(word.charAt(i), word.charAt(endIndex))) {
                return false;
            }
        }
        return true;
    }

}
