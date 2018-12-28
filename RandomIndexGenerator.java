import java.util.*;

public class RandomIndexGenerator {
	
	//generate array of 10 random and unique numbers (0 through 19) to then be used to fetch quiz questions by array index

	
	public RandomIndexGenerator() {

	}
	
	public int randomNumber() {
		
		int max = 20; 
		int randNum = (int)(Math.random() * (max));
		return randNum;
	}

}
