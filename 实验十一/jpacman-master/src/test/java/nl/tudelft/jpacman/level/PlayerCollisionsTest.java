package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PlayerCollisionsTest {
	
	private Player player;
	private Ghost ghost;
	private Pellet pellet;
	private PlayerCollisions playerCollisions;
	
	@BeforeEach
	public void setup() {
		// TODO Auto-generated method stub
		player = new PlayerFactory(new PacManSprites()).createPacMan();
		ghost = new GhostFactory(new PacManSprites()).createClyde();
		pellet = new Pellet(1, (Sprite) new PacManSprites());
		playerCollisions = new PlayerCollisions(mock(PointCalculator.class));
	}
	
	@Test
	void playerCollidedOnGhost() {
		playerCollisions.collide(player,ghost);
		assertThat(player.isAlive()).isEqualTo(false);
		assertThat(player.getKiller()).isEqualTo(ghost);
	}
	@Test
	void playerCollidedOnPellet() {
		playerCollisions.collide(player,pellet);
		assertThat(pellet.getSquare()).isEqualTo(null);
	}
	@Test
	void ghostCollidedOnPlayer() {
		playerCollisions.collide(ghost,player);
		assertThat(player.isAlive()).isEqualTo(false);
		assertThat(player.getKiller()).isEqualTo(ghost);
	}
	@Test
	void pelletCollidedOnPlayer() {
		playerCollisions.collide(pellet,player);
		assertThat(pellet.getSquare()).isEqualTo(null);
	}
}
