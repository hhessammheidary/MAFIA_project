public class BulletProof extends Player {
    public BulletProof(String playerName) {
        super(playerName);
        role=Role.bulletproof;
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
    private int x=1;
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
    @Override
    void refresh() {
        vote=0;
        silence=false;
        healing=false;
        isLastVoteOFNight=false;
    }
}
