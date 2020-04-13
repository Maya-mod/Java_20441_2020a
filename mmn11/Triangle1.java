/**
 * 
 * @author Maya
 *
 */
import java.util.Scanner;

public class Triangle1 
{
	public static void main (String [] args)
	{
		Scanner scan = new Scanner (System.in);
		
		System.out.println("This program calculates the area " + "and the perimeter of a given triangle. ");
		System.out.println("Please enter the three lengths" + " of the triangle's sides");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int max = 0;
		int mid = 0;
		int min = 0;
		int perimeter = a+b+c;
		final double QUARTER = 0.25; 
		
			if (a>b && a>c) {max = a; 
				if (b>c) {mid = b; min = c;}
					else {mid =c; min = b;}
							} 	
			
			if (b>a && b>c) {max = b; 
				if (a>c) {mid = a; min = c;}
					else {mid =c; min = a;}
						    } 		
			
			if (c>b && c>a) {max = c; 
				if (b>a) {mid = b; min = a;}
					else {mid =a; min = b;}
						    } 		
		
		if(a>0 || b>0 || c>0 ) {
			
			if(a+b<=c || a+c<=b || b+c<=a) { 	
				
				System.out.println("This is not valid Triangle, please try again ");
			}
			else {
			
			double area = (QUARTER*(Math.sqrt((max+(mid+min))*(min-(max-mid))*(min+(max-mid))*(max+(mid-min)))));
			System.out.println("The area of the given Triangle is = " + area);
			System.out.println("The perimeter of the given Triangle is " + perimeter);
			     }
			}			
	}
}
