import java.util.*;
public class Process extends Thread {
	private Warehouse w;
	private Calendar today = Calendar.getInstance();
	public void run(Warehouse w1) {
		
		w = w1;
		Calendar expDay = Calendar.getInstance();
		int numbYest = w.getDay();
		int numbToday = expDay.get(6);
		if(numbToday == (numbYest + 1) % 365) {
			w.elapsingDay();
			today = expDay;
		}
		try{
			//sleep for a day
			sleep(24 * 60 * 60 * 1000);
		}
		catch(InterruptedException ie){}
	}
}
