import java.util.Scanner;

public class Application {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int numToEncrypt;
		int numToDecrypt;
				
		//Get input from the user with proper prompt to encrypt
		System.out.print("Input a four digit code to encrypt ");
		numToEncrypt = scanner.nextInt();
		
		//Pass input into Encryptor.encrypt and print it out
		System.out.println(Encrypter.encrypt(numToEncrypt));
		
		//Get input from the user with proper prompt to decrypt
		System.out.print("Input a four digit code to decrypt ");
		numToDecrypt = scanner.nextInt();
		
		//Pass input into Decrypter.decrypt and print it out
		System.out.println(Decrypter.decrypt(numToDecrypt));
		
	}

}
