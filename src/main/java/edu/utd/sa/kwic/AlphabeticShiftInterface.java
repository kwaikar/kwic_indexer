	package edu.utd.sa.kwic;

import java.util.List;

/**
 * This class is responsible for generating alphabetic shifts of the input.
 */
public interface AlphabeticShiftInterface {

	/**
	 * This function creates alphabetized shifted entries.
	 * @param circularShifts
	 */
	public void alpha(List<CircularShiftInterface> circularShifts);
	/**
	 * This function returns sorted circular shift produced in ith iteration
	 * @param i
	 * @return
	 */
	public String ith(int i);
}
