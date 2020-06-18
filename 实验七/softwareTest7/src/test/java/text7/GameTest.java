package text7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	@DisplayName("������ͬ�Ҷ�����21��")
	void testWithSamepointGreater21() {
		Game g = new Game();
		int point = g.play(30, 30);
		assertEquals(0, point);
	}
	
	@Test
	@DisplayName("���ѡ�ֻ�ʤ")
	void testleftplayerwin() {
		Game g = new Game();
		int point = g.play(10, 9);
		assertEquals(10, point);
	}
	
	@Test
	@DisplayName("������ͬ�Ҷ�����21��")
	void testShortWithSamepointGreater21() {
		Game g = new Game();
		int point = g.playWithoutBraces(30, 30);
		assertEquals(0, point);
	}
	
	@Test
	@DisplayName("���ѡ�ֻ�ʤ")
	void testShortleftplayerwin() {
		Game g = new Game();
		int point = g.playWithoutBraces(10, 9);
		assertEquals(10, point);
	}
	

}
