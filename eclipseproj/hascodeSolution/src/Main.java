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
			for(int i = 0; i < nBooks; i++) {
				bookScores[i] = sc.nextInt();
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
			
			for(int d = 0; d < nDays; d++) {
				for(Library l : signedLibs) {
					score += l.tick();
				}
				if(setup.setup()) {
					signedLibs.add(setup);
					setup = libs[ind++];
				}
			}
			
			System.out.println(signedLibs.size());
			for(Library l : libs) {
				System.out.print(signedLibs.id + " ");
			}
			System.out.println();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
