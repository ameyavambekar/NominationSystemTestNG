package util;

import java.util.Random;

public class TestUtil {

	public static String generateRandomString(int length) {
		String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder output = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i <= length - 1; i++) {
			int index = random.nextInt(alpha.length());
			output.append(alpha.charAt(index));
		}
		return output.toString();
	}

}
