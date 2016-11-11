	package edu.utd.sa.kwic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for generating alphabetic shifts of the input.
 */
public class AlphabeticShift implements AlphabeticShiftInterface{

	List<String> alphabetizedLines= new ArrayList<String>();
	/**
	 * This function creates alphabetized shifted entries.
	 * @param circularShifts
	 */
	public void alpha(List<String> circularShifts)
	{

			alphabetizedLines.addAll( circularShifts);
		Collections.sort(alphabetizedLines);
	}
	/**
	 * This method returns list of unsorted circular shifts.
	 * @param circularShifts
	 * @return
	 */

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
	
	/**
	 * This method returns number of shifts available
	 * @return
	 */
	public int asShifts()
	{
		if(alphabetizedLines!=null)
		{
			return alphabetizedLines.size();
		}
		return 0;
	}
}
