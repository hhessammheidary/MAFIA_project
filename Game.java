import java.util.Scanner;
public class Game {
    Player[] players;
    public Game(Player[] players){
        this.players=players;
    }
    public void gameStarted(){
        Scanner scanner=new Scanner(System.in);
        Day day=new Day();
        Night night=new Night();
        String order=null;
        while(scanner.hasNext()){
            System.out.println("day (" + day.getDay() + ")");
            System.out.println("we need to vote and find");
            order=scanner.nextLine();
            if(order.equals("end_vote")){
                //night;
                day.increase();
            }
            else{

            }
        }
    }
    private void vote(String voter , String votee){
        boolean validVoter=false;
        for (int i=0;i<players.length;i++){
            if(players[i].playerName.equals(voter)){
                validVoter=true;
                if(players[i].isSilence()){
                    System.out.println("voter is silenced");
                    return;
                }
                break;
            }
        }
        if(!validVoter){
            System.out.println("user not found");
            return;
        }
        else{
            for(int j=0;j<players.length;j++){
                if(players[j].playerName.equals(votee)){
                    if(players[j].death){
                        System.out.println("votee already dead");
                        return;
                    }
                    else{
                        players[j].voted();
                    }
                    break;
                }
            }
        }
    }
}