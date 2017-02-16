
import java.util.Scanner;

public class CrapsSimulation {
	
	private String user_name;
	private int balance;
	private int user_bet;
	private int win_streak;
	private int lose_streak;
	
	
	
	public CrapsSimulation(){
		user_name = "test";
		balance = 0;
		user_bet = 0;
		
		CrapsMetricsMonitor CrapsMetricsMonitor = new CrapsMetricsMonitor();
		CrapsGame CrapsGame = new CrapsGame(CrapsMetricsMonitor);
		
		start();
		
	}
	public void start(){

		boolean play_again = true;
		
		CrapsMetricsMonitor monitor = new CrapsMetricsMonitor();
	    CrapsGame game = new CrapsGame(monitor);
	    
		while(play_again){
			//monitor.reset();

			
		    System.out.println(" Welcome to SimCraps! Enter your username: ");
		    Scanner user_input = new Scanner(System.in);
		    user_name = user_input.next();
	
		    System.out.println("Hello "+user_name + "!" );
		    
		    
		    System.out.println("Enter the amount of money you will bring to the table: ");
		    balance = user_input.nextInt();
		    monitor.updateCurrentBalance(balance);
		    monitor.compareBalance();
		    
		    while(balance > 0){
		    
			    System.out.println("Enter the bet amount between $1 and $" +  balance +":");
			    user_bet = user_input.nextInt();
	
			    if(user_bet < 1 || user_bet > balance){
			    	System.out.println("Invalid bet! Enter the bet amount between $1 and $" +  balance +":");
				    user_bet = user_input.nextInt();
			    }
	
			    
			    boolean result = game.playGame();
			    if(result){
			    	monitor.updateCurrentBalance(user_bet);
			    	balance = monitor.getCurrentBalance();
			    	monitor.compareBalance();
			    }else{
			    	monitor.updateCurrentBalance(-user_bet);
			    	balance = monitor.getCurrentBalance();
			    	
			    }
		    }
		    monitor.compareLosses();	
		    monitor.compareWins();
		    
		    monitor.printStatistics();

		    System.out.println("Replay? Enter 'y' or 'n': ");
		    char response = user_input.next().charAt(0);
		    while(response != 'y'|| response !='n'){
		    	System.out.println("Invalid Answer (Please Enter 'y' or 'n'): ");
		    	response = user_input.next().charAt(0);
		    	if(response == 'y' || response == 'n'){
		    		break;
		    	}
			    
		    }
		    if(response == 'n'){
		    	play_again = false;
		    	monitor.reset();
		    }else{
		    	monitor.reset();
		    }
		    
		}
	}
}

