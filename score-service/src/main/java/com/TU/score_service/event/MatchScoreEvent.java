package com.TU.score_service.event;

public class MatchScoreEvent {

    private Long matchId;
    private String team;
    private int runs;
    private int wickets;
    private double overs;

    public MatchScoreEvent() {
    }

    public MatchScoreEvent(Long matchId,
                           String team,
                           int runs,
                           int wickets,
                           double overs) {

        this.matchId = matchId;
        this.team = team;
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }
}
