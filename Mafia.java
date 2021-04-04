public class Mafia extends Player{
    public Mafia(String playerName) {
        super(playerName);
        role=Role.mafia;
        death=false;
        isMafia=true;
        isVillager=false;
        vote=0;
        silence=false;
        healing=false;
        isLastVoteOFNight=false;
    }
    @Override
    void voted(){
        vote++;
    }
    @Override
    void isDead() {
        death=true;
    }
    @Override
    void setSilence() {
        silence=true;
    }
    @Override
    boolean isSilence() {
        return silence;
    }
    @Override
    void setHealing() {
        healing=true;
    }
    @Override
    boolean isHealing() {
        return healing;
    }
    @Override
    void refresh() {
        vote=0;
        silence=false;
        healing=false;
        isLastVoteOFNight=false;
    }
}
