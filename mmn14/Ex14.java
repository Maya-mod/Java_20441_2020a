
/******************************************************
 * 
 * @author Maya
 * @version 01/02/2020
 * This class represents a mmn Ex14
 *
 ******************************************************/
	public class Ex14 {
	
	
	/***************************************************
	 * Count how many sub strings that start and end 
	 * with the given char exists in a given string
	 * 
	 * The efficiency is O(n)
	 * The complexity is O(1)
	 * 
	 * @param s the string
	 * @param c the char
	 * @return the number of the sub strings 
	 ***************************************************/
	public static int subStrC(String s, char c) {
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
    	if (s.charAt(i) == c ) {
                count++;
            }
        }
        if (count<3) {
            return 0;
        }
        return count-2;
    }//end of method subStrC
    
    /*************************************************************************
     * Count how many sub strings that start and end with the given char 
     * And contain maximum the given number k
     * 
     * The efficiency is O(n)
	 * The complexity is O(1)
     * 
     * @param s the string
     * @param c the char
     * @param k the number of chars
     * @return the number of the sub strings
     *************************************************************************/
    public static int subStrMaxC(String s, char c, int k) {
        int count = 0;
        int countSub = 0;
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c ) {
                if(count>0) {
                    countSub += Math.min(k+1, count);
                }
                count++;
            }
        }
        if (count<2) {
            return 0;
        }
        return countSub;
    }//end of method subStrMaxC
	
    /**********************************************************
     * Change the values of a given array that it will show 
     * The distance from zero to zero
     * 
     * The efficiency is 2*O(n)
	 * The complexity is O(1)
	 * 
     * @param a an array of 0's and 1's
     **********************************************************/
   	public static void zeroDistance(int[] a) {
        int count = 0;
        int CountFromEnd = 0;
        boolean foundZero = false;
        boolean foundfirstZero = false;
        int firstZero=-1; //if no zero yet
        
        for(int i=0; i<a.length ; i++) {
            count++;
            if(a[i]==0 && firstZero==-1) {
                firstZero=i;
            }
            if(a[i]==0) {
                count=0;
            }
            a[i]=count;  
        }
        for(int i=a.length-1; i>=0; i--) {//deciding on the sequence to apply and how
            if(foundfirstZero==false) {//if no zero
            	CountFromEnd++;
            }
            if(firstZero==i) {
            	foundfirstZero=true;
                CountFromEnd=0;  
            }
            if(a[i]==0) {
            	foundZero=true;
            }else if(a[i]==CountFromEnd) {
            	foundZero=false;  
            }
            if(foundfirstZero==false) {
                if(a[i]==0 || a[i]==CountFromEnd) {
                	CountFromEnd=0;
                }
                if(a[i]>CountFromEnd && foundZero==true) {
                    a[i]=CountFromEnd;
                }
            }
            else{
                a[i]=CountFromEnd;
                CountFromEnd++;
            }
        } 
    }//end of method zeroDistance
    
    /********************************************************
     * Check if a given string is trans of another string 
     * 
     * @param s string from which we need to compare to
     * @param t string
     * @return true if trans and false if not
     ********************************************************/
    public static boolean isTrans(String s, String t) {
    	
    	  return isTrans(s, t, 0, 0);
    	  
    }//end of method isTrans
    
 	//Overload countPaths
    //Using recursion for determine if string t is trans of string s
    private static boolean isTrans(String s, String t, int sStart, int tStart) {

        if (tStart == t.length() || sStart == s.length()) {
        	return tStart == t.length() && sStart == s.length();
        }
        char sChar = s.charAt(sStart);
        char tChar = t.charAt(tStart);

        return sChar == tChar && (isTrans(s, t, sStart + 1, tStart + 1) || isTrans(s, t, sStart, tStart + 1));
    }//end of private method isTrans
          
    /*****************************************************************************
     * Count how many path can be taken from the top left to the bottom right
     * According to the given directions
     * Using overload i created a private recursion for count all the possible paths.
     * @param mat 2D array
     * @param i row
     * @param j col
     * @return the number of paths
     *****************************************************************************/
    public static int countPaths(int[][] mat) {
    	
    	return countPaths(mat, 0, 0);
    	
    }//end of method countPaths
    
    //Overload countPaths
    //Using recursion for count all the possible paths from 
   private static int countPaths(int[][] mat, int i, int j) {
    	
	   if(i>=mat.length 
			   || j>=mat[0].length 
			   || ((mat[i][j] == 0) && (0 != mat[mat.length -1][mat[0].length -1]))){
		   return 0;
	   }
	   if(i==mat.length-1 && j==mat[0].length-1)  {
		   return 1;
	   }
	   if ((mat[i][j]/10==mat[i][j]%10) && (mat[i][j]<= mat[mat.length -1][mat[0].length -1])) {
		   return 1;	
	   }
	   return countPaths(mat, i+mat[i][j]/10, j+mat[i][j]%10)
			   +countPaths(mat, i+mat[i][j]%10, j+mat[i][j]/10);
   }//end of private method countPaths
    	
}//end of class Ex14
