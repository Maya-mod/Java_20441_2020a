package mmn12;
/**
 * 
 * @author Maya
 * This class represents a Date Object
 * 
 */
public class Date 
{
		private int _day;
		private int _month;
		private int _year;
		
		private final int MAX_MONTH = 12;
		private final int MIN_MONTH = 1;
		private final int MAX_YEAR = 9999;
		private final int MIN_YEAR = 1000;
		private final int MIN_DAY = 1;
		private final int MAX_DAY = 31;
		private final int DEFAULT_DAY = 1;
		private final int DEFAULT_MONTH = 1;
		private final int DEFAULT_YEAR = 2000;
		private final int JAN = 1;
		private final int FEB = 2;
		private final int MAR = 3;
		private final int APR = 4;
		private final int MAY = 5;
		private final int JUNE = 6;
		private final int JULY = 7;
		private final int AUG = 8;
		private final int SEPT = 9;
		private final int OCT = 10;
		private final int NOV = 11;
		private final int DEC = 12;
		private final int LAST_DAY_FEB_LEAP_YEAR = 29;
		private final int LAST_DAY_FEB_NOT_LEAP_YEAR = 28;
		private final int LAST_DAY_SHORT_MONTH = 30;
		private final int LESS_THEN_2_DIG = 10;
		private final int ZERO = 0;
		private final int DIVIDE_BY_FOUR = 4;
		private final int DIVIDE_BY_CENTURY = 100;
		private final int DIVIDE_BY_FOUR_HUNDRED = 400;
		private final int MONTH_FORTEEN = 14;
		private final int MONTH_THIRTEEN = 13;
		
		
	//constructors:
	/**
	 * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
	 * @param day the day in the month (1-31)
	 * @param month the month in the year (1-12)
	 * @param year year the year (4 digits)
	 */
	public Date(int day, int month, int year) { 
			
		this._day = day;
		this._month = month;
		this._year = year;
		
		if(!validDate(day, month, year)) {
			_day=DEFAULT_DAY;
			_month=DEFAULT_MONTH;
			_year=DEFAULT_YEAR;
		}
	}//end of constructor Date

	/**
	 * Copy Constructor
	 * @param date to be copied
	 */
	public Date (Date other) {
		
		_day = other._day;
		_month = other._month;
		_year = other._year;	
	}//end of copy constructor 

    //help determine if the given Date is valid or not
	private boolean validDate(int day, int month, int year) {

		if((day<MIN_DAY)||(month<MIN_MONTH)||(month>MAX_MONTH)||(year<MIN_YEAR)||(year>MAX_YEAR)) {
			return false;
			
		}else {
		if(month==FEB) { //check the validation of February date
			if (((year%DIVIDE_BY_FOUR==ZERO)&&(year%DIVIDE_BY_CENTURY!=ZERO))||(year%DIVIDE_BY_FOUR_HUNDRED==ZERO)) { //February on leap year
				if (day>LAST_DAY_FEB_LEAP_YEAR) {
					return false;
				}
			}	
			else if (day>LAST_DAY_FEB_NOT_LEAP_YEAR) {//if February not in a leap year
					return false;
			}
		}else if(((month==APR)||(month==JUNE)||(month==SEPT)||(month==NOV)))  {//check the validation of months that end with 30
			
				if(day>LAST_DAY_SHORT_MONTH) {
					return false;
				}
		}else if((month==JAN)||(month==MAR)||(month==MAY)||(month==JULY)||(month==AUG)||(month==OCT)||(month==DEC)) {//check the validation of months that end with 31
			if (day>MAX_DAY) {
				return false;
			}
		}
		}	
		return true;	
	}//end of method validDate
	
	/**
	 * check if 2 dates are the same
	 * @param other the date to compare this date to
	 * @return true if the dates are the same
	 */
	public boolean equals(Date other) {
		
		if ((this._day==other._day)&&(this._month==other._month)&&(this._year==other._year)) {
			return true;	
		}
		return false;
	}//end of method equals
	
    /**
    * checks if this date comes before a given date
    * @param other the given date
    * @retun true if this date comes before other
    */
	public boolean before(Date other) {
		
		if(this._year < other.getYear()) {
			return true;
		}
		if(this._year == other.getYear()) {
			if(this._month < other._month)
				return true;
			
			if(this._month == other._month) {
				if(this._day < other._day)
					return true;
			}
		}	
		return false;
	}//end of method before
	
	/**
	 * check if this date is after other date
	 * @param other the given date
	 * @return true if this date comes after other
	 */
	public boolean after(Date other) {
		 
		return other.before(this); 
	}//end of method after
	
	/**
	 * returns a String that represents this date
	 * @return String that represents this date
	 * in the following format:
	 * day/month/year 01/09/2019
	 */
	public String toString() {
		
		if (_day<LESS_THEN_2_DIG && _month>=LESS_THEN_2_DIG) {//string for 2/12/1999
			return "0"+_day+"/"+_month+"/"+_year;
		}
		if (_month<LESS_THEN_2_DIG && _day>=LESS_THEN_2_DIG) {//string for 12/2/1999
			return _day+"/0"+_month+"/"+_year;
		}
		if (_day<LESS_THEN_2_DIG && _month<LESS_THEN_2_DIG) {//string for 2/2/1999
			return "0"+_day+"/0"+_month+"/"+_year;
		}		
		else {
			return _day+"/"+_month+"/"+_year; //string for 12/12/1999
		}
	}//end of method toString
	
	/** gets the Day
	* @return the day
	*/
	public int getDay() {
		
		return this._day;		
	}//end of method getDay
	
	/** gets the Month
	* @return the month
	*/
	public int getMonth() {
		
		return this._month;
	}//end of method getMonth
	
	/** gets the Year
	* @return the year
	*/
	public int getYear() {
		
		return this._year;
	}//end of method getYear
	
	/** sets the day
	* @param dayToSet the value to be set
	*/
	public void setDay(int dayToSet) {
		
		if(validDate(dayToSet, _month, _year)) {
			this._day = dayToSet;
		}
	}//end of method setDay

	/** sets the month
	* @param monthToSet the value to be set
	*/
	public void setMonth(int monthToSet) {
		
		if (validDate(_day, monthToSet, _year)) {
			this._month = monthToSet;
		}
	}//end of method setMonth
	
	/** sets the year
    * @param yearToSet the value to be set
    */	
	public void setYear(int yearToSet) {
		
		if(validDate(_day, _month, yearToSet)) 
			this._year = yearToSet;
	}//end of method setYear
	 
	/**
	 * calculate the date of tomorrow
	 * @return the date of tomorrow
	 */
	public Date tomorrow() {

		if(!new Date(_day+1, _month, _year).equals(new Date(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR))) { //if the date id no equal to the default day
			return new Date(_day+1, _month, _year);//then the date of tomorrow will be day+1, month, year
		}
		if(_month == DEC) {//on December 
			return new Date(DEFAULT_DAY, DEFAULT_MONTH, _year+1);
		}
		return new Date(DEFAULT_DAY, _month+1, _year);

	}//end of method tomorrow
			
    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * @return the day of the week that this date occurs on
     */
	public int dayInWeek() {
	
		int D = this.getDay();
		int M = this.getMonth();
		int full_year = this.getYear();

		if (M==JAN) { 
			M = MONTH_THIRTEEN;
			full_year--;
		}
		if (M==FEB) {
			M = MONTH_FORTEEN;
			full_year--;
		}	
		
		int Y = full_year%DIVIDE_BY_CENTURY;	
		int C = full_year/DIVIDE_BY_CENTURY;

		int dayInWeek = Math.floorMod((D+(int)(26*(M+1))/10+Y+(int)Y/4+(int)C/4-2*C),7);
			return dayInWeek;	
	}//end of method dayInWeek
		
	//computes the day number since the beginning of the Christian counting of years
 	//return the number of days since the beginning of the Christian counting of years 
	private int calculateDate(int day, int month, int year) {
		
		if (month<MAR) {
			year--;
			month = month + 12 ;
		}
		return 365*year+(year/4) -(year/100) +(year/400) +((month+1)*306)/10+(day-62);
	}//end of method calculateDate
	
    /**
     * calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates
     */
	public int difference(Date other) {
		
		return Math.abs(calculateDate(this._day, this._month, this._year)-calculateDate(other._day, other._month, other._year));
	}//end of method difference
}//end of class Date