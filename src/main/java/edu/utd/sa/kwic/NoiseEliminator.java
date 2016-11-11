package edu.utd.sa.kwic;

import java.util.LinkedList;
import java.util.List;

public class NoiseEliminator {

	String[] noiseWords = { "a", "of", "the", "in", "then", "and", "how", "When", "where" ,"what"};

	public List<String> getNoiseLessShifts(List<String> inputList) {
		List<String> noiseLessShifts = new LinkedList<String>();
		for (String shift : inputList) {
			boolean flag = false;
			for (String noiseWord : noiseWords) {
				if (shift.toLowerCase().startsWith(noiseWord.toLowerCase())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				noiseLessShifts.add(shift);

			}
		}
		return noiseLessShifts;
	}

}
