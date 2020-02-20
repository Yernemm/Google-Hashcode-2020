import java.util.Arrays;
import java.util.Comparator;
public class LibraryManager {

	LibraryManager(){
		
	}
	
	public static Integer[][] bruteForceOrders(int length) {
		
		return null; //to-do
	}
	
	public static Library[] bestScorePotential() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Integer.compare(l2.scorePotential, l1.scorePotential);
			}
		});
		return alllibs;
	}
	
	public static Library[] bestSetupTime() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Integer.compare(l1.signup, l2.signup);
			}
		});
		return alllibs;
		
	}
	
	public static Library[] heuristic() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.scorePotential/(double)l2.signup,  l1.scorePotential/(double)l1.signup);
			}
		});
		return alllibs;
	}
	
	public static Library[] heuristic2() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.scorePotential/(double)l2.signup/l2.signup,  l1.scorePotential/(double)l1.signup/l2.signup);
			}
		});
		return alllibs;
	}
}
