import java.util.Scanner;

public class Board {
	
	static int cardOnTop = 0;
	
	static void communityChest(Player player) {
		switch(cardOnTop) {
			
		case 0: player.position = 0;
		player.money+=200;
		System.out.println("Player went to GO and collected $200.");
		break;
			
		case 1: player.money+=200;
		System.out.println("Bank error in player's favor. Player collects $200.");
		break;
			
		case 2: player.money-=50;
		System.out.println("Player pays $50 as doctor's fee.");
		break;
			
		case 3: player.money+=50;
		System.out.println("Player sold stock for $50.");
		break;
			
		case 4: player.getOutOfJailFreeCards++;
		System.out.println("Player gets a Get Out Of Jail Free card.");
		break;
			
		case 5: goToJail(player);
		break;
			
		case 6: player.money+=100;
		System.out.println("Player's holiday fund matures. Player receives $100.");
		break;
			
		case 7: player.money+=20;
		System.out.println("Player receives income tax refund. Player collects $20.");
		break;
			
		case 8: player.money+=100;
		System.out.println("Player's life insurance matures. Player collects $100.");
		break;
			
		case 9: player.money-=100;
		System.out.println("Player pays hospital fees of $100.");
		break;
			
		case 10: player.money-=50;
		System.out.println("Player pays school fees of $50.");
		break;
			
		case 11: player.money+=25;
		System.out.println("Player receives consultancy fees of $25.");
		break;
			
		case 12: player.money+=10;
		System.out.println("Player comes second in beauty pageant and wins $10.");
		break;
			
		case 13: player.money+=100;
		System.out.println("Player inherits $100.");
		break;
		
		}
	}
	
	static void propertySquare(Property property, Player player) {
		if(property.sold) {
			
			if(property.owner != player) {
				if(property.houses==0) {
				player.money-=property.rent;
				property.owner.money+=property.rent;
				System.out.println(player.id + " paid " + property.owner.id + " $" + property.rent + " as rent.");
			}
			else if(property.houses==1) {
				player.money-=property.rentOneHouse;
				property.owner.money+=property.rentOneHouse;
				System.out.println(player.id + " paid " + property.owner.id + " $" + property.rentOneHouse + " as rent.");
			}
			else if(property.houses==2) {
				player.money-=property.rentTwoHouses;
				property.owner.money+=property.rentTwoHouses;
				System.out.println(player.id + " paid " + property.owner.id + " $" + property.rentTwoHouses + " as rent.");
			}
			else if(property.houses==3) {
				player.money-=property.rentThreeHouses;
				property.owner.money+=property.rentThreeHouses;
				System.out.println(player.id + " paid " + property.owner.id + " $" + property.rentThreeHouses + " as rent.");
			}
			else if(property.houses==4) {
				if(property.hotel) {
					player.money-=property.rentHotel;
					property.owner.money+=property.rentHotel;
					System.out.println(player.id + " paid " + property.owner.id + " $" + property.rentHotel + " as rent.");
				}
				else {
					player.money-=property.rentFourHouses;
					property.owner.money+=property.rentFourHouses;
					System.out.println(player.id + " paid " + property.owner.id + " $" + property.rentFourHouses + " as rent.");
				}
			}
			}
		}
		else {
			if(player.money>(property.cost+500)) {
				player.money-=property.cost;
				property.sold = true;
				property.owner = player;
				player.properties.add(property);
				
				if(property.color=="Brown")
					player.brownOwned++;
				if(property.color=="Teal")
					player.tealOwned++;
				if(property.color=="Pink")
					player.pinkOwned++;
				if(property.color=="Orange")
					player.orangeOwned++;
				if(property.color=="Red")
					player.redOwned++;
				if(property.color=="yellow")
					player.yellowOwned++;
				if(property.color=="green")
					player.greenOwned++;
				if(property.color=="Blue")
					player.blueOwned++;
				
				System.out.println(player.id + " bought " + property.name + " for $" + property.cost);
			}
		}
	}
	
	static void incomeTax(Player player) {
		player.money-=200;
		System.out.println(player.id + " paid $200 Income Tax.");
	}
	
	static void railroadSquare(Railroad railroad, Player player) {
		if(railroad.sold) {
			
			if(railroad.owner != player) {
				switch(railroad.owner.railroadsOwned) {
			
			case 1: player.money-=25;
			railroad.owner.money+=25;
			System.out.println(player.id + " paid " + railroad.owner.id + " $25");
			break;
			
			case 2: player.money-=50;
			railroad.owner.money+=50;
			System.out.println(player.id + " paid " + railroad.owner.id + " $50");
			break;
			
			case 3: player.money-=100;
			railroad.owner.money+=100;
			System.out.println(player.id + " paid " + railroad.owner.id + " $100");
			break;
			
			case 4: player.money-=200;
			railroad.owner.money+=200;
			System.out.println(player.id + " paid " + railroad.owner.id + " $200");
			break;
				
			}
			}
		}
		else{
			if(player.money>(railroad.cost+500)) {
				player.money-=railroad.cost;
				railroad.sold = true;
				railroad.owner = player;
				player.railroadsOwned++;
				System.out.println(player.id + " bought " + railroad.name + " for $" + railroad.cost);
			}
		}
	}
	
	static void utilitySquare(Utility utility, Player player) {
		if(utility.sold) {
			if(utility.owner != player) {
				int utilDice=(int)(Math.random()*6+1);
				switch(utility.owner.utilitiesOwned) {
				case 1: 
				player.money-=(4*utilDice);
				utility.owner.money+=(4*utilDice);
				System.out.println(player.id + " paid " + utility.owner.id + " $" + (4*utilDice));
					break;
				
				case 2: 
				player.money-=(10*utilDice);
				utility.owner.money+=(10*utilDice);
				System.out.println(player.id + " paid " + utility.owner.id + " $" + (10*utilDice)); 
					break;
				}
			}
		}
		else {
			if(player.money>(utility.cost+500)) {
				player.money-=utility.cost;
				utility.sold = true;
				utility.owner = player;
				player.utilitiesOwned++;
				System.out.println(player.id + " bought " + utility.name + " for $" + utility.cost);
			}
		}
	}
	
	static void goToJail(Player player) {
		player.position=10;
		if(player.getOutOfJailFreeCards>0) {
			player.getOutOfJailFreeCards--;
			System.out.println(player.id + " went to Jail and got out by using a Get Out of Jail Free card.");
		}
		else {
			player.money-=50;
		System.out.println(player.id + " went to Jail and paid $50 fine.");
		}
		
	}
	
	static void luxuryTax(Player player) {
		player.money-=100;
		System.out.println(player.id + " paid $100 Luxury Tax.");
	}
	
	
	
	
	public static void main(String[] args) {
		
		Square[] square = new Square[40];
		square[0] = new Square(0, "GO");
		square[1] = new Square(1, "Mediterranean Avenue");
		square[2] = new Square(2, "Community Chest");
		square[3] = new Square(3, "Baltic Avenue");
		square[4] = new Square(4, "Income Tax");
		square[5] = new Square(5, "Reading Railroad");
		square[6] = new Square(6, "Oriental Avenue");
		square[7] = new Square(7, "Chance");
		square[8] = new Square(8, "Vermont Avenue");
		square[9] = new Square(9, "Connecticut Avenue");
		square[10] = new Square(10, "Jail");
		square[11] = new Square(11, "St. Charles Place");
		square[12] = new Square(12, "Electric Company");
		square[13] = new Square(13, "States Avenue");
		square[14] = new Square(14, "Virginia Avenue");
		square[15] = new Square(15, "Pennsylvania Railroad");
		square[16] = new Square(16, "St. James Place");
		square[17] = new Square(17, "Community Chest");
		square[18] = new Square(18, "Tennessee Avenue");
		square[19] = new Square(19, "New York Avenue");
		square[20] = new Square(20, "Free Parking");
		square[21] = new Square(21, "Kentucky Avenue");
		square[22] = new Square(22, "Chance");
		square[23] = new Square(23, "Indiana Avenue");
		square[24] = new Square(24, "Illinois Avenue");
		square[25] = new Square(25, "B. & O. Railroad");
		square[26] = new Square(26, "Atlantic Avenue");
		square[27] = new Square(27, "Ventnor Avenue");
		square[28] = new Square(28, "Water Works");
		square[29] = new Square(29, "Marvin Gardens");
		square[30] = new Square(30, "Go To Jail");
		square[31] = new Square(31, "Pacific Avenue");
		square[32] = new Square(32, "North Caroline Avenue");
		square[33] = new Square(33, "Community Chest");
		square[34] = new Square(34, "Pennsylania Avenue");
		square[35] = new Square(35, "Short Line");
		square[36] = new Square(36, "Chance");
		square[37] = new Square(37, "Park Place");
		square[38] = new Square(38, "Luxury Tax");
		square[39] = new Square(39, "Boardwalk");
				
		Property[] property = new Property[22];
		property[0] = new Property("Mediterranean Avenue", "Brown", 60, 2, 10, 30, 90, 160, 250, 50, 30);
		property[1] = new Property("Baltic Avenue", "Brown", 60, 4, 20, 60, 180, 320, 450, 50, 30);
		property[2] = new Property("Oriental Avenue", "Teal", 100, 6, 30, 90, 270, 400, 550, 50, 50);
		property[3] = new Property("Vermont Avenue", "Teal", 100, 6, 30, 90, 270, 400, 550, 50, 50);
		property[4] = new Property("Connecticut Avenue", "Teal", 120, 8, 40, 100, 300, 450, 600, 50, 60);
		property[5] = new Property("St. Charles Place", "Pink", 140, 10, 50, 150, 450, 625, 750, 100, 70);
		property[6] = new Property("States Avenue", "Pink", 140, 10, 50, 150, 450, 625, 750, 100, 70);
		property[7] = new Property("Virginia Avenue", "Pink", 160, 12, 60, 180, 500, 700, 900, 100, 80);
		property[8] = new Property("St. James Place", "Orange", 180, 14, 70, 200, 550, 750, 950, 100, 90);
		property[9] = new Property("Tennessee Avenue", "Orange", 180, 14, 70, 200, 550, 750, 950, 100, 90);
		property[10] = new Property("New York Avenue", "Orange", 200, 16, 80, 220, 600, 800, 1000, 100, 100);
		property[11] = new Property("Kentucky Avenue", "Red", 220, 18, 90, 250, 700, 875, 1050, 150, 100);
		property[12] = new Property("Indiana Avenue", "Red", 220, 18, 90, 250, 700, 875, 1050, 150, 100);
		property[13] = new Property("Illinois Avenue", "Red", 240, 20, 100, 300, 750, 925, 1100, 150, 120);
		property[14] = new Property("Atlantic Avenue", "Yellow", 260, 22, 110, 330, 800, 975, 1150, 150, 130);
		property[15] = new Property("Ventnor Avenue", "Yellow", 260, 22, 110, 330, 800, 975, 1150, 150, 130);
		property[16] = new Property("Marvin Gardens", "Yellow", 280, 24, 120, 350, 850, 1025, 1200, 150, 140);
		property[17] = new Property("Pacific Avenue", "Green" ,300, 26, 130, 390, 900, 1100, 1275, 200, 150);
		property[18] = new Property("North Caroline Avenue", "Green", 300, 26, 130, 390, 900, 1100, 1275, 200, 150);
		property[19] = new Property("Pennsylania Avenue", "Green", 320, 28, 150, 450, 1000, 1200, 1400, 200, 160);
		property[20] = new Property("Park Place", "Blue", 350, 35, 175, 500, 1100, 1300, 1500, 200, 200);
		property[21] = new Property("Boardwalk", "Blue", 400, 50, 200, 600, 1400, 1700, 2000, 200, 200);
		
		Railroad[] railroad = new Railroad[4];
		railroad[0] = new Railroad("Reading Railroad");
		railroad[1] = new Railroad("Pennsylvania Railroad");
		railroad[2] = new Railroad("B. & O. Railroad");
		railroad[3] = new Railroad("Short Line");
		
		Utility[] utility = new Utility[2];
		utility[0] = new Utility("Electric Company", 150);
		utility[1] = new Utility("Water Works", 150);
		
			
		
		System.out.println("How many players?");
		Scanner sc = new Scanner(System.in);
		int no_of_players = sc.nextInt();
		while(no_of_players>8 || no_of_players<0) {
			System.out.println("Invalid input. Maximum 8 players allowed. Kindly input again.");
			no_of_players = sc.nextInt();
		}
			Player[] player = new Player[no_of_players];
			for(int i=0;i<no_of_players;i++) {
				player[i] = new Player("Player"+i);
			}
		boolean game_over = false;
		while(game_over == false) {
	
			for(int i=0;i<no_of_players;i++) {
				
				if(player[i].money<0) {
					player[i].bankruptcy = true;
					
					while(player[i].brownOwned==2 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Brown") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].tealOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Teal") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].pinkOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Pink") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].orangeOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Orange") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].redOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Red") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].yellowOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Yellow") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].greenOwned==3 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Green") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
					while(player[i].blueOwned==2 && player[i].money>700) {
						for (int j = 0; j < player[i].properties.size(); j++) {
							 if(player[i].properties.get(j).color == "Blue") {
								 if(!player[i].properties.get(j).hotel) {
									 if(player[i].properties.get(j).houses<4) {
											 player[i].money-=player[i].properties.get(j).houseCost;
											 player[i].properties.get(j).houses++;
											 System.out.println(player[i].id + " bought a house for " + player[i].properties.get(j).name + ". Has " + player[i].properties.get(j).houses + " houses now.");
									 }
									 else {
										 player[i].money-=player[i].properties.get(j).houseCost;
										 player[i].properties.get(j).hotel = true;
										 System.out.println(player[i].id + " bought a hotel for " + player[i].properties.get(j).name);
									 }
								 }
							 }
						}
				        
					}
					
				}
				
				if(!player[i].bankruptcy) {
					
					int dice=(int)(Math.random()*6+1);
					System.out.println(player[i].id+" rolled "+dice);
					player[i].position+=dice;
					if(player[i].position>39) {
						player[i].money+=200;
						player[i].position = (player[i].position%39)-1;
						System.out.println(player[i].id+" passed GO and collected $200");
					}
					System.out.println(player[i].id+" landed on "+square[player[i].position].squareName);
					
					
					
					switch(player[i].position) {
					
					case 0: break;
					
					case 1: propertySquare(property[0], player[i]);
							break;
					
					case 2: communityChest(player[i]);
					break;
					
					case 3: propertySquare(property[1], player[i]);
					break;
					
					case 4: incomeTax(player[i]);
					break;
					
					case 5: railroadSquare(railroad[0], player[i]);
					break;
					
					case 6: propertySquare(property[2], player[i]);
						break;
					
					case 7: communityChest(player[i]);
						break;
					
					case 8: propertySquare(property[3], player[i]);
						break;
					
					case 9: propertySquare(property[4], player[i]);
						break;
					
					case 10: goToJail(player[i]);
						break;
					
					case 11: propertySquare(property[5], player[i]);
						break;
					
					case 12: utilitySquare(utility[0], player[i]);
						break;
					
					case 13: propertySquare(property[6], player[i]);
						break;
					
					case 14: propertySquare(property[7], player[i]);
						break;
					
					case 15: railroadSquare(railroad[1], player[i]);
						break;
					
					case 16: propertySquare(property[8], player[i]); 
						break;
					
					case 17: communityChest(player[i]);
						break;
					
					case 18: propertySquare(property[9], player[i]);
						break;
					
					case 19: propertySquare(property[10], player[i]);
						break;
					
					case 20:
						break;
					
					case 21: propertySquare(property[11], player[i]);
						break;
					
					case 22: communityChest(player[i]);
						break;
					
					case 23: propertySquare(property[12], player[i]);
						break;
					
					case 24: propertySquare(property[13], player[i]);
						break;
					
					case 25: railroadSquare(railroad[2], player[i]);
						break;
					
					case 26: propertySquare(property[14], player[i]);
						break;
					
					case 27: propertySquare(property[15], player[i]);
						break;
					
					case 28: utilitySquare(utility[1], player[i]);
						break;
					
					case 29: propertySquare(property[16], player[i]);
						break;
					
					case 30: goToJail(player[i]); 
						break;
					
					case 31: propertySquare(property[17], player[i]);
						break;
					
					case 32: propertySquare(property[18], player[i]);
						break;
					
					case 33: communityChest(player[i]);
						break;
					
					case 34: propertySquare(property[19], player[i]);
						break;
					
					case 35: railroadSquare(railroad[3], player[i]);
						break;
					
					case 36: communityChest(player[i]);
						break;
					
					case 37: propertySquare(property[20], player[i]);
						break;
					
					case 38: luxuryTax(player[i]);
						break;
					
					case 39: propertySquare(property[21], player[i]);
						break;
					}
					
					System.out.println(player[i].id + " turn ended.");
				}
			}
			
			System.out.println("Game State:");
			for(int i=0; i<no_of_players;i++) {
				if(player[i].bankruptcy)
					System.out.println(player[i].id + " is bankrupt and out of the game.");
				else {
					System.out.println(player[i].id + "   " + square[player[i].position].squareName + "   " + player[i].money + "   " + player[i].properties.size() + " properties   " + player[i].railroadsOwned + " railroads   " + player[i].utilitiesOwned + " utilities");
				}
			}
			System.out.println("------------------------------------------------------------------------------------------------------------");
		
			int playersLeft = 0;
			for(int i=0;i<no_of_players;i++) {
				if(!player[i].bankruptcy)
					playersLeft ++;
			}
			
			if(playersLeft==1) {
				game_over = true;
				for(int i=0;i<no_of_players;i++) {
					if(!player[i].bankruptcy)
						System.out.println("Game Over! The winner is " + player[i].id);
				}
		}
			//String s = sc.next();
	}
	}
}
