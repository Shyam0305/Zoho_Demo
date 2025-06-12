package mytestproject2;
import java.util.*;

public class driver {
	static List<drivemanage> drivers;
//	boolean isAvailable;//	String status;
	static HashMap<String,Integer> hash;
	
	driver(){
		drivers = new ArrayList<>();
	}
	
	static {
			hash = setHash();
	}
	
	public static HashMap<String,Integer> setHash(){
		HashMap<String,Integer> st = new HashMap<>();
		
		st.put("A", 1);
		st.put("B", 2);
		st.put("C", 3);
		st.put("D", 4);
		st.put("E", 5);
		
		return st;
	}
	
	public void addDrivers(int driver_id,String location){
		drivers.add(new drivemanage(driver_id,location));
	}
	
	public void go_offline(int driver_id) {
		
		for(int i=0;i<drivers.size();i++) {
			if(drivers.get(i).id==driver_id) {
				drivers.get(i).status="OFFLINE";
			}
		}
	}
	
	
	public void get_status(int driver_id) {
		
		for(int i=0;i<drivers.size();i++) {
			if(drivers.get(i).id==driver_id) {
				System.out.println(drivers.get(i).status+" "+drivers.get(i).location);
			}
		}
	}
	
	public int  find(String p,String d) {
		int dist = 100;
		int drive_id = 0;
		
		for(int i=0;i<drivers.size();i++) {
			if(drivers.get(i).status.equals("ONLINE")) {
				String loc = drivers.get(i).location;
				if((hash.get(loc)-hash.get(p)) < dist) {
					dist=hash.get(loc)-hash.get(p);
					drive_id = drivers.get(i).id;
				}
			}
		}
		
		return drive_id;
	}
	
	public void listAvailable() {
		System.out.println("List of available drivers :");
		for(int i=0;i<drivers.size();i++) {
			drivemanage dk = drivers.get(i);
			
			if(dk.status.equals("ONLINE")) {
				System.out.println(dk.id+" "+dk.location);
			}
		}
	}
	
	public void update(int id,String loc) {
		for(int i=0;i<drivers.size();i++) {
			if(drivers.get(i).id==id) {
				drivers.get(i).temp=drivers.get(i).location;
				drivers.get(i).location=loc;
			}
		}
	}
	
	public void cancel(int driver_id) {
		for(int i=0;i<drivers.size();i++) {
//			if(drivers.get(i).status.equals("ONLINE")) {
				drivers.get(i).status="OFFINE";
				drivers.get(i).location=drivers.get(i).temp;
//			}
		}
	}
	
}
