package interfaz;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * Clase que contiene algunos métodos útiles para ahorrar código y tiempo. Además estas funciones son seguras y previene errores.
 * Esta clase ha sido creada por Jonathan Villena y ha reutilizado parte del código proporcionado por Javi.
 * También se ha utilizado código proporcionado por ChatGPT.
 */

public class UtilsJV {
	// - - - ZONA: LECTURA CONSOLA - - - \\
	// Método que inicializa el lector del teclado
	static String initializeKeyboardReader() {
		String buzon="";
		InputStreamReader flujo=new InputStreamReader(System.in);
		BufferedReader teclado=new BufferedReader(flujo);
		try{
			buzon=teclado.readLine();
		} catch (Exception e) {
			System.out.append("Entrada incorrecta");
		}
		return buzon;
	}
	
	
	// Método para solicitar un entero
	static int promptForInteger(String promptMessage_) {
		boolean valorValido = false;
		int valor = 0;
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=Integer.parseInt(initializeKeyboardReader());
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un valor numérico");
			}
		}
		return valor;
	}
	
	
	// Método para solicitar un entero que esté dentro de un rango
	static int promptForIntegerInRange(String promptMessage_, int minValue_, int maxValue_) {
		boolean valorValido = false;
		int valor = 0;
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=Integer.parseInt(initializeKeyboardReader());
				if (valor < minValue_ || valor > maxValue_) {
					System.out.println("Valor inválido: Debes introducir un número entre "+minValue_+" y "+maxValue_);
				} else {
					valorValido=true;
				}
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un valor numérico");
			}
		}
		return valor;
	}
	
	
	// Método para solicitar un double (decimal)
	static double promptForDouble(String promptMessage_) {
		boolean valorValido = false;
		double valor = 0;
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=Double.parseDouble(initializeKeyboardReader());
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un valor numérico");
			}
		}
		return valor;
	}
	
	
	// Método para solicitar una cadena
	static String promptForString(String promptMessage_) {
		boolean valorValido = false;
		String valor = "";
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=initializeKeyboardReader();
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un valor de texto");
			}
		}
		return valor;
	}
	
	
	// Método para solicitar un booleano
	static boolean promptForBoolean(String promptMessage_) {
		boolean valorValido = false;
		String valor = "";
		boolean valorReturn = false;
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=initializeKeyboardReader().toLowerCase();
				if (valor.equals("s") || valor.equals("si") || valor.equals("sí") || valor.equals("y") || valor.equals("yes") || valor.equals("t") || valor.equals("true") || valor.equals("1")) {
					valorReturn = true;
					valorValido = true;
				} else if (valor.equals("n") || valor.equals("no") || valor.equals("f") || valor.equals("false") || valor.equals("0")) {
					valorValido = true;
					valorReturn = false;
				} else {
					System.out.println("Valor inválido: Responde con 's' o 'n'");
				}
			} catch (Exception e) {
				System.out.println("Valor inválido: Responde con 's' o 'n'");
			}
		}
		return valorReturn;
	}
	
	
	// Método para solicitar un carácter
	static char promptForCharacter(String promptMessage_) {
		boolean valorValido = false;
		String valor = "";
		
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=initializeKeyboardReader();
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un carácter");
			}
		}
		return valor.charAt(0);
	}
	
	
	// Método para solicitar una fecha válida
	static String promptForDateString(String promptMessage_, String dateFormat_) {
		boolean valorValido = false;
		String valor = "";
		
		// Definimos el formato del String
		SimpleDateFormat formatoFecha = new SimpleDateFormat(dateFormat_);
        formatoFecha.setLenient(false);
        
		while (valorValido==false) {
			System.out.print(promptMessage_);
			try {
				valor=initializeKeyboardReader();
				try {
					@SuppressWarnings("unused")
					Date dateFechaNacimiento = formatoFecha.parse(valor);
					valorValido=true;
				} catch (ParseException ex) {
					System.out.println("Valor inválido: Debes introducir una fecha con el formato '"+dateFormat_+"'");
				}
			} catch (Exception e) {
				System.out.println("Valor inválido: Introduce un valor de texto");
			}
		}
		return valor;
	}
	
	
	// Método para solicitar una cadena que cumpla una expresión regular
	static String promptForStringMatchingRegex(String promptMessage_, String regexPattern_, String example_) {
		boolean valorValido = false;
		String valorIntroducido = "";
		
		// Se crea el objeto de la expresión regular
		Pattern pattern = Pattern.compile(regexPattern_);
		
		// Bucle que se itera mientras el valor no cumpla con la expresión regular
		while (valorValido==false) {
			// Obtenemos la cadena
			valorIntroducido = promptForString(promptMessage_);
			
			try {
				Matcher match = pattern.matcher(valorIntroducido);
				if (match.matches()) {
					valorValido=true;
				} else {
					System.out.println("Valor inválido: El valor debe cumplir con el formato requerido (Ejemplo: '"+example_+"')");
				}
			} catch (Exception e) {
				System.out.println("Valor inválido: El valor debe cumplir con el formato requerido (Ejemplo: '"+example_+"')");
			}
		}
		
		return valorIntroducido;
	}
	
	
	
	
	
	// - - - ZONA: GENERACIÓN NÚMEROS - - - \\
	// Método para generar un número entero entre 2 números (incluidos)
	static int generateRandomIntegerInRange(int minNumber_, int maxNumber_) {
		Random rand = new Random();
		int randomNum = rand.nextInt((maxNumber_ - minNumber_) + 1) + minNumber_;
		return randomNum;
	}
	

	// - - - ZONA: BORRADO CONSOLA - - - \\
	// Método para borrar la consola (se hacen 50 saltos de linea)
	public static void clearConsole() {
		for (int i=1; i<=50; i++) {
			System.out.println("");
		}
		return;
	}
	

	// - - - ZONA: ESPERA PROGRAMA - - - \\
	// Método para generar una espera de X milisegundos
	public static void sleepForMilliseconds(int milliseconds_) {
		milliseconds_ = 0;
		try {
			Thread.sleep(milliseconds_);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	// - - - ZONA: ESPERA INTERACCIÓN - - - \\
	// Método para generar una espera de X milisegundos
	public static void waitForInteraction(String promptMessage_) {
		System.out.println(promptMessage_);
		initializeKeyboardReader();
	}
}