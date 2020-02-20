import java.util.ArrayList;
public class Library {
	
	public int[] books;
	public int signup;
	public int scanrate;
	public int scorePotential;
	
	public ArrayList<Integer> scanned = new ArrayList<Integer>();
	private int bookOn;
	public boolean done;
	public int id;
	public int signupCountdown;
	
	public Library(int[] books, int signup, int scanrate, int id)
	{
		this.books = books;
		this.signup = signup;
		this.scanrate = scanrate;
		this.id = id;
		
		for(int bookId : this.books) {
			this.scorePotential += Main.bookScores[bookId];
		}
		
		reset();
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
					scanned.add(books[bookOn]);
				}
				bookOn++;
			}
			
			if(bookOn >= books.length -1) {
				done = true;
			}
			
			
		}
		return dayScore;
	}
	
	public boolean setup()
	{
		if(signupCountdown > 1) {
			signupCountdown--;
			return false;
		}else {
			return true;
		}
	}
	
	public void reset()
	{
		this.scanned = new ArrayList<Integer>();
		bookOn = 0;
		done = false;
		signupCountdown = signup;
		
	}
	
	
}


