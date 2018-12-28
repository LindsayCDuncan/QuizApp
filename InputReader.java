import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
public class InputReader implements Closeable{
	private Scanner scanner;

	public InputReader(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public String readLine() {
		return scanner.nextLine();
	}

	@Override
	public void close() {
		scanner.close();
		
	}
	
	
}
