package edu.utd.sa.kwic;

import java.util.LinkedHashMap;


/**
 * LineStorage Class that provides several methods for providing LineStorage
 * mechanism.
 *
 */
public class LineStorage implements LineStorageInterface {


	LinkedHashMap<Integer, LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>> mapOfLines = new LinkedHashMap<Integer, LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>>();

	/**
	 * This function sets the character d at given line-word-character
	 * combination
	 * 
	 * @param line
	 * @param word
	 * @param character
	 * @param d
	 */
	public void setchar(int line, int word, int character, char charValue) {
		LinkedHashMap<Integer, LinkedHashMap<Integer, Character>> hmWords = mapOfLines
				.get(line);
		if (hmWords == null || hmWords.size() == 0) {
			hmWords = new LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>();
			mapOfLines.put(line, hmWords);
		}

		LinkedHashMap<Integer, Character> hmChars = hmWords.get(word);
		if (hmChars == null || hmChars.size() == 0) {
			hmChars = new LinkedHashMap<Integer, Character>();
			hmWords.put(word, hmChars);
		}

		hmChars.put(character, charValue);
	}

	/**
	 * This function accepts lineNumber, wordNumber and characterNumber and
	 * returns character present at the given location
	 * 
	 * @param line
	 * @param word
	 * @param character
	 * @return
	 */
	public char CharAt(int line, int word, int character) {
		if (mapOfLines.get(line) != null
				&& mapOfLines.get(line).get(word) != null
				&& mapOfLines.get(line).get(word).get(character) != null) {
			return mapOfLines.get(line).get(word).get(character);
		} else {
			return ' ';
		}
	}

	/**
	 * This method Retuns number of words present in line specified.
	 * 
	 * @param line
	 * @return
	 */
	public int words(int line) {
		if (mapOfLines.get(line) != null) {
			return mapOfLines.get(line).size();
		} else {
			return 0;
		}
	}
}
