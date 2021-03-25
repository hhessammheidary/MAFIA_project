public class Joker extends Player{
    public Joker(String playerName) {
        super(playerName);
        death=false;
        isMafia=false;
        vote=0;
        silence=false;
        healing=false;
    }
    Role getRole(){
        return super.role;
    }
    void setRole(Role role){
        super.role=role;
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
