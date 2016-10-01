	package edu.utd.sa.kwic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for generating alphabetic shifts of the input.
 */
public class AlphabeticShift {

	List<String> alphabetizedLines= new ArrayList<String>();
	/**
	 * This function creates alphabetized shifted entries.
	 * @param circularShifts
	 */
	public void alpha(List<CircularShiftInterface> circularShifts)
	{
		for (CircularShiftInterface csInt : circularShifts) {

			for (int s=1;s<=csInt.csShifts();s++) {
			
				StringBuilder line = new StringBuilder();
				for (int w = 1; w <= csInt.csWords(s); w++) {
					int charPos=1;
					while (csInt.csCharAt(s, w, charPos) != ' ') {
						line.append(csInt.csCharAt(s, w, charPos));
						charPos++;
					}
					line.append(" ");
				}
				alphabetizedLines.add(line.toString());
				
			}
		}
		Collections.sort(alphabetizedLines);
		System.out.println(alphabetizedLines);
	}
	/**
	 * This function returns sorted circular shift produced in ith iteration
	 * @param i
	 * @return
	 */
	public String ith(int i){
		if(alphabetizedLines!=null)
		{
			return alphabetizedLines.get(i-1);
		}
		return null;
	}
}
