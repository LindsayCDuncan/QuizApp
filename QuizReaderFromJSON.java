import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;

public class QuizReaderFromJSON {
	private final String FILE_NAME;
	
	public QuizReaderFromJSON(String FILE_NAME) {
		this.FILE_NAME = FILE_NAME;
	}

	public Quiz[] readQuizFile() {
		Gson gsonQuiz = new Gson();
		Quiz[] quiz;
		
		try(Reader fileReader = new FileReader(FILE_NAME)){
			quiz = gsonQuiz.fromJson(fileReader, Quiz[].class);
			return quiz;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
