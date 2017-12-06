package model;

public class Turn {
    private Integer opportunityMax;

    public Turn(Integer opportunityMax) {
        super();
        this.opportunityMax = opportunityMax;
    }

    public Integer getOpportunityMax(Integer opportunityPresent) {
        System.out.println("Intento #"+(opportunityMax-opportunityPresent));
        return opportunityPresent;
    }
}
