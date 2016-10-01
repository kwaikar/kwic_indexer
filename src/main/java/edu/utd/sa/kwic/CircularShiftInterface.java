package edu.utd.sa.kwic;


/**
 * CircularShift Class that provides several methods for providing LineStorage
 * mechanism.
 *
 */
public interface CircularShiftInterface {


	/**
	 * This function accepts a line and produces all possible circular shifts
	 * for the same.
	 * 
	 * @param lineStorage
	 * @param line
	 */
	public void setup(LineStorageInterface lineStorage, int line) ;
	/**
	 * Caused circularShift'th sift's word's, character'th value to be charValue
	 * 
	 * @param circularShift
	 * @param word
	 * @param character
	 * @param charValue
	 */
	public void setchar(int circularShift, int word, int character,
			char charValue) ;
	/**
	 * This function returns character'th character in word'th word in
	 * circularShift'th circular shift of the line.
	 * 
	 * @param circularShift
	 * @param word
	 * @param character
	 * @return
	 */
	public char csCharAt(int circularShift, int word, int character) ;

	/**
	 * This function returns number of words in circularShift'th circular shift
	 * 
	 * @param circularShift
	 * @return
	 */
	public int csWords(int circularShift) ;
}
