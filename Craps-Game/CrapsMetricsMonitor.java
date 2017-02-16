import java.util.Random;
import java.util.Scanner;
public class CrapsMetricsMonitor
{	
	int initial_balance = 0;
	
	int games_played = 0;
	int games_won = 0;
	int games_lost = 0;
	int max_rolls = 0;
	int natural_count = 0;
	int craps_count = 0;
	int max_w_streak = 0;
	int max_l_streak = 0;
	int max_balance = 0;
	int current_w_streak = 0;
	int current_l_streak = 0;
	int current_balance = 0;
	
	public void updateInitialBalance(int balance){
		initial_balance = balance;
	}
	
	public int getInitialBalance(){
		return initial_balance;
	}
	
	public void updateGamesPlayed(){
		games_played++;
	}
	public void updateGamesWon(){
		games_won++;
	}
	public void updateGamesLost(){
		games_lost++;
	}

	public void updateNaturalCount(){
		natural_count++;
	}
	public void updateCrapsCount(){
		craps_count++;
	}
	public void updateMaxWStreak(){
		max_w_streak++;
	}
	public void updateMaxLStreak(){
		max_l_streak++;
	}
	public void updateMaxBalace(int balance){
		max_balance+=balance;
	}
	public void rollCompare(int rolls){
		if(rolls > max_rolls){
			max_rolls = rolls;
		}
	}
	
	public void updateCurrentWinStreak(){
		current_w_streak++;
	}
	public void updateCurrentLoseStreak(){
		current_l_streak++;
	}
	public void updateCurrentBalance(int bet){
		current_balance+= bet;
	}
	public int getCurrentBalance(){
		return current_balance;
	}
	
	public void compareLosses(){
		if(current_l_streak > max_l_streak){
			max_l_streak = current_l_streak;
		}
	}
	public void compareWins(){
		if(current_w_streak > max_w_streak){
			max_w_streak = current_w_streak;
		}
	}
	public void compareBalance(){
		if(current_balance > max_balance){
			max_balance = current_balance;
		}
	}
	public void clearWins(){
		current_w_streak = 0;
	}
	public void clearLosses(){
		current_l_streak = 0;
	}
	public void clearBalance(){
		current_balance = 0;
	}
	
	
	
	//int current_w_streak = 0;
	//int current_l_streak = 0;
	//int current_balance = 0;
	
	
	public void printStatistics(){
		
		System.out.println("*************************************"
			+ "SIMULATION STATISTICS**************************");
		System.out.println("Games played: " + games_played);
		System.out.println("Games won: " + games_won);
		System.out.println("Games lost: " + games_lost);
		System.out.println("Maximum Rolls in a single game: " + max_rolls);
		System.out.println("Natural count: " + natural_count);
		System.out.println("Craps Count: " + craps_count);
		System.out.println("Maximum Winning Streak: " + max_w_streak);
		System.out.println("Maximum Losing Streak: "+ max_l_streak);
		System.out.println("Maximum balance: " + max_balance);
		
	}
	
	
	public void reset(){
		games_played=0;
		games_won=0;
		games_lost=0;
		max_rolls=0;
		natural_count=0;
		craps_count=0;
		max_w_streak=0;
		max_l_streak=0;
		max_balance=0;
		
	}
}
	
	
	
