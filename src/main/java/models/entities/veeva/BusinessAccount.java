package models.entities.veeva;

import csv.Column;
import models.Has;
import models.entities.Entity;

import java.util.ArrayList;

public class BusinessAccount extends Entity {
    @Column(name = "name")
    public String name;
    @Column(name = "id")
    public String id;
    @Column(name = "reg_verification_status__c")
    public String regVerificationStatusC;

    @Has(childClass = PersonAccount.class, childFieldName = "primaryParentVodC", parentFieldName = "id")
    public ArrayList<PersonAccount> personAccounts;
}
