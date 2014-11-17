package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunnableConsoleApp implements Runnable {

	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String string = br.readLine();
			while (string != "-1") {
				System.out.println(string);
				string = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
