public class Palindrome {
	public Deque<Character> wordToDeque(String word){
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < word.length(); i++) {
			deque.addLast(word.charAt(i));
		}
		return deque;
	}

	public boolean isPalindrome(String word) {
		Deque<Character> deque = wordToDeque(word);
		return isPalindrome(deque);
	}

	private boolean isPalindrome(Deque<Character> deque) {
		if (deque.size() <= 1) {
			return true;
		}

		if (deque.removeFirst() != deque.removeLast()) {
			return false;
		}

		return isPalindrome(deque);
	}

	public boolean isPalindrome(String word, CharacterComparator cc) {
		Deque<Character> deque = wordToDeque(word);
		while(deque.size() > 1) {
			if(!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
				return false;
			}
		}
		
		return true;
	}
}
