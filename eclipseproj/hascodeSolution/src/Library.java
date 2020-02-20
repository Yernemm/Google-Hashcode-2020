import java.util.ArrayList;
public class Library {
	
	public int[] books;
	public int signup;
	public int scanrate;
	public ArrayList<Integer> scanned;
	private int bookOn;
	public boolean done;
	public int id;
	
	public Library(int[] books, int signup, int scanrate, int id)
	{
		this.books = books;
		this.signup = signup;
		this.scanrate = scanrate;
		this.scanned = new ArrayList<Integer>();
		bookOn = 0;
		done = false;
		this.id = id;
	}
	
	/**
	 * Run one day of book scanning. Ignore books already scanned.
	 * @return Score from this day.
	 */
	public int tick()
	{
		int dayScore = 0;
		if(!this.done) {
			int scannedRun = 0;			

			while(scannedRun < scanrate & bookOn < books.length) {
				if(!Main.bookScanned[books[bookOn]]) {
					Main.bookScanned[books[bookOn]] = true;
					dayScore += Main.bookScores[books[bookOn]];
				}
				bookOn++;
			}
			
			if(bookOn >= books.length -1) {
				done = true;
			}
			
			
		}
		return dayScore;
	}

}
