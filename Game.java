import java.util.Scanner;
public class Game {
    Player[] players;
    public Game(Player[] players) {
        this.players = players;
    }
    static Scanner scanner = new Scanner(System.in);
    int dayNum=0;
    int nightNum=1;
    boolean isGameEnd=false;
    public void gameStarted() {
        while(true){
            dayStart(players);
            endGameCondition(players);
            if(isGameEnd){
                break;
            }
            dayEnd(players);
            if(isGameEnd){
                break;
            }
            refresh(players);
            night(players);
            if(isGameEnd){
                break;
            }
        }
    }
    private void vote(String voter, String votee) {
        boolean validVoter = false;
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerName.equals(voter)) {
                validVoter = true;
                if(players[i].death){
                    System.out.println("voter is dead");
                    return;
                }
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
        for(int i = 0; i < players.length; i++){
            if(players[i].isMafia && !players[i].death){
                x++;
            }
        }
        return x;
    }
    private int countVillager(Player[] players) {
        int x = 0;
        for (int i=0;i<players.length;i++) {
            if(players[i].isVillager && !players[i].death){
                    x++;
            }
        }
        return x;
    }
    private void dayStart(Player[] players) {
        String str1 = null;
        String str2 = null;
        System.out.println("day " + ++dayNum);
        if(dayNum!=1){
            nightEnd(players);
            endGameCondition(players);
            resetVote(players);
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
        for (int i = 0; i < players.length; i++) {
            if (players[i].vote >= max) {
                max = players[i].vote;
            }
        }
        int sum = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].vote == max) {
                sum++;
            }
        }
        if (sum != 1) {
            System.out.println("nobody die");
        }
        else {
            for(int i=0;i< players.length;i++){
                if(players[i].vote==max){
                    players[i].death=true;
                    if (players[i].role==Role.joker) {
                        System.out.println("joker won:>");
                        isGameEnd = true;
                        break;
                    }
                    else{
                        if(players[i].death){
                            System.out.println(players[i].playerName + " died");
                            break;
                        }
                    }
                }
            }
        }
        endGameCondition(players);
    }
    private void endGameCondition(Player[] players) {
        int x = countMafia(players);
        int y = countVillager(players);
        if (x >= y) {
            System.out.println("mafia win");
            isGameEnd = true;
        }
        if(x == 0){
            System.out.println("villager win");
            isGameEnd = true;
        }
    }
    private void night(Player[] players){
        System.out.println("night " + nightNum++);
        for(int i=0;i< players.length;i++){
            if(players[i].role==Role.mafia){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role==Role.godfather){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role==Role.silencer){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role==Role.detective){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
            if(players[i].role==Role.doctor){
                if(players[i].death){
                    continue;
                }
                else{
                    System.out.println(players[i].playerName + ": " + players[i].role);
                }
            }
        }
        String str1;
        str1 = null;
        String str2;
        str2 = null;
        String firstVote=null;
        String secondVote=null;
        while (scanner.hasNext()){
            str1=scanner.next();
            if(str1.equals("start_game")){
                System.out.println("game already started");
                continue;
            }
            if(str1.equals("get_game_state")){
                System.out.println("villager: " + countVillager(players));
                System.out.println("mafia: " + countMafia(players));
                continue;
            }
            if(str1.equals("end_night")){
                break;
            }
            str2=scanner.next();
            for(int i=0;i< players.length;i++){
                if(players[i].playerName.equals(str1)){
                    if(players[i].role==Role.mafia || players[i].role==Role.godfather || (players[i].role==Role.silencer && players[i].silencerVoteCount==1)){
                        if(players[i].role==Role.silencer){
                            if(players[i].death){
                                System.out.println("user is dead");
                                break;
                            }
                            else{
                                players[i].silencerVoteCount++;
                                mafiasVoteCount(str2);
                            }
                        }
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else{
                            mafiasVoteCount(str2);
                        }
                    }
                    else if(players[i].role==Role.silencer && players[i].silencerVoteCount==0){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else{
                            nightSilencer(str2);
                        }
                    }
                    else if(players[i].role==Role.doctor){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else {
                            nightDoctor(str2);
                        }
                    }
                    else if(players[i].role==Role.detective){
                        if(players[i].death){
                            System.out.println("user is dead");
                            break;
                        }
                        else {
                            if(players[i].isDetectiveAsked){
                                System.out.println("detective has already asked");
                            }
                            else if (nightDetective(str2)) {
                                players[i].isDetectiveAsked=true;
                                System.out.println("yes");
                            }
                            else {
                                players[i].isDetectiveAsked=true;
                                System.out.println("no");
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
        for (Player player : players) {
            player.vote = 0;
        }
    }
    private void refresh(Player[] players){
        for (Player player : players) {
            player.refresh();
        }
    }
    private void mafiasVoteCount(String votee){
        boolean isFoundVotee=false;
        for(int i=0;i<players.length;i++){
            if(players[i].playerName.equals(votee)){
                players[i].voted();
                isFoundVotee=true;
            }
        }
        if(!isFoundVotee){
            System.out.println("user not found");
        }
    }
    private void nightEnd(Player[] players){//for mafias
        Player first=null , second=null;
        int max = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].vote >= max) {
                max = players[i].vote;
            }
        }
        int sum = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].vote == max) {
                ++sum;
                if(sum==1){
                    first=players[i];
                }
                if(sum==2){
                    second=players[i];
                }
            }
        }
        if (sum==2){
            if(first.healing){
                second.isDead();
                System.out.println("mafia tried to kill " + second.playerName);
                if(second.death){
                    System.out.println(second.playerName + " was killed");
                }
            }
            else if(second.healing){
                first.isDead();
                System.out.println("mafia tried to kill " + first.playerName);
                if(first.death){
                    System.out.println(first.playerName + " was killed");
                }
            }
            else{
                System.out.println("nobody die");
            }
        }
        else if(sum>2){
            System.out.println("nobody die");
        }
        else {
            for(int i=0;i< players.length;i++){
                if(players[i].vote==max){
                    System.out.println("mafia tried to kill " + players[i].playerName);
                    if(players[i].healing){
                        break;
                    }
                    else{
                        players[i].isDead();
                        if(players[i].death){
                            System.out.println(players[i].playerName + " was killed");
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0;i<players.length;i++){
            if(players[i].silence){
                System.out.println("silenced " + players[i].playerName);
                break;
            }
        }
    }
    private void nightDoctor(String votee){
        boolean isFoundVotee=false;
        for (Player player : players) {
            if (player.playerName.equals(votee)) {
                isFoundVotee = true;
                player.healing = true;
            }
        }
        if(!isFoundVotee){
            System.out.println("user not found");
        }
    }
    private void nightSilencer(String votee){
        boolean isFoundVotee=false;
        for (Player player : players) {
            if (player.playerName.equals(votee)) {
                isFoundVotee = true;
                player.silence = true;
            }
        }
        if(!isFoundVotee){
            System.out.println("user not found");
        }
    }
    private boolean nightDetective(String votee){
        boolean isFoundVotee=false;
        for (Player player : players) {
            if (player.playerName.equals(votee)) {
                player.isDetectiveAsked=true;
                isFoundVotee = true;
                if(player.death){
                    System.out.println("suspect is dead");
                }
                else {
                    if (player.isMafia && !(player.role==Role.godfather)) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        if(!isFoundVotee){
            System.out.println("user not found");
        }
        return false;
    }
}