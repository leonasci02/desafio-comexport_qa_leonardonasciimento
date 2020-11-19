package modelApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

public class EstudanteMassa {
	private Faker faker = new Faker(new Locale("pt_BR"));
	private Estudante estudante = new Estudante();
	private static String novoNome;
	
	public void popularEstudanteComLivros() {
		estudante.setName(faker.name().fullName());
		estudante.setEmail(faker.internet().emailAddress());
		estudante.setYears(50);
		estudante.setCpf("99999999999");
		estudante.setBooks(livros());
	}
	
	public void popularEstudanteDadosInvalidos() {
		estudante.setName(faker.name().fullName());
		estudante.setYears(faker.number().numberBetween(10, 90));
		estudante.setCpf("");
		estudante.setBooks(livros());
	}
	
	public String jsonEstudanteComLivros() {
		return estudante.toString();
	}
	
	public String jsonAtualizaEstudante() {
		setNovoNome(faker.name().fullName());
		return "{\n" + 
				"  \"email\": \""+faker.internet().emailAddress()+"\",\n" + 
				"  \"name\": \""+getNovoNome()+"\"\n" + 
				"}";
	}
	
	private List<Book> livros(){
		List<Book> book = new ArrayList<Book>();
		book.add(livro(faker.book().title(), faker.book().title(), faker.book().author()));
		book.add(livro(faker.book().title(), faker.book().title(), faker.book().author()));
		return book;
	}
	
	private Book livro(String nome, String titulo, String autor) {
		Book book = new Book();
		book.setName(nome);
		book.setTitle(titulo);
		book.setAuthor(autor);
		return book;
	}
	
	public static String getNovoNome() {
		return novoNome;
	}
	
	public static void setNovoNome(String novoNome) {
		EstudanteMassa.novoNome = novoNome;
	}
	
}
