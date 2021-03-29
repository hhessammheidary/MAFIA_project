public class Villager extends Player{
    public Villager(String playerName) {
        super(playerName);
        role=Role.villager;
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
