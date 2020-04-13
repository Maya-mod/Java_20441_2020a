package mmn12;

public class DateTester
{
	public static void main(String[] args) throws Exception
	{
		String fileName = "Date_Test_Result_Xh9PtPbZK4";
		
		Date d = new Date(2, 1, 1999);
		Date d2 = new Date(1, 3, 1549);
		Date d3 = new Date(1, 3, 1551);
		
		Tester t = new Tester(d);
		
		if(!d.toString().equals("02/01/1999"))
		{
			System.out.println("Its looks like your toString method is incorrect");
			System.out.println("This tester uses the toString method as a comperation method");
			System.out.println("and if your toString method isn't implemented like in the document");
			System.out.println("so this tester will not work\n");
			
			System.out.println("your Date toString returns this");
			System.out.println(d.toString());
			System.out.println("But it need to be like this");
			System.out.println("02/01/1999");
			
			System.out.println("\nFix your toString method and then run this test again");
			System.exit(0);
		}
		
		// check base constructor
		t.checkConstructor("01/01/2000", -1, 2, 2000);
		t.checkConstructor("01/01/2000", 0, 2, 2000);
		t.checkConstructor("01/01/2000", 1, -1, 2000);
		t.checkConstructor("01/01/2000", 1, 0, 2000);
		t.checkConstructor("01/01/2000", 1, 1, 999);
		t.checkConstructor("01/01/2000", 1, 1, 10000);
		t.checkConstructor("07/01/2043", 7, 1, 2043);
		t.checkConstructor("02/12/2012", 2, 12, 2012);
		t.checkConstructor("29/02/1600", 29, 2, 1600);
		t.checkConstructor("01/01/2000", 29, 2, 1700);

		// check copy constructor
		t.checkConstructor("02/01/1999", d);
		t.checkConstructor("01/03/1549", d2);
		t.checkConstructor("01/03/1551", d3);


		t.checkMethod(d, "setDay", d.toString(), -1);
		t.checkMethod(d, "setDay", d.toString(), 0);
		t.checkMethod(d, "setDay", "01/01/1999", 1);
		t.checkMethod(d, "setDay", "31/01/1999", 31);
		t.checkMethod(d, "setDay", d.toString(), 32);
		
		d = new Date(1, 4, 1999);
		
		t.checkMethod(d, "setDay", d.toString(), -1);
		t.checkMethod(d, "setDay", d.toString(), 0);
		t.checkMethod(d, "setDay", "01/04/1999", 1);
		t.checkMethod(d, "setDay", "30/04/1999", 30);
		t.checkMethod(d, "setDay", d.toString(), 31);

		d = new Date(2, 2, 1999);
		
		t.checkMethod(d, "setDay", d.toString(), -1);
		t.checkMethod(d, "setDay", d.toString(), 0);
		t.checkMethod(d, "setDay", "01/02/1999", 1);
		t.checkMethod(d, "setDay", "28/02/1999", 28);
		t.checkMethod(d, "setDay", d.toString(), 29);
		t.checkMethod(d, "setDay", d.toString(), 30);
		
		d = new Date(2, 2, 2000);
		
		t.checkMethod(d, "setDay", "28/02/2000", 28);
		t.checkMethod(d, "setDay", "29/02/2000", 29);
		t.checkMethod(d, "setDay", d.toString(), 30);
		
		d = new Date(1, 3, 1550);

		t.checkMethod(d, "setMonth", d.toString(), -1);
		t.checkMethod(d, "setMonth", d.toString(), 0);
		t.checkMethod(d, "setMonth", "01/01/1550", 1);
		t.checkMethod(d, "setMonth", "01/12/1550", 12);
		t.checkMethod(d, "setMonth", d.toString(), 13);

		d = new Date(30, 3, 2000);
		t.checkMethod(d, "setMonth", "30/03/2000", 2);
		d = new Date(29, 3, 2000);
		t.checkMethod(d, "setMonth", "29/02/2000", 2);
		d = new Date(29, 3, 1999);
		t.checkMethod(d, "setMonth", "29/03/1999", 2);
		d = new Date(28, 3, 1999);
		t.checkMethod(d, "setMonth", "28/02/1999", 2);
		d = new Date(31, 1, 1999);
		t.checkMethod(d, "setMonth", "31/01/1999", 4);
		
		d = new Date(1, 3, 1550);

		t.checkMethod(d, "setYear", d.toString(), 999);
		t.checkMethod(d, "setYear", "01/03/1000", 1000);
		t.checkMethod(d, "setYear", "01/03/9999", 9999);
		t.checkMethod(d, "setYear", d.toString(), 10000);

		d = new Date(29, 2, 2000);
		t.checkMethod(d, "setYear", "29/02/2000", 2001);
		d = new Date(28, 2, 2001);
		t.checkMethod(d, "setYear", "28/02/2000", 2000);
		
		d = new Date(1, 3, 1550);

		t.checkMethod(d, "equals", "true", d);
		t.checkMethod(d, "before", "false", d);
		t.checkMethod(d, "after", "false", d);
		
		t.checkMethod(d, "equals", "false", d2);
		t.checkMethod(d, "before", "false", d2);
		t.checkMethod(d, "after", "true", d2);

		t.checkMethod(d, "equals", "false", d3);
		t.checkMethod(d, "before", "true", d3);
		t.checkMethod(d, "after", "false", d3);
		
		d = new Date(2, 3, 1550);
		d2 = new Date(1, 3, 1550);
		d3 = new Date(3, 3, 1550);

		t.checkMethod(d, "equals", "true", d);
		t.checkMethod(d, "before", "false", d);
		t.checkMethod(d, "after", "false", d);
		
		t.checkMethod(d, "equals", "false", d2);
		t.checkMethod(d, "before", "false", d2);
		t.checkMethod(d, "after", "true", d2);

		t.checkMethod(d, "equals", "false", d3);
		t.checkMethod(d, "before", "true", d3);
		t.checkMethod(d, "after", "false", d3);
		
		d = new Date(1, 3, 1550);
		d2 = new Date(1, 2, 1550);
		d3 = new Date(1, 4, 1550);

		t.checkMethod(d, "equals", "true", d);
		t.checkMethod(d, "before", "false", d);
		t.checkMethod(d, "after", "false", d);
		
		t.checkMethod(d, "equals", "false", d2);
		t.checkMethod(d, "before", "false", d2);
		t.checkMethod(d, "after", "true", d2);

		t.checkMethod(d, "equals", "false", d3);
		t.checkMethod(d, "before", "true", d3);
		t.checkMethod(d, "after", "false", d3);
		
		d = new Date(1, 2, 2004);
		t.checkMethod(d, "tomorrow", "02/02/2004");
		d.setDay(29);
		t.checkMethod(d, "tomorrow", "01/03/2004");
		d.setMonth(12);
		d.setDay(31);
		t.checkMethod(d, "tomorrow", "01/01/2005");
		d.setYear(9999);
		t.checkMethod(d, "tomorrow", "01/01/2000");
		
		d = new Date(8, 12, 2006);
		d2 = new Date(1, 5, 2004);
		
		t.checkMethod(d, "difference", "951", d2);
		
		d = new Date(4, 12, 2026);
		d2 = new Date(1, 10, 1993);
		
		t.checkMethod(d, "difference", "12117", d2);
		
		d = new Date(1, 3, 2000);
		t.checkMethod(d, "dayInWeek", "4");
		d.setDay(2);
		t.checkMethod(d, "dayInWeek", "5");
		d.setDay(25);
		t.checkMethod(d, "dayInWeek", "0");
		d.setDay(31);
		t.checkMethod(d, "dayInWeek", "6");
		
		t.printResult(fileName);
		System.out.println("The test ended.\nCheck your desktop.");
		System.out.printf("you should see a new text file %s", fileName);
	}
}
