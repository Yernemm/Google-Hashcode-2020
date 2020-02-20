import java.util.Arrays;
import java.util.Comparator;
public class LibraryManager {

	LibraryManager(){
		
	}
	
	Integer[][] bruteForceOrders(int length) {
		
		return null; //to-do
	}
	
	Library[] bestScorePotential() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Integer.compare(l2.scorePotential, l1.scorePotential);
			}
		});
		return alllibs;
	}
}
