package com.gmail.gmail;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Cума");
		int summ = sc.nextInt();
		// System.out.println("Номінали");
		int[] price = /* new int[countOfItems] */ { 5, 12, 61 };

		/*
		 * for (int i = 0; i < countOfItems; i++) { System.out.println("Ціна" +i+
		 * "елементу"); price[i]=sc.nextInt(); } for (int i = 0; i < countOfItems; i++)
		 * { System.out.println("Вага" +i+ "елементу"); weight[i]=sc.nextInt(); }
		 */

		int max = getCombinations(price, summ);

		System.out.println(max);

	}

	public static int getCombinations(int[] price, int summ) {

		int[][] table = new int[price.length + 1][summ + 1];
		int max = table[0][0];
		table[0][0] = 1;
		for (int i = 1; i < summ; i++) {
			table[0][i] = 0;
		}
		for (int i = 1; i < price.length + 1; i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i <= price.length; i++) {
			for (int j = 1; j <= summ; j++) {

				if (j < price[i - 1]) {
					table[i][j] = table[i - 1][j];
					continue;
				}
				table[i][j] = table[i - 1][j] + table[i][j - price[i - 1]];

			}

		}

		max = table[price.length][summ];

		return max;
	}

}
