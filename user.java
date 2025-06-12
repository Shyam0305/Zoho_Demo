package mytestproject2;
import java.util.*;

public class user {
	driver d1=new driver();
	
	user(){
		
	}
	
	public void reqRide(String p,String d) {
		int id = d1.find(p, d);
		
		if(id!=0) {
			System.out.println("Driver assigned "+id);
			d1.go_offline(id);
			d1.update(id,p);
		}
		else{
			System.out.print("No driver available at this moment");
		}
		
	}
}
