public class BulletProof extends Player {
    public BulletProof(String playerName) {
        super(playerName);
        role=Role.bulletproof;
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
    private int x=2;
    @Override
    void isDead() {
        if(x==0){
            death=true;
        }
        else{
            x--;
        }
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
