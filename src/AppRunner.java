package src;

import java.io.IOException;

public class AppRunner {
	private AppOutputChecker appOutputchecker;
	private AppInstructionRunner appInstructionRunner;
	private Thread receiverThread;
	private Runnable runnableApp;

	public AppRunner(Runnable runnableConsoleApp) throws IOException {
		this.runnableApp = runnableConsoleApp;
		this.appOutputchecker = new AppOutputChecker();
		this.appInstructionRunner = new AppInstructionRunner();
	}

	public void enterInstruction(String string) throws IOException {
		appInstructionRunner.run(string);
	}

	public void tearDown() {
		appOutputchecker.tearDown();
		appInstructionRunner.tearDown();
	}

	public void start() {
		receiverThread = new Thread(runnableApp);
		receiverThread.start();
	}

	public void hasPrinted(String string) {
		appOutputchecker.hasPrinted(string);
	}

}
