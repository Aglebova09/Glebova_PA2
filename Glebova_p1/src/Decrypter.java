
public class Decrypter {

	public static String decrypt(int num)
	{
		int count = 4;  //Keeping this a static because we know that only 4 digits will be entered

		int[] numArray = new int[count];
		int[] reorderedNum = new int[count];
		int[] correctOrderNum = new int[count];
		int[] decryptedNum = new int[count];
		
		String strNum;
		
		for (int i = 0; i < count; i++)
		{
			numArray[i] *= 10;
	        numArray[i] += num % 10;
	        num /= 10;
		}
		
		//The for loop makes the non-encrypted message into a loop backwards, this fixes it
		reorderedNum[0] = numArray[3];
		reorderedNum[1] = numArray[2];
		reorderedNum[2] = numArray[1];
		reorderedNum[3] = numArray[0];
		
		//Places the number back in order from being encrypted
		correctOrderNum[0] = reorderedNum[2];
		correctOrderNum[2] = reorderedNum[0];
		correctOrderNum[1] = reorderedNum[3];
		correctOrderNum[3] = reorderedNum[1];
		
		//Actual decryption occurs
		for (int i = 0; i < count; i++)
		{
			decryptedNum[i] = (correctOrderNum[i]- 7 +10)%10;
		}
		
		strNum = "" + decryptedNum[0] + decryptedNum[1] + decryptedNum[2] + decryptedNum[3];
		
		return strNum;
	}

}
