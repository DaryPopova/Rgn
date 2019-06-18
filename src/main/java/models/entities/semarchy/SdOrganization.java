package models.entities.semarchy;

import csv.Column;
import models.Has;

import java.util.ArrayList;

public class SdOrganization {
    @Column(name = "b_loadid")
    public Integer bLoadid;

    @Column(name = "b_pubid")
    public String bPubid;

    @Column(name = "b_sourceid")
    public String bSourceid;

    @Column(name = "b_classname")
    public String bClassname;

    @Column(name = "b_error_status")
    public String bErrorStatus;

    @Column(name = "b_originalbatchid")
    public Integer bOriginalbatchid;

    @Column(name = "b_operationid")
    public String bOperationid;

    @Column(name = "b_deletetype")
    public String bDeletetype;

    @Column(name = "b_deletedate")
    public String bDeletedate;

    @Column(name = "b_deleteauthor")
    public String bDeleteauthor;

    @Column(name = "b_deleteoperation")
    public String bDeleteoperation;

    @Column(name = "b_deletepath")
    public String bDeletepath;

    @Column(name = "b_credate")
    public String bCredate;

    @Column(name = "b_upddate")
    public String bUpddate;

    @Column(name = "b_creator")
    public String bCreator;

    @Column(name = "b_updator")
    public String bUpdator;

    @Column(name = "legal_business_name")
    public String legalBusinessName;

    @Column(name = "dba_name")
    public String dbaName;

    @Column(name = "verification_status")
    public String verificationStatus;

    @Column(name = "account_type")
    public String accountType;

    @Column(name = "account_sub_type")
    public String accountSubType;

    @Column(name = "account_status")
    public String accountStatus;

    @Column(name = "class_of_trade_rgn")
    public String classOfTradeRgn;

    @Column(name = "class_of_trade_ims")
    public String classOfTradeIms;

    @Has(pairsOfParentAndChildFields = {"b_pubid|fp_org_id", "b_sourceid|fs_org_id"})
    public ArrayList<SdOrgExtIdentifier> sdOrgExtIdentifiers;
}
