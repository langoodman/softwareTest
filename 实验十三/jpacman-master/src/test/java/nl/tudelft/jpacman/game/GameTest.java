package nl.tudelft.jpacman.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.List;

import org.assertj.core.util.Lists;
import org.checkerframework.checker.units.qual.Temperature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.shadow.com.univocity.parsers.tsv.TsvRoutines;
import org.junit.jupiter.api.TestMethodOrder;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.GhostMapParser;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class GameTest {
	
	private SinglePlayerGame game;
	private Level level;
	
	@BeforeEach
	public void setup() {
		level = mock(Level.class);
	}
	
	@Test
	@DisplayName("有豆子没有玩家存活，游戏结束")
	void testNoPlayerAlive() {
		when(level.isAnyPlayerAlive()).thenReturn(false);
		when(level.remainingPellets()).thenReturn(23);		
		game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
		
		game.start();
		
		assertThat(game.isInProgress()).isFalse();
	}
	
	@Test
	@DisplayName("没有豆子没有玩家存活，游戏结束")
	void testNoPlayerAliveNoPellet() {
		when(level.isAnyPlayerAlive()).thenReturn(false);
		when(level.remainingPellets()).thenReturn(0);		
		game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
		
		game.start();
		
		assertThat(game.isInProgress()).isFalse();
	}
	
	@Test
	@DisplayName("没有豆子但有玩家存活，游戏结束")
	void testPlayerAliveAndNoPellet() {
		when(level.isAnyPlayerAlive()).thenReturn(true);
		when(level.remainingPellets()).thenReturn(0);
		game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
		
		game.start();
		
		assertThat(game.isInProgress()).isFalse();
	}
	
	@Test
	@DisplayName("有豆子有玩家存活，游戏继续")
	void testPlayerAliveAndHasPellet() {
		when(level.isAnyPlayerAlive()).thenReturn(true);
		when(level.remainingPellets()).thenReturn(23);
		game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
		
		game.start();
		
		assertThat(game.isInProgress()).isTrue();
	}
	
	@Test
	@DisplayName("游戏进行中再次调用start，则状态不变")
	void testRestart() {
		when(level.isAnyPlayerAlive()).thenReturn(true);
		when(level.remainingPellets()).thenReturn(23);
		
		game = new SinglePlayerGame(mock(Player.class), level, mock(PointCalculator.class));
		
		game.start();
		assertThat(game.isInProgress()).isTrue();
		
		game.start();
		assertThat(game.isInProgress()).isTrue();
		
		verify(level,times(1)).isAnyPlayerAlive();
		verify(level,times(1)).remainingPellets();
		
	}
	
}












