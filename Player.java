public  abstract class  Player {
    protected String playerName;
    public Player(String playerName){
        this.playerName=playerName;
    }
    protected Role role;
    protected boolean death;
    protected boolean isMafia;
    protected int vote;
    protected boolean silence;
    protected boolean healing;
    abstract void voted();
    abstract void isDead();
    abstract void setSilence();
    abstract boolean isSilence();
    abstract void setHealing();
    abstract boolean isHealing();
}
