import java.util.ArrayList;
public class Library {
	
	public int[] books;
	public int signup;
	public int scanrate;
	public ArrayList<Integer> scanned;
	private int bookOn;
	public boolean done;
	
	public Library(int[] books, int signup, int scanrate)
	{
		this.books = books;
		this.signup = signup;
		this.scanrate = scanrate;
		this.scanned = new ArrayList<Integer>();
		bookOn = 0;
		done = false;
	}
	
	public int[] tick()
	{
		if(!this.done) {
			for (int i = 0; i < scanrate; i++) {
				if(i + bookOn < books.length) {
					scanned.add(books[i]);
					
				}
				
			}
			
			bookOn += scanrate;
			
			if(bookOn >= books.length -1) {
				done = true;
			}
			
			
		}

		

		
		return scanned;
	}

}
