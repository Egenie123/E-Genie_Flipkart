import java.text.DecimalFormat;

public class Practice {

	public static void main(String[] args) {
		String word = "62.3%";
		float i = Float.parseFloat(word.replaceAll("[^\\d.]", ""));
		if (i >= 2.1 || i <= 2.5) {
			System.out.println(i);
		}

	}

	public String formatValue(float value) {
		String arr[] = { "", "K", "M", "B", "T", "P", "E" };
		int index = 0;
		while ((value / 1000) >= 1) {
			value = value / 1000;
			index++;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return String.format("%s %s", decimalFormat.format(value), arr[index]);
	}

	public String removenumber() {
//		String str = "Hello+-^Java+ -Progr,,,,,,,ammer^ ^^-- ^^^ +!,,,,,,";  
//		str = str.replaceAll("[-+^]*", " ");  
//		//str=str.replaceAll("\\W", " ")    //we can also use this regular expression  
//		System.out.println(str);  

		String phoneNumberstr = "12.23%asd";
		String numberRefined = phoneNumberstr.replaceAll("[^\\d.]", "");
		return numberRefined;
	}

	public void remove() {

		String[] word = { "5.4M", "123.3k" };
		for (int i = 0; i <= word.length - 1; i++) {
			String n = word[i];

			if (n.contains("M")) {

				String w = n.replaceAll("[^\\d.]", "");
				double d = Double.parseDouble(w);
				int k = (int) (d * 1000000);
				System.out.println(k);

			} else if (n.contains("k")) {
				String w = n.replaceAll("[^\\d.]", "");
				double d = Double.parseDouble(w);
				int j = (int) (d * 1000);
				System.out.println(j);
			}
		}
	}

	public void re(int prodData, int FKdata, int persantage) {
//		p
		int num = calculatePercentage(FKdata, persantage);

//			P+E
		int i = (prodData - num);

		if (i >= FKdata) {
			System.out.println("Verification passed successfully   " + i);
		} else {
			System.out.println("Verification Failed data not match ");
		}
	}

	public int calculatePercentage(int inValue, int percent) {

		float percentFloat = (float) percent / 100;
		float outValueFloat = (inValue * percentFloat);
		return Math.round(outValueFloat);
	}

}
