import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame g;

	@Before
	public void setup() {
		g = new BowlingGame();
	}
	
	@Test
	public void shouldScoreGutterGame() {
		rollMany(20, 0);
		int score = g.score();
		assertThat("should be zero score - all gutterballs!", score, is(0));
		assertEquals("should be zero score - all gutterballs!", 0, score);
	}

	private void rollMany(int numberOfTimes, int pins) {
		for(int i = 0; i < numberOfTimes; i++) {
			g.roll(pins);
		}
	}
	
	@Test
	public void shouldScoreAllOnes() {
		rollMany(20, 1);
		int score = g.score();
		assertThat(score, is(20));
	}
	
	@Test
	public void shouldScoreOneSpare() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		int score = g.score();
		assertThat(score, is(16));
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}
	
	@Test
	public void shouldScoreOneStrike() {
		g.roll(10); // strike!
		g.roll(4);
		g.roll(3);
		int score = g.score();
		assertThat(score, is(24));
	}
}
