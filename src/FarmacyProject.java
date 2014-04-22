import java.util.*;
import java.io.*;

/**
 * Simple java template
 */

public class FarmacyProject {
	
	static String welcome = "Hello, welcome in this drugs warehouse project "
			+ "it is intended to help you organiza drugs with or without p"
			+ "prescription and help you to order medicines when you don't have "
			+ "or you will finish them in a very short time (a week)";
	static String help = "\n\nType one of the following commands: \n"
			+ "\n'a' add a new drug to the warehouse, you'll be asked"
			+ " to put all the informations each time "
			+ "\n'd' a day has gone so the warehouse will be updated with all the medicines taken"
			+ "\n'i' inventary in this way you can see what there's on the shelf and eventually see "
			+ "if it's necessary going to the farmacy"
			+ "\n'f' load a warehouse from the file, up to now the default filename is farmacy.txt"
			+ "\n'e' erase a drug, it is not needed anymore "
			+ "\n't' a drug has been taken (this command is useful for those drugs occasionally taken)"
			+ "and in those days in which you take just one drug forgetting the others"
			+ "\n's' to save the warehouse into a file named 'Farmacy.txt' that already exists"
			+ "\n'x' to check the list of expiring drugs"
			+ "\n'b' show the drugs that have to be taken today"
			+ "\n'q' to quit the programm"
			+ "\n'r' to replenish a drug"
			+ "\n'h' to display the help";		
	
	public static void main(String[] args) {
		
		System.out.println(welcome);
		Warehouse w = new Warehouse();
		Scanner keyboard = new Scanner(System.in);
		System.out.println(help);
		
		while(true) {
			
			System.out.println("Type a command....");
			char t = keyboard.next().charAt(0);
			
			//basing on the character inserted check te command to be performed
			switch (t) {
			case 'f': 
				try {
					w.readFile();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 'd':
				w.elapsingDay();
				break;

			case 'i':
				System.out.println("Printing the warehouse: ");
				w.print();
				break;

			case 'a':
				System.out.println("Insert name: ");
				String n = keyboard.next();
				System.out.println("Insert quantity in the box: ");
				int q = keyboard.nextInt();
				System.out.println("Insert the metric: 'p' for pills, 'l' for ml and 'g' for mg");
				char u = keyboard.next().charAt(0);
				System.out.println("Insert the taken amount with a coma ',' to separate decimals");
				float f = keyboard.nextFloat();
				System.out.println("It has no medical prescription (insert 'true' or 'false')");
				boolean b = Boolean.parseBoolean(keyboard.next());
				System.out.println("Insert frequency\n"
						+ "0 = occasionally\n"
						+ "1 = every day\n"
						+ "2 = one day yes one day no"
						+ "and so on... ");
				int freq = keyboard.nextInt();
				System.out.println("Insert dayly frequency");
				int df = keyboard.nextInt();
				Drug d = new Drug(n, q, u, b, 0, freq, f, df);
				w.addDrug(d);
				break;
			case 't':
				System.out.println("Insert name: ");
				String name = keyboard.next();
				w.takeDrug(name);
				break;
			case 'h':
				System.out.println(help);
				break;
			case 's':
				try {
					w.writeToFile();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 'x':
				List<String> l = w.expiringDrugs();
				System.out.println(l);
				break;
			case 'q':
				System.out.println("Have you saved? (type 'y' or 'n')");
				char car = keyboard.next().charAt(0);
				if(car == 'n') break;
				else
					return;
			case 'e':
				System.out.println("Insert the drug to erase");
				String toErase = keyboard.next();
				w.erase(toErase);
			case 'b':
				w.showToday();
				break;
			case 'r':
				System.out.println("Insert the drug to replenish");
				String replenish = keyboard.next();
				System.out.println("Insert the amount (0 is the default)");
				int quantity = keyboard.nextInt();
				System.out.println("Insert the number of boxes");
				int boxes = keyboard.nextInt();
				w.fillDrug(replenish, quantity, boxes);
			break;
			default:
				System.out.println(help);
				break;
			}
		}
	}
}
