import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Question {
	private String questionText;
	private String[] options;
  	private int correctAnswerIndex;

    	public Question(String questionText, String[] options, int correctAnswerIndex) {
        	this.questionText = questionText;
        	this.options = options;
        	this.correctAnswerIndex = correctAnswerIndex;
    	}

    	public String getQuestionText() {
        	return questionText;
    	}	

    	public String[] getOptions() {
        	return options;
    	}

    	public boolean isCorrectAnswer(int userChoice) {
        	return userChoice == correctAnswerIndex;
    	}
   
    	public int getCorrectAnswerIndex() {
        	return correctAnswerIndex;
    	}
}

class Quiz {
    	private List<Question> questions;
    	int input;
    	
	public Quiz(List<Question> questions) {
        	this.questions = questions;
    	}

    	public void startQuiz() {
        	int score = 0;
        	
		for (Question question : questions) {
            		System.out.println(question.getQuestionText());
            	
		for (int i = 0; i < question.getOptions().length; i++) {
                	System.out.println((i + 1) + ". " + question.getOptions()[i]);
            	}
            	int userChoice = getValidInput(1, question.getOptions().length);
            	
		if (question.isCorrectAnswer(userChoice - 1)) {
                	System.out.println("Correct!");
                	score++;
            	} else {
                	System.out.println("Incorrect. The correct answer is " + (question.getCorrectAnswerIndex() + 1));
            	}
        }
        	System.out.println("Your score is: " + score + "/" + questions.size());
}

       private int getValidInput(int min, int max) {
    		Scanner scanner = new Scanner(System.in);
    

    	do {
        	System.out.print("Enter your choice: ");
        	try {
            		input = scanner.nextInt();  
            		if(input < min || input > max) {
                		throw new InputMismatchException(); 
            		}
        	} catch (InputMismatchException e) {
            		System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
            		scanner.nextLine();  
        	}
    	} while(input < min || input > max);
    		return input;
	}
}

public class Main {
    	public static void main(String[] args) {
        	List<Question> questions = new ArrayList<>();

        	questions.add(new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Rome"}, 1));
        	questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Earth", "Jupiter", "Mars", "Venus"}, 1));
        	questions.add(new Question("What is the chemical symbol for water?", new String[]{"H20", "CO2", "O2", "N2"}, 0));
		questions.add(new Question("What is the smallest planet in our solar system?", new String[]{"Mercury", "Venus", "Mars", "Pluto"}, 0));
		questions.add(new Question("What is the longest river in the world?", new String[]{"Amazon", "Nile", "Mississippi", "Yangtze"}, 1));
		questions.add(new Question("Who was the first president of the United States?", new String[]{"George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"}, 0));
		questions.add(new Question("Who wrote the novel 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "Mark Twain", "J.K. Rowling", "Jane Austen"}, 0));
		questions.add(new Question("What is the square root of 16?", new String[]{"2", "4", "8", "16"}, 1));
		questions.add(new Question("What is the highest mountain in the world?", new String[]{"Mount Everest", "K2", "Kangchenjunga", "Lhotse"}, 0));
		questions.add(new Question("Which actor has won the most Oscars?", new String[]{"Meryl Streep", "Jack Nicholson", "Daniel Day-Lewis", "Katharine Hepburn"}, 3));

        	Quiz quiz = new Quiz(questions);
        	quiz.startQuiz();
    	}
}

