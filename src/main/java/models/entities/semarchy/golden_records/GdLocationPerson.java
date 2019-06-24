package models.entities.semarchy.golden_records;

import csv.Column;

public class GdLocationPerson {
    @Column(name = "location_personid")
    public String locationPersonid;

    @Column(name = "b_classname")
    public String bClassname;

    @Column(name = "b_pubid")
    public String bPubid;

    @Column(name = "b_sourceid")
    public String bSourceid;

    @Column(name = "b_batchid")
    public Integer bBatchid;

    @Column(name = "b_goldentype")
    public String bGoldentype;

    @Column(name = "b_masterscount")
    public Integer bMasterscount;

    @Column(name = "b_hasoverride")
    public Boolean bHasoverride;

    @Column(name = "b_error_status")
    public String bErrorStatus;

    @Column(name = "b_isconfirmed")
    public Boolean bIsconfirmed;

    @Column(name = "b_confscore")
    public Integer bConfscore;

    @Column(name = "b_confirmationstatus")
    public String bConfirmationstatus;

    @Column(name = "b_hassuggmerge")
    public Boolean bHassuggmerge;

    @Column(name = "b_suggmergeid")
    public Integer bSuggmergeid;

    @Column(name = "b_suggmergeconfscore")
    public Integer bSuggmergeconfscore;

    @Column(name = "b_suggmergemasterscount")
    public Integer bSuggmergemasterscount;

    @Column(name = "b_credate")
    public String bCredate;

    @Column(name = "b_upddate")
    public String bUpddate;

    @Column(name = "b_creator")
    public String bCreator;

    @Column(name = "b_updator")
    public String bUpdator;

    @Column(name = "relationship_type")
    public String relationshipType;

    @Column(name = "relationship_status")
    public String relationshipStatus;

    @Column(name = "f_reg_id")
    public String fRegId;

    @Column(name = "fp_reg_id")
    public String fpRegId;

    @Column(name = "fs_reg_id")
    public String fsRegId;

    @Column(name = "f_location_id")
    public String fLocationId;

    @Column(name = "fp_location_id")
    public String fpLocationId;

    @Column(name = "fs_location_id")
    public String fsLocationId;
}
