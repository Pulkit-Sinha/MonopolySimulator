import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Player extends Thread{
	String id;
	int multithreadFlag;
	int money = 1500;
	int position = 0;
	boolean bankruptcy = false;
	int railroadsOwned = 0;
	int utilitiesOwned = 0;
	int brownOwned = 0;
	int tealOwned = 0;
	int pinkOwned = 0;
	int orangeOwned = 0;
	int redOwned = 0;
	int yellowOwned = 0;
	int greenOwned = 0;
	int blueOwned = 0;
	int blueFlag = 0;
	int brownFlag = 0;
	int tealFlag = 0;
	int pinkFlag = 0;
	int orangeFlag = 0;
	int redFlag = 0;
	int yellowFlag = 0;
	int greenFlag = 0;
	int getOutOfJailFreeCards = 0;
	List<Property> properties = new ArrayList<Property>();
	List<Utility> utilities = new ArrayList<Utility>();
	List<Railroad> railroads = new ArrayList<Railroad>();
	Player(String id){
		this.id=id;
	}
	
	public void run() {
		int dice=(int)(Math.random()*6+1);
		System.out.println(this.id+" rolled "+dice);
		this.position+=dice;
		if(this.position>39) {
			this.money+=200;
			this.position = (this.position%39)-1;
			System.out.println(this.id+" passed GO and collected $200");
		}
		multithreadFlag = 1;
	}
}
