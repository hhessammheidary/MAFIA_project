import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String order;
        Player[] players=null;
        String[] names=null;
        Scanner scanner=new Scanner(System.in);
        boolean isGameCreated=false;
        boolean isRoleAssigned=false;
        boolean isGameStarted=false;
        System.out.println("welcome to mafia game");
        System.out.println("for start game please enter create_game");
        order=scanner.next();
        while (!order.equals("create_game")){
            System.out.println("wrong order , please enter create_game");
            order=scanner.next();
        }
        if(order.equals("create_game")){
            isGameCreated=true;
            String playerNames=null;
            playerNames=scanner.nextLine();
            names=playerNames.split(" ");
            players=new Player[names.length-1];
            System.out.println("game created");
        }
        int x = 0;//for count
        while(true) {
            order = scanner.next();
            if(order.equals("assign_role") && isGameCreated){
                String assign_role = scanner.nextLine();
                String[] roles = new String[3];
                roles = assign_role.split(" ");
                boolean isNameFound = false;
                for(int i = 1; i < names.length; i++){
                    if(names[i].equals(roles[2])){
                        isNameFound = true;
                        switch (roles[3]) {
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
                    if(!isNameFound){
                        System.out.println("user not found");
                    }
                }
            }
            else{
                System.out.println("wrong order please set the roles");
                continue;
            }
            if(x==names.length-1){
                isRoleAssigned=true;
                System.out.println("assigning_role successful");
                break;
            }
            else{
                System.out.println("one or more player do not have a role");
            }
        }
        System.out.println("for starting game enter start_game");
        order=scanner.next();
        if(order.equals("create_game")){
            System.out.println("");
        }
        while (!order.equals("start_game")) {
            System.out.println("wrong order please enter start_game");
            order=scanner.next();
        }
        isGameStarted=true;
        for(int i=0;i< players.length;i++){
            System.out.println("");
        }
    }
}
