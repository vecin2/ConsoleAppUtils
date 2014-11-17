package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.AppRunner;
import src.RunnableConsoleApp;

public class TestAppRunner {
	AppRunner appRunner;

	@Before
	public void setup() throws IOException {
		appRunner = new AppRunner(new RunnableConsoleApp());
	}

	@After
	public void tearDown() {
		appRunner.tearDown();
	}

	@Test
	public void test() throws IOException, InterruptedException {
		appRunner.start();
		appRunner.enterInstruction("hola");
		appRunner.hasPrinted("hola");

		appRunner.enterInstruction("adios");
		appRunner.hasPrinted("adios");

		appRunner.enterInstruction("mako");
		appRunner.hasPrinted("mako");
	}
}
