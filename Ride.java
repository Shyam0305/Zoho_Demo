package mytestproject2;
import java.util.*;

public class Ride {
	int rideId,driver_id;
	String p,d;
	static HashMap<Integer,Ride> hash;
	
	public void add(String p,String d,int driver_id) {
		this.driver_id=driver_id;
		this.p=p;
		this.d=d;
		this.rideId+=1;
	}
	
	
	public void disp(int rideId) {
		
	}
}
