import java.util.Scanner;
public class Game {
    String order;
    Player[] players;
    String[] names=null;
    Scanner scanner=new Scanner(System.in);
    public boolean isGameCreated=false;
    public boolean isRoleAssigned=false;
    public boolean isGameStarted=false;
    public void firstMenu(){
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
            order=scanner.next();
        }
        System.out.println("please enter assign_role for assigning roles");
        while (!order.equals("assign_role")){
            System.out.println("wrong order , please enter assign_role");
            order=scanner.next();
        }
        if(order.equals("assign_role") && isGameCreated){
            isRoleAssigned=true;
            String assign_role=scanner.nextLine();
            String[] roles=new String[3];
            roles=assign_role.split(" ");
            for(int i=1 , k=0;i<names.length;i++){
                if(names[i].equals(roles[2])){
                    switch(roles[3]){
                        case "joker":players[k++]=new Joker(names[i]);
                            break;
                        case "bulletproof":players[k++]=new BulletProof(names[i]);
                            break;
                        case "doctor":players[k++]=new Doctor(names[i]);
                            break;
                        case "mafia":players[k++]=new Mafia(names[i]);
                            break;
                        case "detective":players[k++]=new Detective(names[i]);
                            break;
                        case "godfather":players[k++]=new GodFather(names[i]);
                            break;
                        case "villager":players[k++]=new Villager(names[i]);
                            break;
                        case "silencer":players[k++]=new Silencer(names[i]);
                            break;
                        default:
                            System.out.println("role not found");
                    }
                }
                else{
                    System.out.println("user not found");
                }
            }
        }
        if(order.equals("start_game") && isRoleAssigned ){

    }
}
