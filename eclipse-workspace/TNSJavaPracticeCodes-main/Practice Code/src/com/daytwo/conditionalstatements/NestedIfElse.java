package com.daytwo.conditionalstatements;

public class NestedIfElse {
	
	public static void main(String[] args) {

		int a=10, b=30, c=75;
		
		System.out.println("The Largest number is: ");
		
		if(a>b)
		{
			if(a>c)
			{
				System.out.println(a);
			}
			else
			{
				System.out.println(c);
			}
		}
		else
		{
			if(b>c)
			{
				System.out.println(b);
			}
			else
			{
				System.out.println(c);
			}
		}
	}

}
