package by.htp.liblary.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pat="\\d{7}";
		String str="2222222";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}

}
