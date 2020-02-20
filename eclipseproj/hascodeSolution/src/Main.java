import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

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
	public static void main(String[] args) {
		
		try {
			//Scanner sc = new Scanner(new File("../../data/a_example.txt"));
			//Scanner sc = new Scanner(new File("../../data/b_read_on.txt"));
			//Scanner sc = new Scanner(new File("../../data/c_incunabula.txt"));
			//Scanner sc = new Scanner(new File("../../data/d_tough_choices.txt"));
			Scanner sc = new Scanner(new File("../../data/e_so_many_books.txt"));
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
				libs[i] = new Library(libBooks, setupTime, booksPerDay, i);
			}
			
			int ind = 0;
			setup = libs[ind++];
			boolean allset = false;
			for(int d = 0; d < nDays; d++) {
				for(Library l : signedLibs) {
					score += l.tick();
				}
				if(!allset && setup.setup()) {
					signedLibs.add(setup);
					if(ind < libs.length) {
						setup = libs[ind++];
					}
					else {
						allset = true;
					}
				}
			}
			
			
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
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void reset() {
		for(Library l : libs) {
			l.reset();
		}
	}

}
