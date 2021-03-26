import java.util.Scanner;
public class Game {
    String order;
    Player[] players;
    String[] names=null;
    Scanner scanner=new Scanner(System.in);
    public boolean isCreateGame=false;
    public boolean isAssignRole=false;
    public void firstMenu(){
        System.out.println("welcome to mafia game");
        System.out.println("for start game please enter create_game");
        order=scanner.next();
        while (!order.equals("create_game")){
            System.out.println("wrong order , please enter create_game");
            order=scanner.next();
        }
        if(order.equals("create_game")){
            isCreateGame=true;
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
        if(order.equals("assign_role") && isCreateGame){
            
        }
        if(order.equals("start_game") && isAssignRole && isCreateGame){
        }
        else{
            System.out.println("wrong order please try again");
        }
    }
}
