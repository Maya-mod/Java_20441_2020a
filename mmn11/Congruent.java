package mmn11;
/**
 * @author Maya
 * @version	25/11/2019
 * This program check if a given Triangles are congruent or not
 * Grade 94!!!!!!  because i didn't calculate the perimeter
 */
import java.util.Scanner;

public class Congruent 
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner (System.in);
		
		System.out.println("This program determines whether a given Triangles are congruent or not ");
		System.out.println("Please enter the points of the first Triangle ");
		//coordinates of the first triangle
		double x11 = scan.nextDouble(); 
		double y11 = scan.nextDouble();
		double x12 = scan.nextDouble(); 
		double y12 = scan.nextDouble();
		double x13 = scan.nextDouble(); 
		double y13 = scan.nextDouble();
		
		System.out.println("Please enter the points of the second Triangle ");
		//coordinates of the second triangle
		double x21 = scan.nextDouble(); 
		double y21 = scan.nextDouble();
		double x22 = scan.nextDouble(); 
		double y22 = scan.nextDouble();
		double x23 = scan.nextDouble(); 
		double y23 = scan.nextDouble();
		 
		System.out.println("The first triangle is ("+x11+ ", " +y11+") (" +x12+ ", "+y12+") (" +x13+ ", " +y13+").");
		double a1 = Math.sqrt(Math.pow(x11-x12, 2)+Math.pow(y11-y12, 2)); //calculate first triangle side a1
		double b1 = Math.sqrt(Math.pow(x11-x13, 2)+Math.pow(y11-y13, 2)); //calculate first triangle side b1
		double c1 = Math.sqrt(Math.pow(x12-x13, 2)+Math.pow(y12-y13, 2)); //calculate first triangle side c1
		System.out.println("Its lengths are " +a1 +", " +b1+ ", "+c1+ ".");
		
		System.out.println("The second triangle is ("+x21+ ", " +y21+") (" +x22+ ", "+y22+") (" +x23+ ", " +y23+").");
		double a2 = Math.sqrt(Math.pow(x21-x22, 2)+Math.pow(y21-y22, 2)); //calculate second triangle side a2
		double b2 = Math.sqrt(Math.pow(x21-x23, 2)+Math.pow(y21-y23, 2)); //calculate second triangle side b2
		double c2 = Math.sqrt(Math.pow(x22-x23, 2)+Math.pow(y22-y23, 2)); //calculate second triangle side c2
		System.out.println("Its lengths are " +a2 +", " +b2+ ", "+c2+ ".");
		
		if (((a1==a2 || a1==b2 || a1==c2) && (b1==a2 || b1==b2 || b1==c2) && (c1==a2 || c1==b2 || c1==c2))) {//checking if both side's of the triangles are equals to each other
			
			if (((a2==a1 || a2==b1 || a2==c1) && (b2==a1 || b2==b1 || b2==c1) && (c2==a1 || c2==b1 || c2==c1))) {
			
				System.out.println("\nThe triangles are congruent.");//Im not sure if you want it to be in a new line
			}
		}
		else {//if the given triangles are not congruent then this message will appear
			System.out.println("\nThe triangles are not congruent.");
		}
	}//end of method main
}//end of class Congruent
