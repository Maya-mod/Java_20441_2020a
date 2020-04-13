/**
* @author Maya
* @version	25/11/2019
*  This program calculate the area and the perimeter of a given triangle  
*/
import java.util.Scanner;

public class Triangle 
{	
		public static void main (String [] args)
		{
			Scanner scan = new Scanner (System.in);
				
			System.out.println("This program calculates the area " + "and the perimeter of a given triangle. ");
			
			System.out.println("Please enter the three lengths" + " of the triangle's sides");
			//receive the sides of the triangles
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			int perimeter = a+b+c; //calculate the perimeter of the given triangle
			final double QUARTER = 0.25;
			
			//creating a term which determine if the given side's a, b, c, are fit to be a legit triangle
			if(a+b>c && a+c>b && b+c>a) { 
				double area = (QUARTER*(Math.sqrt((a+b+c)*(a+b-c)*(b+c-a)*(c+a-b))));//calculate the area according to Heron formula.
				//BUT i use in the second formula which i found more accurate even though we were asked for int
				System.out.println("The area of the given Triangle is = " + area);
				System.out.println("The perimeter of the given Triangle is " + perimeter);
			}	
			//if the given sides do not form a triangle then this message will appear
			else {
				
				System.out.println("The given sides " +a+ ", " +b+ " & " +c+ ", " + "do not form a valid Triangle. ");
			}
			
		}//end of method main
	}//end of class Triangle
