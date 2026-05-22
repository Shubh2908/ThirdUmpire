package com.TU.score_service.dto;

public class ScoreUpdateDTO {

    private Long matchId;
    private int runs;
    private int wickets;
    private double overs;

    public ScoreUpdateDTO() {
    }

    public ScoreUpdateDTO(Long matchId,
                          int runs,
                          int wickets,
                          double overs) {

        this.matchId = matchId;
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
