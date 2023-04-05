package com.baseball.number.utils;

public class BaseballCalculater {
	private int[] nums = new int[3];

	public BaseballCalculater() {
		while ((nums[0] == nums[1]) || (nums[0] == nums[2]) || (nums[1] == nums[2])) {
			nums[0] = (int) (Math.random() * 9) + 1;
			nums[1] = (int) (Math.random() * 10);
			nums[2] = (int) (Math.random() * 10);
		}
	}

	public int[] getNumbers() {
		return nums;
	}

	public int[] checkNumbers(int[] nums, int[] guesses) {
		int strikeCount = 0;
		int ballCount = 0;
		if (nums == guesses) {
			strikeCount = 3;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == guesses[i])
					strikeCount++;
			}
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < guesses.length; j++) {
					if (i != j && nums[i] == guesses[j])
						ballCount++;
				}
			}
		}
		int[] result = { strikeCount, ballCount };
		return result;
	}

}
