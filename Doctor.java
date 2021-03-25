public class Doctor extends Player{
    public Doctor(String playerName) {
        super(playerName);
        death=false;
        isMafia=false;
        vote=0;
        silence=false;
        healing=false;
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
}
