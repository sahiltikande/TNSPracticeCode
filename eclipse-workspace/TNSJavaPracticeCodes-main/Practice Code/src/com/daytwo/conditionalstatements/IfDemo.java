package com.daytwo.conditionalstatements;

import java.util.Scanner;

public class IfDemo {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		
		if (age >= 18) {
			System.out.println("Your eligible for voting");
		}
		

	}

}
