import java.util.ArrayList;
import java.util.List;

public class Player {
	String id;
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
	int getOutOfJailFreeCards = 0;
	List<Property> properties = new ArrayList<Property>();
	Player(String id){
		this.id=id;
	}
}
