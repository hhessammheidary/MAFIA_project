public  abstract class  Player {
    protected String playerName;
    public Player(String playerName){
        this.playerName=playerName;
    }
    protected Role role;
    protected boolean death;
    protected boolean isMafia;
    protected boolean isVillager;
    protected int vote;
    protected boolean silence;
    protected boolean healing;
    protected boolean isLastVoteOFNight;
    protected int silencerVoteCount;
    {
        silencerVoteCount = 0;
    }
    protected boolean isDetectiveAsked;
    {
        isDetectiveAsked = false;
    }

    abstract void voted();
    abstract void isDead();
    abstract void setSilence();
    abstract boolean isSilence();
    abstract void setHealing();
    abstract boolean isHealing();
    abstract void refresh();
}
