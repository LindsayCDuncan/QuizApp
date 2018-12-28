
public class Quiz {
	private final String QUESTION;
	private final String ANSWER;
	
	public Quiz(String question, String answer) {
		this.QUESTION = question;
		this.ANSWER = answer;
	}
	
	public String getQuestion() {
		return this.QUESTION;
	}
	
	public String getAnswer() {
		return this.ANSWER;
	}

}
