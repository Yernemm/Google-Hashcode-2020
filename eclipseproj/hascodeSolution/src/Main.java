import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static int nDays;
	public static int nBooks;
	public static int nLibs;
	public static int bookScores[];
	public static Library libs[];
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
				libs[i] = Library(libBooks, setupTime, booksPerDay);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
