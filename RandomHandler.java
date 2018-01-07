package Greek_krypto;

import java.util.Random;

public class RandomHandler{
	// Repetition allowed after RepeatAfter.
	public static int RepeatAfter;
	private static int noRepeat[];
	// value of current position save the upcoming random distinct value
	private static int NewVal;

	public static void reset() {
		noRepeat = new int[RepeatAfter];
		NewVal = 0;
		for (int j = 0; j < noRepeat.length; j++) {
			noRepeat[j] = RepeatAfter;
		}
	}

	public static int checkRepeating(int value) {//recursive func..
		int i = 0;

		while (i < noRepeat.length) {
			if (noRepeat[i] == value) {

				break;
			}
			i++;
		}
		if (i == noRepeat.length) {
			noRepeat[NewVal] = value;
			//System.out.println(NewVal+"__"+value+" >>"+noRepeat.length);
			NewVal++;
			
			if (NewVal == noRepeat.length) {
				reset();
			}

			return value;
		}
		/*
		 * recursion and next random number generation
		 */
		Random rand = new Random();
		value = rand.nextInt(RepeatAfter);
		return checkRepeating(value);

	}

}
