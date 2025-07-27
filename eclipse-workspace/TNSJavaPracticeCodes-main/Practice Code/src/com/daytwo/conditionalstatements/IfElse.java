package com.daytwo.conditionalstatements;

import java.util.Scanner;

public class IfElse {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		
		if (age >= 18) {
			System.out.println("Your eligible for voting");
		}
		else {
			System.out.println("Your not eligible for voting");
		}

	}

}