package exceptions;

public class NavegadorException extends IllegalStateException{

	private static final long serialVersionUID = 1L;

	public NavegadorException(String navegador) {
		super(String.format("Navegador: [%s] parametrizado incorretamente", navegador));
	}
	
}
