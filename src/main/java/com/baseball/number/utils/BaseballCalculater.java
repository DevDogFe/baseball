package com.baseball.number.utils;

public class BaseballCalculater {
	private int[] nums = new int[3];

	public BaseballCalculater() {
		while ((nums[0] == nums[1]) || (nums[0] == nums[2]) || (nums[1] == nums[2])) {
			nums[0] = (int) (Math.random() * 9) + 1;
			nums[1] = (int) (Math.random() * 9) + 1;
			nums[2] = (int) (Math.random() * 9) + 1;
		}
	}

	public int[] getNumbers() {
		return nums;
	}

	public int[] checkNumbers(int[] guesses) {
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
		int[] result = {strikeCount, ballCount};
		return result;
	}

	public static void main(String[] args) {
		BaseballCalculater calculater = new BaseballCalculater();
		int[] nums = calculater.getNumbers();
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println("");
		int[] g1 = { 1, 2, 3 };
		int[] g2 = { 4, 5, 6 };
		int[] g3 = { 7, 8, 9 };
		int[] r1 = calculater.checkNumbers(g1);
		int[] r2 = calculater.checkNumbers(g2);
		int[] r3 = calculater.checkNumbers(g3);
		for (int i : r1) {
			System.out.print(i + " ");
		}
		for (int i : r2) {
			System.out.print(i + " ");
		}
		for (int i : r3) {
			System.out.print(i + " ");
		}
		
		

	}

}
