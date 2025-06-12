package mytestproject2;
import java.util.*;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	user u=new user();
	driver d=new driver();
	boolean k = true;
	
	while(k) {
		d.addDrivers(sc.nextInt(),sc.next());
		d.addDrivers(sc.nextInt(),sc.next());
		d.addDrivers(sc.nextInt(),sc.next());
		d.go_offline(sc.nextInt());
		d.listAvailable();
		u.reqRide(sc.next(), sc.next());
		u.reqRide(sc.next(), sc.next());
		d.get_status(sc.nextInt());
		break;
	}
	}
}
