import java.util.Random;

public class CrapsGame {
	CrapsMetricsMonitor CrapsMetricsMonitor = new CrapsMetricsMonitor();
	int rolled = 0;
	
	
	public CrapsGame(CrapsMetricsMonitor monitor){
		
		this.CrapsMetricsMonitor = monitor;
	}
	
	public boolean playGame(){

	
		int rolls = 1;
		CrapsMetricsMonitor.updateGamesPlayed();
		
		Random generator = new Random();

		int current_roll = generator.nextInt(12) +1;
		System.out.println("Your Roll: " + current_roll);
		if (current_roll == 7 || current_roll == 11){
			System.out.println("You Win!");
			CrapsMetricsMonitor.updateNaturalCount();
			CrapsMetricsMonitor.updateGamesWon();
			CrapsMetricsMonitor.updateCurrentWinStreak();
			CrapsMetricsMonitor.compareLosses();
			CrapsMetricsMonitor.clearLosses();
			CrapsMetricsMonitor.rollCompare(rolls);
			
			return true;

		}
		else if (current_roll == 2 || current_roll == 3 ||current_roll == 12){
			System.out.println("You Lose!");
			CrapsMetricsMonitor.updateCrapsCount();
			CrapsMetricsMonitor.updateGamesLost();
			CrapsMetricsMonitor.updateCurrentLoseStreak();
			CrapsMetricsMonitor.compareWins();
			CrapsMetricsMonitor.clearWins();
			CrapsMetricsMonitor.rollCompare(rolls);
			return false;
			
		}
		
		int new_roll = 0; 
		Random generator2 = new Random();
		while(new_roll != current_roll || new_roll != 7){
			
			new_roll = generator2.nextInt(12) +1;
			System.out.println("New role " + new_roll);
			rolls++;
			if(new_roll == current_roll || new_roll == 7){
				break;
			}
		}
		
		
		if(new_roll == current_roll){
			System.out.println("You Win!");
			CrapsMetricsMonitor.updateGamesWon();
			CrapsMetricsMonitor.updateCurrentWinStreak();
			CrapsMetricsMonitor.compareLosses();
			CrapsMetricsMonitor.clearLosses();
			CrapsMetricsMonitor.rollCompare(rolls);
			return true;
		}else{
			System.out.println("You Lose!");
			CrapsMetricsMonitor.updateGamesLost();
			CrapsMetricsMonitor.updateCurrentLoseStreak();
			CrapsMetricsMonitor.compareWins();
			CrapsMetricsMonitor.clearWins();
			CrapsMetricsMonitor.rollCompare(rolls);
			return false;
		}
		
	}
	
}
