public class Doctor extends Player{
    public Doctor(String playerName) {
        super(playerName);
        role=Role.doctor;
        death=false;
        isMafia=false;
        isVillager=true;
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
