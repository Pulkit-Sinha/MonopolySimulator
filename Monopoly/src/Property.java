
public class Property extends ThingsToBuy{
	Property(String name, String color, int cost, int rent, int rentOneHouse, int rentTwoHouses, int rentThreeHouses, int rentFourHouses, int rentHotel, int houseCost, int mortgageValue){
		this.name = name;
		this.color = color;
		this.cost = cost;
		this.rent = rent;
		this.rentOneHouse = rentOneHouse;
		this.rentTwoHouses = rentTwoHouses;
		this.rentThreeHouses = rentThreeHouses;
		this.rentFourHouses = rentFourHouses;
		this.rentHotel = rentHotel;
		this.houseCost = houseCost;
		this.mortgageValue = mortgageValue;
	}
	
	String color;
	int rent;
	int rentOneHouse;
	int rentTwoHouses;
	int rentThreeHouses;
	int rentFourHouses;
	int rentHotel;
	int houseCost;
	int mortgageValue;
	boolean mortgaged = false;
	boolean hotel = false;
	int houses = 0;
}
