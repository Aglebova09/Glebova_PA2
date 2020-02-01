import java.util.ArrayList;
import java.util.List;

public class Encrypter {

	public static String encrypt(int num)
	{
		int count = 4;  //Keeping this a static because we know that only 4 digits will be entered

		int[] numArray = new int[count];
		int[] correctOrderNum = new int[count];
		int[] encryptedNum = new int[count];
		
		String strNum;
		
		for (int i = 0; i < count; i++)
		{
			numArray[i] *= 10;
	        numArray[i] += num % 10;
	        num /= 10;
		}
		
		//The for loop makes the non-encrypted message into a loop backwards, this fixes it
		correctOrderNum[0] = numArray[3];
		correctOrderNum[1] = numArray[2];
		correctOrderNum[2] = numArray[1];
		correctOrderNum[3] = numArray[0];
		
		//Actual encryption occurs
		for (int i = 0; i < count; i++)
		{
			encryptedNum[i] = (correctOrderNum[i] + 7) % 10;
			correctOrderNum[i] = encryptedNum[i];
		}
		
		encryptedNum[0] = correctOrderNum[2];
		encryptedNum[2] = correctOrderNum[0];
		encryptedNum[1] = correctOrderNum[3];
		encryptedNum[3] = correctOrderNum[1];

		//Concatenates the encrypted values in the array
		strNum = "" + encryptedNum[0] + encryptedNum[1] + encryptedNum[2] + encryptedNum[3];
			
		return strNum;
	}
	
	

}
