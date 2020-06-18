package text7;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WordCountTest extends WordCounter {
	@Test
	@DisplayName("多个匹配单词")
	void testTwoMatchingWords() {
		int words = new WordCounter().count("cats|director|monkeys");
		assertEquals(3, words);
	}
	
	@Test
	@DisplayName("一个匹配单词")
	void testOneMatchingWord() {
		int words = new WordCounter().count("fishes");
		assertEquals(1, words);		
	}
	
	@Test
	@DisplayName("不是末尾匹配一个单词")
	void testOneMatchingWordNotEnd() {
		int words = new WordCounter().count("hot!dog");
		assertEquals(0, words);
	}
	
	@Test
	@DisplayName("末尾匹配一个单词")
	void testOneMatchingWordEnd() {
		int words = new WordCounter().count("cat!doctor");
		assertEquals(1, words);
	}
}
