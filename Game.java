import java.util.Scanner;
public class Game {
    Player[] players;

    public Game(Player[] players) {
        this.players = players;
    }

    static Scanner scanner = new Scanner(System.in);
    int dayNum=1;
    int nightNum=1;
    boolean isGameEnd;
    public void gameStarted() {
        String order = null;
        while (scanner.hasNext()) {
            order=scanner.next();
            dayStart(players);
            dayEnd(players);
            resetVote(players);
            if(isGameEnd){
                break;
            }
            night(players);
        }
    }

    private void vote(String voter, String votee) {
        boolean validVoter = false;
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerName.equals(voter)) {
                validVoter = true;
                if (players[i].isSilence()) {
                    System.out.println("voter is silenced");
                    return;
                }
                break;
            }
        }
        if (!validVoter) {
            System.out.println("user not found");
            return;
        } else {
            for (int j = 0; j < players.length; j++) {
                if (players[j].playerName.equals(votee)) {
                    if (players[j].death) {
                        System.out.println("votee already dead");
                        return;
                    } else {
                        players[j].voted();
                    }
                    break;
                }
            }
        }
    }
    private int countMafia(Player[] players) {
        int x = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].isMafia) {
                x++;
            }
        }
        return x;
    }
    private int countVillager(Player[] players) {
        int x = 0;
        for (int i = 0; i < players.length; i++) {
            if (!players[i].isMafia) {
                if (players[i].role.equals("joker")) {
                    continue;
                } else {
                    x++;
                }
            }
            return x;
        }
        return x;
    }
    private void dayStart(Player[] players) {
        String str1 = null;
        String str2 = null;
        System.out.println("day " + dayNum++);
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].playerName + ": " + players[i].role);
        }
        while (scanner.hasNext()) {
            str1 = scanner.next();
            if (str1.equals("start_game")) {
                System.out.println("game already started");
            }
            if (str1.equals("end_vote")) {
                break;
            }
            if (str1.equals("get_game_state")) {
                System.out.println("villager: " + countVillager(players));
                System.out.println("mafia: " + countMafia(players));
            }
            str2 = scanner.next();
            vote(str1, str2);
        }
    }
    private void dayEnd(Player[] players) {
        int max = 0;
        int i;
        for (i = 0; i < players.length; i++) {
            if (players[i].vote > max) {
                max = players[i].vote;
            }
        }
        int sum = 0;
        for (int j = 0; j < players.length; j++) {
            if (players[i].vote == max) {
                sum++;
            }
        }
        if (sum != 1) {
            System.out.println("nobody die");
        }
        else {
            players[i].death = true;
            if (players[i].role.equals("joker")) {
                System.out.println("joker won:>");
                isGameEnd = true;
            }
            else{
                System.out.println(players[i].playerName + " died");
            }
        }
    }
    private void endGameCondition(Player[] players) {
        int x = countMafia(players);
        int y = countVillager(players);
        if (x >= y) {
            System.out.println("mafia win");
            isGameEnd = true;
        }
        if (x == 0) {
            System.out.println("villager win");
            isGameEnd = true;
        }
    }
    private void night(Player[] players){
        System.out.println("night " + nightNum++);
        for(int i=0;i< players.length;i++){
            if(players[i].role.equals("mafia")){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role.equals("godfather")){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role.equals("silencer")){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role.equals("doctor")){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role.equals("detective")){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
        }
        String str1=null;
        String str2=null;
        String firstVote=null;
        String secondVote=null;
        while (scanner.hasNext()){
            str1=scanner.next();
            if(str1.equals("start_game")){
                System.out.println("game already started");
            }
            if(str1.equals("get_game_state")){
                System.out.println("villager: " + countVillager(players));
                System.out.println("mafia: " + countMafia(players));
            }
            if(str1.equals("end_night")){

            }
            str2=scanner.next();
            for(int i=0;i< players.length;i++){
                if(players[i].playerName.equals(str1)){
                    if(players[i].role.equals("mafia")){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else{
                            for(int j=0;j< players.length;j++){
                                if(players[j].playerName.equals(str2)){
                                    if(players[j].death){

                                    }
                                }
                            }
                        }
                    }
                    else if(players[i].role.equals("silencer")){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else{

                        }
                    }
                    else if(players[i].role.equals("doctor")){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else {

                        }
                    }
                    else if(players[i].role.equals("detective")){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else {
                            for(int j=0;j< players.length;j++){
                                if(players[j].playerName.equals(str2)){

                                }
                            }
                        }
                    }
                    else {
                        System.out.println("user can not wake up during night");
                    }
                }
            }
        }
    }
    private void resetVote(Player[] players){
        for(int i=0;i< players.length;i++){
            players[i].vote=0;
        }
    }
    private void nightVoteCondition(Player player){//for mafias
        if(player.healing){
            player.healing=false;
        }
        else{
            if(player instanceof Silencer || player instanceof Mafia || player instanceof GodFather){
                player.isLastVoteOFNight;
            }
        }
    }
}