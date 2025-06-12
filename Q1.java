package hello;
import java.util.*;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean k = true;
		HashMap<Character,Integer> hash = new HashMap<>();
		List<Integer> ini = new ArrayList<>();
		boolean commit=false,roll=false;
		int begin=0;
		
		for(int i=0;i<27;i++) {
			ini.add(-1);
		}
		
		while(k) {
			String s = sc.next();
			
			if(s.equals("SET")) {
				char a = sc.next().charAt(0);
				int var  = sc.nextInt();
				
				hash.put(a, var);
				if(begin==0) ini.set(a-'A',var);
				
			}else if(s.equals("GET")) {
				char a = sc.next().charAt(0);
				
				System.out.print(hash.get(a));
				
			}else if(s.equals("UPDATE")) {
				char a = sc.next().charAt(0);
				int var  = sc.nextInt();
				
				if(hash.containsKey(a)) {
					hash.put(a, var);
				}else System.out.print("Variable not found");
				
			}else if(s.equals("UNSET")) {
				char a = sc.next().charAt(0);
				
				hash.remove(a);
				if(begin==0) ini.set('A'-a,-1);
				
			}else if(s.equals("COUNT")) {
				int var  = sc.nextInt();
				int cp=0;
				
				for(Character c : hash.keySet()) {
					if(hash.get(c)==var) cp++;
				}
				
				if(cp!=0) System.out.print(cp);
				else System.out.print("NULL");
				
			}else if(s.equals("BEGIN")) {
				begin+=1;
			}else if(s.equals("ROLLBACK")) {
				roll=true;
				System.out.println(ini);
				
				if(roll && begin>0) {
					for(int i=0;i<ini.size();i++) {
						if(ini.get(i)!=-1) {
							hash.put((char)(i+65), ini.get(i));
						}else hash.remove((char)(i+65));
					}
					
					begin-=1;
				}
			}else if(s.equals("COMMIT")) {
				commit=true;
				
				if(commit) {
					for(Character c : hash.keySet()) {
						ini.set(c-'A',hash.get(c));
					}
				}
				
			}else {
				break;
			}
		}
	}
}
