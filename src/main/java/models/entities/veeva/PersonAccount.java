package models.entities.veeva;

import csv.Column;
import models.entities.Entity;

public class PersonAccount extends Entity {
    @Column(name = "id")
    public String id;
    @Column(name = "primary_parent_vod__c")
    public String primaryParentVodC;
    @Column(name = "reg_verification_status__c")
    public String regVerificationStatusC;

}