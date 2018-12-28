import java.util.List;

public class QuestionFactory {
    private Quiz[] quiz;
    private final OutputWriter writer;


    public QuestionFactory(Quiz[] quiz, OutputWriter writer){
        this.quiz = quiz;
        this.writer = writer;
    }

    public void printQuestion(int questionIndex){
        writer.writeLine(quiz[questionIndex].getQuestion() + "\n");
    }

}
