package edu.utd.sa.kwic;

import java.util.LinkedHashMap;

/**
 * CircularShift Class that provides several methods for providing LineStorage
 * mechanism.
 *
 */
public class CircularShift implements CircularShiftInterface {

	public LinkedHashMap<Integer, LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>> mapOfCircularShifts = new LinkedHashMap<Integer, LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>>();

	/**
	 * This function accepts a line and produces all possible circular shifts
	 * for the same.
	 * 
	 * @param lineStorage
	 * @param line
	 */
	public void setup(LineStorageInterface lineStorage, int line) {
		for (int w = 1; w < (lineStorage.words(line) + 1); w++) {
			int charPos = 1;
			while (lineStorage.CharAt(line, w, charPos) != ' ') {

				char charFound=lineStorage.CharAt(line,
						w, charPos);
				int totalWords=lineStorage.words(line);
				int circularShift = 0;
				while (circularShift < totalWords) {
					
					int tempw = w-circularShift;
					if(tempw<=0)
					{
						tempw=tempw+totalWords;
					}
					setchar(circularShift+1,tempw, charPos,charFound);
					circularShift++;
				}

				charPos++;
			}
		}
	}

	/**
	 * Caused circularShift'th sift's word's, character'th value to be charValue
	 * 
	 * @param circularShift
	 * @param word
	 * @param character
	 * @param charValue
	 */
	public void setchar(int circularShift, int word, int character,
			char charValue) {
		LinkedHashMap<Integer, LinkedHashMap<Integer, Character>> hmWords = mapOfCircularShifts
				.get(circularShift);
		if (hmWords == null || hmWords.size() == 0) {
			hmWords = new LinkedHashMap<Integer, LinkedHashMap<Integer, Character>>();
			mapOfCircularShifts.put(circularShift, hmWords);
		}

		LinkedHashMap<Integer, Character> hmChars = hmWords.get(word);
		if (hmChars == null || hmChars.size() == 0) {
			hmChars = new LinkedHashMap<Integer, Character>();
			hmWords.put(word, hmChars);
		}

		hmChars.put(character, charValue);
	}

	/**
	 * This function returns character'th character in word'th word in
	 * circularShift'th circular shift of the line.
	 * 
	 * @param circularShift
	 * @param word
	 * @param character
	 * @return
	 */
	public char csCharAt(int circularShift, int word, int character) {
		if (mapOfCircularShifts.get(circularShift) != null
				&& mapOfCircularShifts.get(circularShift).get(word) != null
				&& mapOfCircularShifts.get(circularShift).get(word)
						.get(character) != null) {
			return mapOfCircularShifts.get(circularShift).get(word)
					.get(character);
		} else {
			return ' ';
		}
	}

	/**
	 * This function returns number of words in circularShift'th circular shift
	 * 
	 * @param circularShift
	 * @return
	 */
	public int csWords(int circularShift) {
		if (mapOfCircularShifts.get(circularShift) != null) {
			return mapOfCircularShifts.get(circularShift).size();
		} else {
			return 0;
		}
	}
}
