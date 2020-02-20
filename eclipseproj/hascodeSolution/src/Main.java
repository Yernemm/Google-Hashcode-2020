import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static int nDays;
	public static int nBooks;
	public static int nLibs;
	public static int bookScores[];
	public static boolean bookScanned[];
	public static Library libs[];
	public static Library setup;
	public static ArrayList<Library> signedLibs = new ArrayList<Library>();
	public static int score = 0;
	public static int maxScore = 0;
	public static Random r = new Random();
	public static void main(String[] args) {
		
		try {
			//Scanner sc = new Scanner(new File("../../data/a_example.txt"));
			Scanner sc = new Scanner(new File("../../data/b_read_on.txt"));
			//Scanner sc = new Scanner(new File("../../data/c_incunabula.txt"));
			//Scanner sc = new Scanner(new File("../../data/d_tough_choices.txt"));
			//Scanner sc = new Scanner(new File("../../data/e_so_many_books.txt"));
			//Scanner sc = new Scanner(new File("../../data/f_libraries_of_the_world.txt"));
			nBooks = sc.nextInt();
			nLibs = sc.nextInt();
			nDays = sc.nextInt();
			bookScores = new int[nBooks];
			bookScanned = new boolean[nBooks];
			for(int i = 0; i < nBooks; i++) {
				bookScores[i] = sc.nextInt();
				bookScanned[i] = false;
			}
			libs = new Library[nLibs];
			for(int i = 0; i < nLibs; i++) {
				int nLibBooks = sc.nextInt();
				int setupTime = sc.nextInt();
				int booksPerDay = sc.nextInt();
				int libBooks[] = new int[nLibBooks];
				for(int j = 0; j < nLibBooks; j++) {
					libBooks[j] = sc.nextInt();
				}
				for(int j = 0; j < nLibBooks; j++) {
					for(int k = 1; k < nLibBooks-j; k++) {
						if(bookScores[libBooks[k-1]] < bookScores[libBooks[k]]) {
							int t = libBooks[k-1];
							libBooks[k-1] = libBooks[k];
							libBooks[k] = t;
						}
					}
				}
				libs[i] = new Library(libBooks, setupTime, booksPerDay, i);
			}
			
			for(int i = 0; i < 10000; i++) {
				run();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int run() {
		int randmax = 100;
		int randdiv = 98;
		reset();
		score = 0;
		int ind = 0;
		setup = libs[ind];
		boolean allset = false;
		for(int d = 0; d < nDays; d++) {
			for(Library l : signedLibs) {
				score += l.tick();
			}
			if(!allset && setup.setup()) {
				signedLibs.add(setup);
				if(ind < libs.length) {
					ind += 1+r.nextInt(randmax)/randdiv;
					setup = libs[ind];
				}
				else {
					allset = true;
				}
			}
		}
		

		if(maxScore < score) {
			maxScore = score;
			try {
				PrintStream ps = new PrintStream(new File("sube.txt"));
				int n = 0;
				for(Library l : signedLibs) {
					if(l.scanned.size()>0) {
						n++;
					}
				}
				ps.println(n);
				for(Library l : signedLibs) {
					if(l.scanned.size()>0) {
						ps.println(l.id + " " + l.scanned.size());
						for(int i : l.scanned) {
							ps.print(i + " ");
						}
						ps.println();
					}
				}
				System.out.println("found new!! " + score);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return score;
	}
	
	public static void reset() {
		for(Library l : libs) {
			l.reset();
		}
		signedLibs = new ArrayList<Library>();
		//score = 0;
		for(int i = 0; i < nBooks; i++) {
			bookScanned[i] = false;
		}
	}

}
