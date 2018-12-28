
public class QuizGenerator {

	private final String MATH_FILE_NAME = "math.json";
	private final String SCIENCE_FILE_NAME = "science.json";
	private final String HISTORY_FILE_NAME = "history.json";
	private final String LANGUAGES_FILE_NAME = "languages.json";
	private final String GEOGRAPHY_FILE_NAME = "geography.json";
	
	private QuizReaderFromJSON quizReader;
	
	public QuizGenerator() {
		
	}
	
	public Quiz[] scienceGenerator() {
		quizReader = new QuizReaderFromJSON(SCIENCE_FILE_NAME);
		Quiz[] scienceQuiz = quizReader.readQuizFile();
		return scienceQuiz;
	}
	
	public Quiz[] mathGenerator() {
		quizReader = new QuizReaderFromJSON(MATH_FILE_NAME);
		Quiz[] mathQuiz = quizReader.readQuizFile();
		return mathQuiz;
	}
	
	public Quiz[] historyGenerator() {
		quizReader = new QuizReaderFromJSON(HISTORY_FILE_NAME);
		Quiz[] historyQuiz = quizReader.readQuizFile();
		return historyQuiz;
	}
	
	public Quiz[] languagesGenerator() {
		quizReader = new QuizReaderFromJSON(LANGUAGES_FILE_NAME);
		Quiz[] languagesQuiz = quizReader.readQuizFile();
		return languagesQuiz;
	}
	
	public Quiz[] geographyGenerator() {
		quizReader = new QuizReaderFromJSON(GEOGRAPHY_FILE_NAME);
		Quiz[] geographyQuiz = quizReader.readQuizFile();
		return geographyQuiz;
	}
	
	
}
