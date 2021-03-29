public class GodFather extends Player{
    public GodFather(String playerName) {
        super(playerName);
        role=Role.godfather;
        death=false;
        isMafia=true;
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
