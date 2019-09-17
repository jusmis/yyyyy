package pl.madejski.model;

public class Book{
	
	private Long bookId;
	private String authorName;
	private String title;
	private int availability;
	
	
	public Book(Long bookId, String authrName, String title, int availability){
		this.bookId = bookId;
		this.authorName = authorName;
		this.title=title;
		this.availability=availability;
	}
	
	public Long getBookId() {
		return bookId;
	}
	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public int getAvailability() {
		return availability;
	}
	
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
}
