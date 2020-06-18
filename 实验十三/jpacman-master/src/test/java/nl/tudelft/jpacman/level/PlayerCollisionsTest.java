package nl.tudelft.jpacman.level;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PlayerCollisionsTest {

	private PlayerCollisions playerCollisions;
	private PointCalculator pointCalculator;
	
	@BeforeEach
	public void setup() {
		// TODO Auto-generated method stub
		pointCalculator = mock(PointCalculator.class);
		playerCollisions = new PlayerCollisions(pointCalculator);
	}
	
	@Test
	void playerCollidedOnGhost() {
		
		Player player = mock(Player.class);
		Ghost ghost = mock(Ghost.class);
		
		playerCollisions.collide(player,ghost);
		
		verify(pointCalculator).collidedWithAGhost(player, ghost);
		verify(player).setAlive(false);
		verify(player).setKiller(ghost);
	}
	@Test
	void playerCollidedOnPellet() {
		Player player = mock(Player.class);
		Pellet pellet = mock(Pellet.class);
		
		playerCollisions.collide(player,pellet);
		
		verify(pellet).leaveSquare();
		verify(pointCalculator).consumedAPellet(player, pellet);
	}
	@Test
	void playerCollidedOnPlayer() {
		
		Player player1 = mock(Player.class);
		Player player2 = mock(Player.class);
		
		playerCollisions.collide(player1, player2);
		
		verifyZeroInteractions(player1,player2);
	}
}
