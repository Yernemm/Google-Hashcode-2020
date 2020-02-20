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
	
	public static Library[] addedheuristic() {
		double scanrateMult = 1000;
		double potentialMult = 0.5;
		double signupMult = 500;
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.scanrate * scanrateMult + l2.scorePotential * potentialMult - (double)l2.signup * signupMult,
						l1.scanrate * scanrateMult + l1.scorePotential * potentialMult - (double)l1.signup * signupMult);
			}
		});
		return alllibs;
	}
	
	public static Library[] mixedheuristic() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.scanrate * l2.scorePotential/(double)l2.signup, l1.scanrate * l1.scorePotential/(double)l1.signup);
			}
		});
		return alllibs;
	}
	
	public static Library[] mixedheuristic2() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.books.length * l2.scanrate * l2.scorePotential/(double)l2.signup, l1.books.length * l1.scanrate * l1.scorePotential/(double)l1.signup);
			}
		});
		return alllibs;
	}
	
	public static Library[] mixedheuristic3() {
		Library[] alllibs = Main.libs;
		Arrays.sort(alllibs, new Comparator<Library>() {
			public int compare(Library l1, Library l2) {
				return Double.compare(l2.scanrate / l2.books.length * l2.scorePotential/(double)l2.signup, l1.scanrate / l1.books.length * l1.scorePotential/(double)l1.signup);
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
				return Double.compare(l1.signup,  l2.signup);
			}
		});
		return alllibs;
	}
}
