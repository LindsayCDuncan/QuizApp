public class AnswerReceiver {
    private final InputReader reader;
    private Quiz[] quiz;
    private String answerGiven;

    public AnswerReceiver(InputReader reader, Quiz[] quiz){
        this.reader = reader;
        this.quiz = quiz;
    }

    public void inputAnswer(){
        answerGiven = reader.readLine();
    }

    public boolean isGivenAnswerCorrect(int questionIndex){
        String correctAnswer = quiz[questionIndex].getAnswer();
        return correctAnswer.equalsIgnoreCase(answerGiven);
    }

}
