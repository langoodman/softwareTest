package text7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	@DisplayName("分数相同且都超过21点")
	void testWithSamepointGreater21() {
		Game g = new Game();
		int point = g.play(30, 30);
		assertEquals(0, point);
	}
	
	@Test
	@DisplayName("左边选手获胜")
	void testleftplayerwin() {
		Game g = new Game();
		int point = g.play(10, 9);
		assertEquals(10, point);
	}
	
	@Test
	@DisplayName("分数相同且都超过21点")
	void testShortWithSamepointGreater21() {
		Game g = new Game();
		int point = g.playWithoutBraces(30, 30);
		assertEquals(0, point);
	}
	
	@Test
	@DisplayName("左边选手获胜")
	void testShortleftplayerwin() {
		Game g = new Game();
		int point = g.playWithoutBraces(10, 9);
		assertEquals(10, point);
	}
	

}
