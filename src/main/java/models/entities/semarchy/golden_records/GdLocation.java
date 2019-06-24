package models.entities.semarchy.golden_records;

import csv.Column;

public class GdLocation {
    @Column(name = "locationid")
    public String locationid;

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

    @Column(name = "location_id")
    public String locationId;

    @Column(name = "location_type")
    public String locationType;

    @Column(name = "address_line_1")
    public String addressLine1;

    @Column(name = "address_line_2")
    public String addressLine2;

    @Column(name = "address_line_3")
    public String addressLine3;

    @Column(name = "address_line_4")
    public String addressLine4;

    @Column(name = "zip")
    public String zip;

    @Column(name = "zip4")
    public String zip4;

    @Column(name = "country")
    public String country;

    @Column(name = "state")
    public String state;

    @Column(name = "county")
    public String county;

    @Column(name = "city")
    public String city;

    @Column(name = "f_org_id")
    public String fOrgId;

    @Column(name = "fp_org_id")
    public String fpOrgId;

    @Column(name = "fs_org_id")
    public String fsOrgId;
}
