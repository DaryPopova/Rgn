package models.entities.semarchy;

import csv.Column;

public class SdOrgExtIdentifier {
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

    @Column(name = "identifier_type")
    public String identifierType;

    @Column(name = "identifier_value")
    public String identifierValue;

    @Column(name = "f_org_id")
    public String fOrgId;

    @Column(name = "fp_org_id")
    public String fpOrgId;

    @Column(name = "fs_org_id")
    public String fsOrgId;

    @Column(name = "fd_org_id")
    public String fdOrgId;
}
