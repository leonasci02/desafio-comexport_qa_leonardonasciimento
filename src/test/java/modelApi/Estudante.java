package modelApi;

import java.util.List;

public class Estudante {
	private String name;
    private String email;
    private int years;
    private String cpf;
    private List<Book> books;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "{\"books\": "+books+" ,"+"\"cpf\": \""+cpf+"\", \"email\": \""+email+"\", \"name\": \""+name+"\", \"email\": \""+email+"\"}";
	}
}
