import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String order;
        Player[] players = null;
        String[] names = null;

        Scanner scanner = new Scanner(System.in);
        boolean isGameCreated = false;
        boolean isRoleAssigned = false;
        boolean isGameStarted = false;
        boolean isNameFound = false;
        System.out.println("welcome to mafia game");
        System.out.println("for start game please enter create_game");
        int x = 0;//for count:assign_role
        String assign_role = null;
        String[] roles = new String[3];
        int numOfVillager;
        int numOfMafia;
        while (scanner.hasNext()) {
            order = scanner.next();
            if (order.equals("create_game")) {
                isGameCreated = true;
                String playerNames = null;
                playerNames = scanner.nextLine();
                names = playerNames.split(" ");
                players = new Player[names.length - 1];
                System.out.println("game created");
                System.out.println("please assign roles with assign_role");
            }
            else if (order.equals("assign_role")) {
                if (!isGameCreated) {
                    System.out.println("no game created");
                    continue;
                }
                else {
                    assign_role = scanner.nextLine();
                    roles = assign_role.split(" ");
                    for(int i = 1; i < names.length; i++){
                        if (names[i].equals(roles[1])) {
                            isNameFound = true;
                            switch (roles[2]) {
                                case "joker":
                                    players[x++] = new Joker(names[i]);
                                    break;
                                case "bulletproof":
                                    players[x++] = new BulletProof(names[i]);
                                    break;
                                case "doctor":
                                    players[x++] = new Doctor(names[i]);
                                    break;
                                case "mafia":
                                    players[x++] = new Mafia(names[i]);
                                    break;
                                case "detective":
                                    players[x++] = new Detective(names[i]);
                                    break;
                                case "godfather":
                                    players[x++] = new GodFather(names[i]);
                                    break;
                                case "villager":
                                    players[x++] = new Villager(names[i]);
                                    break;
                                case "silencer":
                                    players[x++] = new Silencer(names[i]);
                                    break;
                                default:
                                    System.out.println("role not found");
                            }
                        }
                    }
                    if(!isNameFound){
                        System.out.println("user not found");
                    }
                }
            }
            else if(order.equals("start_game")) {
                isGameStarted = true;
                if (!isGameCreated) {
                    System.out.println("no game created");
                    continue;
                }
                if (x<names.length - 1) {
                    System.out.println("one or more player do not have a role");
                    continue;
                }
                if(isGameStarted){
                    System.out.println("game has already started");
                    continue;
                }
                else {
                    for (int i = 0; i < players.length; i++){
                        System.out.println(players[i].playerName + ": " + players[i].role);
                    }
                    System.out.println("game started");
                    Game game = new Game(players);
                    game.gameStarted();
                }
            }
            else if(order.equals("get_game_state")){
                numOfVillager=countVillager(players);
                numOfMafia=countMafia(players);
                System.out.println("villager: " + numOfVillager);
                System.out.println("mafia: " + numOfMafia);
            }
            else{
                System.out.println("wrong order, try again");
                continue;
            }
        }
    }
    static void Menu(){
        System.out.println("1)for starting game you should create game:(enter)create_game + names of players");
        System.out.println("2)after create game you should assign role of players:(enter)assign_role + player name + role");
        System.out.println("3)after assign role you can start game:(enter)start_game");
    }
    static int countMafia(Player[] players){
        int x=0;
        for(int i=0;i< players.length;i++){
            if(players[i].isMafia){
                x++;
            }
        }
        return x;
    }
    static int countVillager(Player[] players){
        int x=0;
        for(int i=0;i< players.length;i++){
            if(!players[i].isMafia){
                if(players[i].role.equals("joker")){
                    continue;
                }
                else{
                    x++;
                }
            }
            return x;
        }
        return x;
    }
}