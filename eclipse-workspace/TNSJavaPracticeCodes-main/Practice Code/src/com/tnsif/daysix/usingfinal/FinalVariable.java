package com.tnsif.daysix.usingfinal;

public class FinalVariable {
		final int x =100;
		
		// Declare and initialize static blank final variable
		
			final static int Z =30;
			
			
		// instance method
		void change()
		{
			//x=20;
		System.out.println(x);	
		}

		@Override
		public String toString() {
			return "FinalVariable [x=" + x + "]";
		}

		public static void main(String[] args)
		{
			FinalVariable f = new FinalVariable();
			System.out.println(f);
			f.change();
		}
		
	}
