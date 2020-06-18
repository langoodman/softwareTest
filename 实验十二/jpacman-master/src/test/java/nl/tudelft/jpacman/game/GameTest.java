package nl.tudelft.jpacman.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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
	
	private MapParser mapParser;
	
	@BeforeEach
	public void setup() {
		//Arrange
				PacManSprites sprites = new PacManSprites();
				GhostFactory ghostFactory = new GhostFactory(sprites);
				LevelFactory levelFactory = new LevelFactory(sprites, ghostFactory,mock(PointCalculator.class));
				BoardFactory boardFactory = new BoardFactory(sprites);
		mapParser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);
	}
	
	@Test
	void anyPlayerAliveAndRemainPellets() {
		List<String> map = Lists.newArrayList(
				"#.G.P.#"
				);
		Player player = new PlayerFactory(new PacManSprites()).createPacMan();
		Level level = mapParser.parseMap(map);
		PointCalculator pointCalculator = new DefaultPointCalculator();
		Game game = new SinglePlayerGame(player, level, pointCalculator);
		
		game.start();
		
		assertThat(game.isInProgress()).isEqualTo(true);
	}
	
	@Test
	void anyPlayerAliveNotRemainingPellet() {
		List<String> map = Lists.newArrayList(
				"#GP#"
				);
		Player player = new PlayerFactory(new PacManSprites()).createPacMan();
		Level level = mapParser.parseMap(map);
		PointCalculator pointCalculator = new DefaultPointCalculator();
		Game game = new SinglePlayerGame(player, level, pointCalculator);
		
		game.start();
		
		assertThat(game.isInProgress()).isEqualTo(false);
	}
	
}












