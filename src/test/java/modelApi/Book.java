package modelApi;

public class Book {

    private String name;
    private String title;
    private String author;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "{\"author\": \""+author+"\", \"name\": \""+name+"\", \"title\": \""+title+"\"}";
	}
		
}
