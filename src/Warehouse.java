import java.io.*;
import java.util.*;

public class Warehouse {
	
	List<Drug> drugStorage = new ArrayList<Drug>();
	
	//search a Drug basing on the String and returns its index into the list
	protected int search(String name) {
		
		int i;
		
		int s = drugStorage.size();
		for(i=0; i<s; i++) {
			if(drugStorage.get(i).getName().equals(name)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	//fill the quantity of a drug
	public boolean fillDrug(String d, int quantity, int boxes) {
		
		int i = search(d);
		int takenAmount;
		if(i == -1) {//ERROR 
			System.out.println("Error, drug not present");
			return false;
		}
		if(quantity == 0)
			takenAmount = drugStorage.get(i).getOriginalQuantity();
		else takenAmount = quantity;
		takenAmount = takenAmount * boxes;
		drugStorage.get(i).fillDrug(takenAmount);
		
		return true;
		
	}
	
	//add a new Drug
	public boolean addDrug(Drug d) {
		if (search(d.getName()) != -1) {
			System.out.println("Drug already present");
			return false;
		}
		return drugStorage.add(d);
	}
	
	//returns the list of nearly expiring drugs 
	public List<String> expiringDrugs() {
		
		List<String> expiring = new ArrayList<String>() ;
		
		Drug d;
		//get the dimension of the total list
		int n = drugStorage.size();
		
		for(int i = 0; i<n; i++) {
			
			//check if the drug is expiring and then save the name
			d=drugStorage.get(i);
			if (d.expiring()) expiring.add(d.getName());
			
		}
		
		return expiring;
		
	}
	
	//erase a drug
	public void erase(String name) {
		
		int i = search(name);
		if(i != -1) drugStorage.remove(i);		
	}
	
	//take the prescribed amount of the drug
	public void takeDrug(String n) {
		
		int index = search(n);
		int res = drugStorage.get(index).takeDrug();
		if (res == 0) 
			System.out.println("Drug " + n + " expiring need to buy");
		if (res == -1)
			System.out.println("Drug "+ n + " expiring NEED PRESCRIPTION!" );
		if (res == -2)
			System.out.println("Drug" + n + "not updated, you can't take that quantity");
		
	}
	
	//print the list
	public void print() {
		int n = drugStorage.size();
		
		Drug d;
		for(int i=0; i<n; i++) {
			d = drugStorage.get(i);
			d.print();
		}
	}
	
	//simulates a day that elapses
	public void elapsingDay() {
		
		int n=drugStorage.size();
		for(int i=0; i<n; i++) {
			int res = drugStorage.get(i).elapsingDay();
			if (res == 0) 
				System.out.println("Drug " + drugStorage.get(i).getName() + " expiring need to buy");
			if (res == -1)
				System.out.println("Drug "+ drugStorage.get(i).getName() + " expiring NEED PRESCRIPTION!" );
			if (res == -2)
				System.out.println("Drug" + drugStorage.get(i).getName() + "not updated, you can't take that quantity");
		}
		
	}
	
	/*shows all the medicines that will be taken today
	 * their daily frequency, the prescribed amount
	 * and the remaining amount */
	 public void showToday() {
		 
		 int n = drugStorage.size();
		 int tak;
		 Drug d;
		 for (int i = 0; i<n; i++) {
			 
			 d = drugStorage.get(i);
			 
			 //check if the drug has to be taken
			 tak = d.getTaken();
			 tak++;
			 if(tak == d.getFrequency()) {
				 System.out.println("Drug: "+ d.getName() + 
						 "\n\t "+"daily frequency: "+ d.getDaylyFrequency()+ 
						 " "+ "prescribed quantity: "+ d.getTakenQuantity()+
						 "\n\t\t "+ "remaining: " + d.getActualQuantity());
			 }
			 
		 }
		 
	 }
	
	/*********************************************
	 * FILE OPERATIONS
	 * *******************************************
	 */
	
	/*
	 * save the records into a file, the file may also be used to 
	 * upload the various informations in order to avoid the fact
	 * of having to put manually all the informations. 
	 * the file format is .txt, the various infos are
	 * read and written in the following form:
	 * NOTE we use a | to signal the spaces, must not
	 * be put in the real file.
	 * 
	 * NOTE: file must be already present and its name
	 * can't be changed
	 * FORMAT:
	 * __________________________________________________________
	 * | Name | OriginalQuantity | ActualQuantity|
	 * | TakenQuantity | measure | frequency | cash | taken | daylyFrequency
	 * |__________________________________________________________   
	 * 
	 * */
	public void writeToFile() throws FileNotFoundException, UnsupportedEncodingException {
		
		//writer to write on a file
		PrintWriter writer = new PrintWriter("Farmacy.txt" , "UTF-8");
		
		int n = drugStorage.size();
		for(int i=0; i<n; i++) {
			Drug d = drugStorage.get(i);
			
			//effective write
			writer.println(d.getName() + " " + d.getOriginalQuantity() + 
					" " + d.getActualQuantity() + " " + d.getTakenQuantity()+
					" " + d.getUnit() + " "+ d.getFrequency() + " "+ d.getCash()+
					" " + d.getTaken()+ " "+d.getDaylyFrequency() );
			
		}
		
		writer.close();
		
	}
	
	/*
	 * read from the file, the file is in the same format as previously seen
	 * */
	public void readFile() throws FileNotFoundException {
		
		String line;
		
		//we use delims and tokens to parse the line and then do the appropriate conversion
		String delims = "[ ]+";
		String[] tokens;
		BufferedReader br = new BufferedReader(new FileReader("Farmacy.txt"));
		try {
			while ((line = br.readLine()) != null) {
				
				tokens = line.split(delims);
				
				//once we have the list of tokens we need to do the conversions
				String name = tokens[0];
				int original = Integer.parseInt(tokens[1]);
				float actual = Float.parseFloat(tokens[2]);
				float taken = Float.parseFloat(tokens[3]);
				char unit = tokens[4].toCharArray()[0];
				int f = Integer.parseInt(tokens[5]);
				boolean c = Boolean.parseBoolean(tokens[6]);
				int tak = Integer.parseInt(tokens[7]);
				int df = Integer.parseInt(tokens[8]);
				//TODO: the id field has not been implemented yet
				Drug d = new Drug(name, original, unit, c, 0, f, taken, df);
				d.setActualQuantity(actual);
				d.setTaken(tak);
				//add the drug in the list
				addDrug(d);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
