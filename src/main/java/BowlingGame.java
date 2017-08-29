
public class BowlingGame {


		private int rolls[] = new int[21];
		private int currentRoll = 0;

		public void roll(int pins) {
			// remember, this is the same as..
			// rolls[currentRoll] = pins;
			// currentRoll++;
			rolls[currentRoll++] = pins;
		}

		public int score() {
			int score = 0;
			int index = 0;
			for (int frame = 0; frame < 10; frame++) {
				if (isStrike(index)) {
					score += 10 + strikeBonus(index);
					index++;
				} else if (isSpare(index)) {
					score += 10 + spareBonus(index);
					index += 2;
				} else {
					score += ballsInFrame(index);
					index += 2;
				}
			}
			return score;
		}

		private boolean isStrike(int index) {
			return rolls[index] == 10;
		}

		private boolean isSpare(int index) {
			return ballsInFrame(index) == 10;
		}

		private int strikeBonus(int index) {
			return rolls[index + 1] + rolls[index + 2];
		}

		private int spareBonus(int index) {
			return rolls[index + 2];
		}

		private int ballsInFrame(int index) {
			return rolls[index] + rolls[index + 1];
		}

	}