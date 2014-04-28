import java.util.*;

/* This class represents each drug with some attributes needed to 
 * manage it*/
class Drug{
    
    //provided by user
    String nameDrug;
    int originalQuantity;
    /*
     * 'p' for pills
     * 'l' for ml
     * 'g' for mg
     * */
    char measure;
    boolean cash;
    int id;
    
    int frequency; //related to days (1 = every day, 2 = a day yes a day no..., 0 = occasionally)
    int daylyFrequency; //1 = once a day, 2 = twice a day...
    /*taken measures how may days have elapsed since last administration*/
    int taken = 0;
    float QuantityTaken;
    
    //provided by the program
    float actualQuantity;
    int remainingDays; //NOT IMPLEMENTED YET
    
    
    /* the constructor is called by farmacy, the id is
        * assigned basing on some rules, is called when 
        * a new drug is added*/
    public Drug(String nd, int o, char m, boolean c, int i, int f, float t, int df) {
        
        nameDrug = nd;
        actualQuantity = originalQuantity = o;
        measure = m;
        cash = c;
        id = i;
        frequency = f;
        QuantityTaken = t;
        daylyFrequency = df;
    }
    
    //get methods
    public String getName() {return nameDrug;}
    public char getUnit() {return measure;}
    public boolean getType() {return cash;}
    public int getOriginalQuantity() {return originalQuantity;}
    public int getId() {return id;}
    public float getActualQuantity() {return actualQuantity;}
    public int getRemainingDays() {return remainingDays;}
    public float getTakenQuantity() {return QuantityTaken;}
    public boolean getCash() {return cash;}
    public int getFrequency() {return frequency;}
    
    //set methods
    public void setActualQuantity(float a) {actualQuantity = a;}
    public void setRemainingDays(int d) {remainingDays = d;}
    public void setAmountTaken(float t) {QuantityTaken = t;}
    
    //say if their drug will expire in this week
    public boolean expiring() {
    	if(frequency == 0) 
    		if(QuantityTaken <= actualQuantity) return true;
    		else return false;
    	
    	//compute the required amount basing on the frequency
    	else {
    		int timesInWeek = (7 / frequency) * daylyFrequency;
    		
    		//Safety purposes
    		timesInWeek++;
    		
    		float requiredAmount;
    		requiredAmount = QuantityTaken * (timesInWeek);
    		
    		if(requiredAmount >= actualQuantity) return true;
    		else return false;
    		
    	}
    }
    
    //the patient takes the drug
    /*Return values: 
     * 1: ok there's enough quantity
     * 0: there's not enough quantity but no prescription
     * -1: there's not enough quantity prescription needed*/
    public int takeDrug() {
    	taken = 0;
    	if(actualQuantity <= 0 || actualQuantity < QuantityTaken) {
    		alertMessage am= new alertMessage("ERROR WAREHOSE NOT UPDATED");
    		return -2;
    	}
    	
    	actualQuantity -= QuantityTaken;
    	int timesInWeek = (7 / frequency) * daylyFrequency;
    	
    	//Safety purposes
    	timesInWeek++;
    	
    	//manage the future taking of the drug
    	if(actualQuantity <= QuantityTaken *timesInWeek ) { 
    		if(cash == true) return 0;
    		else return -1;
    	}
    	else return 1;
    	
    }
    
    //put a new box of drug in the warehouse
    //NOTE: the remaining amount is kept into account
    public void fillDrug(int n) {
    	
    	if(n != 0)
    		actualQuantity += n;
    	
    	else actualQuantity += originalQuantity;
    	
    }
    
    //print the drug
    public String print() {
    	String ret = "Drug: " + nameDrug +
    			"\t original: "+ originalQuantity+measure+" freq: "+
    			frequency+ " taken:"+QuantityTaken+ " remaining"+ actualQuantity;
    	return ret;
    }
    
    /*ADDED PART*/
    public void decrementTaken() {
    	taken--;
    }
    public void incrementTaken() {
    	taken++;
    }
    
    public int getTaken() {return taken;}
    public void setTaken(int t) {taken = t;}
    
    //simulates a day that elapses giving the medicines
    /*Note the return value in all other cases has to be different
     * from 1, 0, -1, so I picked 100, TODO: fix these magic numbers with const*/
    /*
     * NOTE SINCE THIS FUNCTION IS SUPPOSED TO BE USED ONCE A DAY, HENCE 
     * WE REMOVE ALL THE DAYLY QUANTITY OF THE DRUG
     * */
    public int elapsingDay() {
    	
    	//if frequency is 0 then the drug is occasionally taken, so it's not meaningful in our case
    	if(frequency == 0) return 100;
    	
    	incrementTaken();
    	int res = 0;
    	//if the values of taken and frequency are equal
    	if (taken == frequency) {
    		for(int i=0; i<daylyFrequency; i++)
    			res = takeDrug();
    		return res;
    	}
    	
    	return 100;
    }
    
    public int getDaylyFrequency() {return daylyFrequency;}
}