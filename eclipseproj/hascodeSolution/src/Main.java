import java.io.File;
import java.io.FileNotFoundException;
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
			Scanner sc = new Scanner(new File("../../data/a_example.txt"));
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
			
			
			
			System.out.println(signedLibs.size());
			for(Library l : libs) {
				System.out.println(l.id + " " + l.scanned.size());
				for(int i : l.scanned) {
					System.out.print(i + " ");
				}
				System.out.println();
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
