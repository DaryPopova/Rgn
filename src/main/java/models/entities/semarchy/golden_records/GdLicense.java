package models.entities.semarchy.golden_records;

import csv.Column;

public class GdLicense {
    @Column(name = "licenseid")
    public String licenseid;

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

    @Column(name = "license_number")
    public String licenseNumber;

    @Column(name = "expiration_date")
    public String expirationDate;

    @Column(name = "adjusted_expiration_date")
    public String adjustedExpirationDate;

    @Column(name = "source_system_name")
    public String sourceSystemName;

    @Column(name = "source_system_ext_id")
    public String sourceSystemExtId;

    @Column(name = "status")
    public String status;

    @Column(name = "state")
    public String state;

    @Column(name = "restricted_state")
    public String restrictedState;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "credentials")
    public String credentials;

    @Column(name = "speciality")
    public String speciality;

    @Column(name = "secondary_speciality")
    public String secondarySpeciality;

    @Column(name = "f_reg_id")
    public String fRegId;

    @Column(name = "fp_reg_id")
    public String fpRegId;

    @Column(name = "fs_reg_id")
    public String fsRegId;
}
