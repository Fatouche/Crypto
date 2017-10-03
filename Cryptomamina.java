import java.io.*;


public class Cryptomamina {

	public static boolean estMinuscule(char c){
		
		if( c >= 'a' && c <= 'z'){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean estMajuscule(char c){
		
		if( c >= 'A' && c <= 'Z'){
			return true;
		}else{
			return false;
		}
	}
	

	public static int tailleCle(String text){
		int tailleMax = 15;
		int tailleCleMax;
		char alphabet;
		
		for(int i = 1; i< tailleMax;i++){
			
			
			
		}
		
		return 0;
	}
		
	public static String cryptage(String message, String cle)
	{
		char c;
		char key;
		String textCrypt = "";
		
		for (int i=0;i< message.length();i++){
			
			c = message.charAt(i);
			
			if(estMajuscule(c) == true){
				cle = cle.toUpperCase();
				key = cle.charAt(i % cle.length());
				textCrypt += (char)(((c + key)) %26 + 65);
			}
			
			if(estMinuscule(c) == true){
				cle = cle.toLowerCase();
				key = cle.charAt(i % cle.length());
				textCrypt += (char)((((c + key)) %97 ) %26 + 97);
			}
		}
		
		return textCrypt;
		
	}
	
	public static String decryptage(String message, String cle){
		String textDecrypt = "";
		char c;
		char key;
		
		for (int i=0;i< message.length();i++){
			
			c = message.charAt(i);
			
			if(estMajuscule(c) == true){
				cle = cle.toUpperCase();
				key = cle.charAt(i % cle.length());
				textDecrypt += (char)(((c - key + 26 )) %26 + 65);
			}
			
			if(estMinuscule(c) == true){
				cle = cle.toLowerCase();
				key = cle.charAt(i % cle.length());
				textDecrypt += (char)((((c - key + 26 )) %97 ) %26 + 97);
			}
		}
		
		return textDecrypt;
	}
	
	public static String Cryptanalyse(String messageCrypte){
		String messageClaire = "";
		
		
		return messageClaire;
	}
	
	public static void main(String[] args) {
		// Déclaration des variables
		String message;
		String cle;
		
		if(args[0].equals("-c")){
		
			try{
				FileWriter fichierTXT = new FileWriter("texteChiffre.txt");
				fichierTXT.write("Résultat : " + cryptage(args[1],args[2]));
				fichierTXT.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Le Cryptage à échoué ! L'écriture dans le fichier impossible");
			}
		}
		
		if(args[0].equals("-d")){
			
			try{
				FileWriter fichierTXT = new FileWriter("texteClaire.txt");
				fichierTXT.write("Résultat : " + decryptage(args[1],args[2]));
				fichierTXT.close();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Le Decryptage à échoué ! L'écriture dans le fichier impossible");
			}
		}
		
		if(args[0].equals("-tc")){
			
			InputStream flux;
			
			try {
				flux = new FileInputStream("" + args[1]);
				InputStreamReader lecture = new InputStreamReader(flux);
				BufferedReader buff = new BufferedReader(lecture);
				String texte = buff.readLine();
				
				tailleCle(texte);
				
				buff.close();
			}catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	}
	
}
