package org.toastertech.TTScout.data;

public class Match {

    // Permanent
    private int matchNum;
    private int teamNum;
    private String scoutName;
    private String competitionName;

    //Stuff for Power Up
    private int autoScaleStatus,
            autoSwitchStatus,
                autoLine,
                blocksOnOwnSwitch,
                blocksOnOppositeSwitch,
                blocksOnScale,
                blocksInVault,
                attemptedClimb,
                completedClimb,
                parkedOnRamp,
                pilePowerCube,
                switchPowerCube,
                exchangePowerCube,
                portalPowerCube,
                defensiveRating,
                regularFoul,
                techFoul,
                yellowCard;

    public Match(){ // SuperCSV Writer
        matchNum = 0;
        teamNum = 0;
        scoutName = "";
        competitionName = "";

        this.autoScaleStatus = 0;
        this.autoSwitchStatus = 0;
        this.autoLine               = 0;
        this.blocksOnOwnSwitch      = 0;
        this.blocksOnOppositeSwitch = 0;
        this.blocksOnScale          = 0;
        this.blocksInVault          = 0;
        this.attemptedClimb         = 0;
        this.completedClimb         = 0;
        this.parkedOnRamp           = 0;
        this.pilePowerCube          = 0;
        this.switchPowerCube        = 0;
        this.exchangePowerCube      = 0;
        this.portalPowerCube        = 0;
        this.defensiveRating        = 0;
        this.regularFoul            = 0;
        this.techFoul               = 0;
        this.yellowCard             = 0;

    }



    public Match(int matchNum, int teamNum, String scoutName, String competitionName) { // Human-Used
        this.matchNum = matchNum;
        this.teamNum = teamNum;
        this.scoutName = scoutName;
        this.competitionName = competitionName;

        this.autoScaleStatus = 0;
        this.autoSwitchStatus = 0;
        this.autoLine               = 0;
        this.blocksOnOwnSwitch      = 0;
        this.blocksOnOppositeSwitch = 0;
        this.blocksOnScale          = 0;
        this.blocksInVault          = 0;
        this.attemptedClimb         = 0;
        this.completedClimb         = 0;
        this.parkedOnRamp           = 0;
        this.pilePowerCube          = 0;
        this.switchPowerCube        = 0;
        this.exchangePowerCube      = 0;
        this.portalPowerCube        = 0;
        this.defensiveRating        = 0;
        this.regularFoul            = 0;
        this.techFoul               = 0;
        this.yellowCard             = 0;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public String getScoutName() {
        return scoutName;
    }

    public void setScoutName(String scoutName) {
        this.scoutName = scoutName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @Override
    public String toString() {
        return "Match Number: " + matchNum + "\nTeam Number: " + teamNum + "\nScout Name: " + scoutName;
    }


    //FIRST Power Up Stuff

    public int getAutoScaleStatus() {
        return autoScaleStatus;
    }

    public void setAutoScaleStatus(int autoScaleStatus) {
        this.autoScaleStatus = autoScaleStatus;
    }

    public int getAutoSwitchStatus() {
        return autoSwitchStatus;
    }

    public void setAutoSwitchStatus(int autoSwitchStatus) {
        this.autoSwitchStatus = autoSwitchStatus;
    }

    public int getAutoLine() {
        return autoLine;
    }

    public void setAutoLine(int autoLine) {
        this.autoLine = autoLine;
    }

    public int getBlocksOnOwnSwitch() {
        return blocksOnOwnSwitch;
    }

    public void setBlocksOnOwnSwitch(int blocksOnOwnSwitch) {
        this.blocksOnOwnSwitch = blocksOnOwnSwitch;
    }

    public int getBlocksOnOppositeSwitch() {
        return blocksOnOppositeSwitch;
    }

    public void setBlocksOnOppositeSwitch(int blocksOnOppositeSwitch) {
        this.blocksOnOppositeSwitch = blocksOnOppositeSwitch;
    }

    public int getBlocksOnScale() {
        return blocksOnScale;
    }

    public void setBlocksOnScale(int blocksOnScale) {
        this.blocksOnScale = blocksOnScale;
    }

    public int getBlocksInVault() {
        return blocksInVault;
    }

    public void setBlocksInVault(int blocksInVault) {
        this.blocksInVault = blocksInVault;
    }

    public int getAttemptedClimb() {
        return attemptedClimb;
    }

    public void setAttemptedClimb(int attemptedClimb) {
        this.attemptedClimb = attemptedClimb;
    }

    public int getCompletedClimb() {
        return completedClimb;
    }

    public void setCompletedClimb(int completedClimb) {
        this.completedClimb = completedClimb;
    }

    public int getParkedOnRamp() {
        return parkedOnRamp;
    }

    public void setParkedOnRamp(int parkedOnRamp) {
        this.parkedOnRamp = parkedOnRamp;
    }

    public int getPilePowerCube() {
        return pilePowerCube;
    }

    public void setPilePowerCube(int pilePowerCube) {
        this.pilePowerCube = pilePowerCube;
    }

    public int getSwitchPowerCube() {
        return switchPowerCube;
    }

    public void setSwitchPowerCube(int switchPowerCube) {
        this.switchPowerCube = switchPowerCube;
    }

    public int getExchangePowerCube() {
        return exchangePowerCube;
    }

    public void setExchangePowerCube(int exchangePowerCube) {
        this.exchangePowerCube = exchangePowerCube;
    }

    public int getPortalPowerCube() {
        return portalPowerCube;
    }

    public void setPortalPowerCube(int portalPowerCube) {
        this.portalPowerCube = portalPowerCube;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public void setDefensiveRating(int defensiveRating) {
        this.defensiveRating = defensiveRating;
    }

    public int getRegularFoul() {
        return regularFoul;
    }

    public void setRegularFoul(int regularFoul) {
        this.regularFoul = regularFoul;
    }

    public int getTechFoul() {
        return techFoul;
    }

    public void setTechFoul(int techFoul) {
        this.techFoul = techFoul;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }
}
