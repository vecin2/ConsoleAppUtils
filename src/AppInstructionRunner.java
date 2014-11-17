package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class AppInstructionRunner {
private InputStream backSystemInputstream;
	private PipedOutputStream runnerSender;
	private PipedInputStream appReceiver;

	public AppInstructionRunner() throws IOException {
		this.backSystemInputstream = System.in;
		this.appReceiver = new PipedInputStream();
		this.runnerSender = new PipedOutputStream(appReceiver);
		System.setIn(appReceiver);
	}

	public void run(String string) throws IOException {
		runnerSender.write((string + "\n").getBytes());
	}

	public void tearDown() {
		System.setIn(backSystemInputstream);
		if (runnerSender != null)
			try {
				runnerSender.close();
				appReceiver.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
