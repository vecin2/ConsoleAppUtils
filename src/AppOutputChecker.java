package src;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppOutputChecker {
	private int lineIndex = 0;
	ByteArrayOutputStream applicationOutput;
	PrintStream backupSystemOut;

	public AppOutputChecker() {
		this.applicationOutput = new ByteArrayOutputStream();
		backupSystemOut = System.out;
		System.setOut(new PrintStream(applicationOutput));
	}

	public void hasPrinted(String string) {
		assertEquals(string, readOutputLine());
	}

	public String readOutputLine() {
		String result = null;
		try {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(100 * i);
				result = parseLine();
				if (result != null) {
					lineIndex++;
					return result;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}

	private String parseLine() {
		String result = applicationOutput.toString();
		if (result != null) {
			if (result.split("\n").length > lineIndex) {
				return result.split("\n")[lineIndex];
			}
		}
		return null;
	}

	public void tearDown() {
		System.setOut(backupSystemOut);
	}
}
