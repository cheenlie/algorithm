package cn.cheenlie.compress;

public class compressTest {

	public static void main(String args[]) {

		// char a[10]={'a','b','c','d','x'};
		char[] inputstr = new char[] { 'c', 'a', 'a', 'f', 'f', 'f', 'f', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f' ,'g','g','g','g','g','g','g','g','g','g','g','g'};
		int n = inputstr.length;
		char[] outputStr = new char[n];
		stringZip(inputstr, n, outputStr);

		for (int i = 0; i < n; i++) {
			System.out.println(outputStr[i]);
		}
	}

	public static void stringZip(char[] inputStr, long lInputLen,
			char[] outputStr) {
		int count = 0;
		int outputlength = 0;
		char temp = inputStr[0];
		int bitNum = 0;

		for (int i = 0; i < lInputLen; i++) {

			if (inputStr[i] == temp && i < lInputLen - 1) {
				count++;
			} else {

				if (inputStr[i] == temp) {
					count++;
				}

				int counttemp = count;
				if (counttemp > 10) {
					while (counttemp >= 1) {
						counttemp = counttemp / 10;
						bitNum++;
					}

					// int to char
					for (int j = 0; j < bitNum; j++) {
						String str = String.valueOf(count);
						char cha = str.charAt(j);
						outputStr[outputlength++] = cha;
					}
					bitNum=0;
				}else {
					String str = String.valueOf(count);
					char cha = str.charAt(0);
					outputStr[outputlength++] = cha;
				}
				
				outputStr[outputlength++] = temp;
				temp = inputStr[i];
				count = 1;
			}
		}
	}
}
