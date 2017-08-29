import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame g;
	
	@Before
	public void setUp(){
		g = new BowlingGame();
	}

	private void rollMany(int numberOfTimes, int pins) { //this is the extracted method rollMany
		for (int i = 0; i < numberOfTimes; i++) { // rolling the ball 20 times method
			g.roll(pins); // write a for loop in the test so you don't have to write it 20 times in the class 
		}
	}
	
	@Test
	public void shouldScoreGutterGame() {
		rollMany(20, 0); //right click extract method and extract local variable 
		// act
		int score = g.score();
		
		//assert
		assertEquals("should be zero score- all gutterballs!", 0, score); //(expected is 0 and actual is score
		assertThat("should be zero score- all gutterballs!", score, CoreMatchers.is(0)); //actual is score and expected is 0
	}

	
	@Test
	public void shouldScoreAllOnes() {
		rollMany(20,1);
		int score = g.score();
		assertEquals("should be one score", 0, score); 
		
}
//	@Test
//	public void shouldScoreOneSpare(){
//		g.roll(5);
//		g.roll(5);
//		g.roll(3);
//		rollMany(17,0);
//		int score = g.score();
//		assertThat(score, CoreMatchers.is(16));
//	}
}

