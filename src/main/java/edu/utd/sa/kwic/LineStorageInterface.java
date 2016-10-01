package edu.utd.sa.kwic;

/**
 * Interface for LineStorage since we are following programming by interface design.
 *
 */
public interface LineStorageInterface {

	/**
	 * This function sets the character d at given line-word-character combination
	 * @param line
	 * @param word
	 * @param character
	 * @param d
	 */
	public void setchar(int line, int word, int character, char d);	
	/**
	 * This function accepts lineNumber, wordNumber and characterNumber and returns character present at the given location
	 * @param line
	 * @param word
	 * @param character
	 * @return
	 */
	public char CharAt(int line, int word, int character);
	
	/**
	 * This method Retuns number of words present in line specified.
	 * @param line
	 * @return
	 */
	public int words(int line);
}
