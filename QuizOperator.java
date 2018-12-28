import java.util.ArrayList;
import java.util.List;

public class QuizOperator {
	private final OutputWriter writer;
	private final QuizGenerator quizGenerator;
	private final InputReader reader;
	private RandomIndexGenerator randomIndex;
	private Quiz[] quiz;
    private List<Integer> indicesArray;
    private int numberOfCorrectQuestions = 0;
    private final int TOTAL_NUMBER_OF_QUESTIONS = 10;
	
	public QuizOperator(OutputWriter writer, QuizGenerator quizGenerator, InputReader reader) {
		this.writer = writer;
		this.quizGenerator = quizGenerator;
		this.reader = reader;
		randomIndex = new RandomIndexGenerator();
        indicesArray = new ArrayList<Integer>();
	}
	
	public void start() {
		takeQuiz();
		int quizNum = processSelection();
		loadQuiz(quizNum);
		fillIndicesArray();
		beginQuiz();
		calculateResults();
	}
	
	public void takeQuiz() {
		writer.writeLine("Select a quiz number: \n");
		writer.writeLine("1. Math\n2. History\n3. Science\n4. Languages\n5. Geography\n");
	}
	
	public int processSelection() {
		String quizNumber = reader.readLine();

		try {
			int quizNum = Integer.parseInt(quizNumber);
			if(quizNum < 1 || quizNum > 5) {
				writer.writeLine("Incorrect number value. Random quiz for you!\n");
				return (int)(Math.random() * (5) + 1);
			}
			return quizNum;

		} catch(NumberFormatException e) {
			writer.writeLine("Bad input. You get a random quiz. :)\n");
		}
		return (int)(Math.random() * (5) + 1);		
	}
	
	public void loadQuiz(int n) {
		switch(n) {
		case 1: quiz = quizGenerator.mathGenerator(); break;
		case 2: quiz = quizGenerator.historyGenerator(); break;
		case 3: quiz = quizGenerator.scienceGenerator(); break;
		case 4: quiz = quizGenerator.languagesGenerator(); break;
		default: quiz = quizGenerator.geographyGenerator(); break;
		}
	}

    public void fillIndicesArray() {
        for(int i = 0; i < TOTAL_NUMBER_OF_QUESTIONS; i++) {
            while(true) {
                int randNum = randomIndex.randomNumber();
                if(!indicesArray.contains(randNum)) {
                    indicesArray.add(randNum);
                    break;
                }
            }
        }
    }

    public void beginQuiz(){
		for(int i = 0; i < indicesArray.size(); i++){
			QuestionFactory question = new QuestionFactory(quiz, writer);
			AnswerReceiver answer = new AnswerReceiver(reader, quiz);

			question.printQuestion(indicesArray.get(i));
			answer.inputAnswer();

			if(answer.isGivenAnswerCorrect(indicesArray.get(i))){
				numberOfCorrectQuestions++;
			}
		}
	}

	public void calculateResults(){
		writer.writeLine("You got " + numberOfCorrectQuestions + " correct.\n");
		double percent = ((double)numberOfCorrectQuestions / TOTAL_NUMBER_OF_QUESTIONS) * 100.0;
		writer.writeLine(("That's " + percent + " percent."));
	}
}
