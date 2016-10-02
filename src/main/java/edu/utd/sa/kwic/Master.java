package edu.utd.sa.kwic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * This class is responsible for managing input, output and calling individual
 * instances of circularShift and alphabetizer.
 */
public class Master {

	/**
	 * Master method for controlling execution flow.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String[] lines = input();
			LineStorageInterface ls = new LineStorage();
			int lineCounter = 1;
			for (String line : lines) {
				int wordCounter = 1;
				for (String word : line.split(" ")) {
					int charCounter = 1;
					for (char character : word.toCharArray()) {
						ls.setchar(lineCounter, wordCounter, charCounter,
								character);
						charCounter++;
					}
					wordCounter++;
				}
				lineCounter++;
			}
			List<CircularShiftInterface> circularShifts = new ArrayList<CircularShiftInterface>();

			for (int i = 1; i <= lines.length; i++) {
				CircularShiftInterface cs = new CircularShift();
				cs.setup(ls, i);
				circularShifts.add(cs);
			}

			AlphabeticShift as = new AlphabeticShift();
			as.alpha(circularShifts);
			output(as);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method accepts input from user.
	 * 
	 * @return
	 * @throws IOException
	 */
	private static String[] input() throws IOException {
		System.out
				.println("Please provide path of file input to be indexed(Please note that individual lines must be separated by ~):");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		File inputFile = new File(input.trim());
		if (!inputFile.exists()) {
			System.out
					.println("Error occured. Please verify that file exists at following input location: |"
							+ input + "|");
			sc.close();
			System.exit(1);
		}

		sc.close();
		String[] lines = FileUtils.readFileToString(inputFile).split("\n");
		return lines;
	}

	/**
	 * This method prints the output.
	 * 
	 * @param as
	 */
	private static void output(AlphabeticShift as) {
		System.out
				.println("\nPlease find alphabetic shifts generated below:\n");
		for (int i = 1; i <= as.asShifts(); i++) {
			System.out.println(as.ith(i));
		}
	}
}
