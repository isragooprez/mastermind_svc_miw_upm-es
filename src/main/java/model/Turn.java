package model;

import util.IO;

public class Turn {
    private Integer opportunityValueMax;
    private IO io;

    public Turn(Integer opportunityMax) {
        super();
        this.opportunityValueMax = opportunityMax;
        io= new IO();
    }

    public Integer getOpportunityMax(Integer opportunityPresent) {
       io.writeln("Intento: #"+(opportunityValueMax-opportunityPresent));
        return opportunityPresent;
    }
}
