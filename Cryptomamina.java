import java.io.FileWriter;
import java.util.Scanner;


public class Cryptomamina {

	public static String cryptage(String message, String cle)
	{
		StringBuffer conversion = new StringBuffer(message);
		
		for(int i = 0; i < message.length(); i++)// 
		{
			// Décalage
			int decalage = (int)cle.charAt(i % cle.length()) - 97;
			int LettreCrypter = ((int)message.charAt(i) - 97 + decalage) % 26 + 97;
			conversion.setCharAt(i, (char)LettreCrypter);
		}
		
		message = conversion.toString();
		return message;
	}
	
	
	public static void main(String[] args) {
		// Déclaration des variables
		String message;
		String cle;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("// ** Vigenere Par Foucaud Giovanny ** \\");
		System.out.println("// ** 							    ** \\");
		System.out.println("// ** 							    ** \\");
		
		System.out.println("Entrée votre message : ");
		message = sc.nextLine();
		
		System.out.println("Entrée votre cle de cryptage : ");
		cle = sc.nextLine();
		
		try{
			FileWriter fichierTXT = new FileWriter("texteChiffre.txt");
			fichierTXT.write("Résultat : " + cryptage(message,cle));
			fichierTXT.close();
		}catch(Exception e){
			System.out.println("Le Cryptage à échoué ! L'écriture dans le fichier impossible");
		}
		
	}
	
}
