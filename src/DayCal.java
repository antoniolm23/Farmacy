import java.util.*;

//implements a VERY simple calendar
class DayCal{
    
	int year;
	String Days[] = {"MON" , "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	String Months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", 
			"AUG", "SEP", "OCT", "NOV", "DEC"};
    int dayInMonth;
	int actualMonth;
    String DayName; //name of the first day of the month 
    
    //instantiate a new calendar given year and month
    public DayCal(int y, String m, String d) {
    	
    	year = y;
    	DayName = d;
    	
    	//compute the number of days in the month under consideration
    	for(int i = 0; i<12; i++) {
    		
    		if(Months[i].equals(m)) {
    			actualMonth = i;
    			
    			//April, june, september, november
    			if(i==4 || i==6 || i==9 || i==11) dayInMonth = 30;
    			
    			//february and bisestile year
    			if(i==2) {
    				if(y%4 == 0) dayInMonth = 29;
    				else dayInMonth = 28;
    			}
    		}
    	}
    	
    }
    
    //provides the name of the day given the number of the day
    public String DayInNumber(int n) {
    	
    	//offset w.r.t. the first day of the month
    	int i = n % 7;
    	int j;
    	String day;
    	
    	for(j=0; j<7; j++) {	
    		//match between strings
    		if(DayName.equals(Days[j])) {
    			
    			day = Days[(i+j)%7];
    			return day;
    			
    		}
    		
    	}
    	
    	return "NULLNAME";
    	
    }
      
}