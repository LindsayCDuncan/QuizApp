import java.util.*;
public class Main {

	public static void main(String[] args) {


		try(Scanner scanner = new Scanner(System.in); InputReader reader = new InputReader(scanner)){
			OutputWriter writer = new OutputWriter();
			QuizGenerator quizGenerator = new QuizGenerator();
			QuizOperator operator = new QuizOperator(writer, quizGenerator, reader);
			operator.start();
		}
		System.exit(0);

	}
}
