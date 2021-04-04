public class GodFather extends Player{
    public GodFather(String playerName) {
        super(playerName);
        role=Role.godfather;
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
