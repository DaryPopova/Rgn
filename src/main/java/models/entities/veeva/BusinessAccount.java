package models.entities.veeva;

import csv.Column;
import models.Has;
import models.entities.Entity;

import java.util.ArrayList;

public class BusinessAccount extends Entity {
    @Column(name = "account_type__c")
    public String accountTypeC;

    @Column(name = "reg_account_status__c")
    public String regAccountStatusC;

    @Column(name = "do_not_call_vod__c")
    public String doNotCallVodC;

    @Column(name = "name")
    public String name;

    @Column(name = "reg_cct_id__c")
    public String regCctIdC;

    @Column(name = "reg_class_of_trade_code__c")
    public String regClassOfTradeCodeC;

    @Column(name = "reg_class_of_trade__c")
    public String regClassOfTradeC;

    @Column(name = "reg_cms_teaching_hospital__c")
    public String regCmsTeachingHospitalC;

    @Column(name = "reg_ei_id__c")
    public String regEiIdC;

    @Column(name = "fax")
    public String fax;

    @Column(name = "hospital_type_vod__c")
    public String hospitalTypeVodC;

    @Column(name = "id")
    public String id;

    @Column(name = "reg_ims_id__c")
    public String regImsIdC;

    @Column(name = "phone")
    public String phone;

    @Column(name = "recordtypeid")
    public String recordtypeid;

    @Column(name = "reg_regid__c")
    public String regRegidC;

    @Column(name = "website")
    public String website;

    @Column(name = "reg_co_pay_assistance__c")
    public String regCoPayAssistanceC;

    @Column(name = "reg_hub_service__c")
    public String regHubServiceC;

    @Column(name = "reg_lunches__c")
    public String regLunchesC;

    @Column(name = "reg_payer_1__c")
    public String regPayer1C;

    @Column(name = "reg_payer_2__c")
    public String regPayer2C;

    @Column(name = "reg_payer_3__c")
    public String regPayer3C;

    @Column(name = "reg_injection_training_lead__c")
    public String regInjectionTrainingLeadC;

    @Column(name = "reg_insurance_prior_authorizations_lead__c")
    public String regInsurancePriorAuthorizationsLeadC;

    @Column(name = "reg_patient_follow_up_lead__c")
    public String regPatientFollowUpLeadC;

    @Column(name = "reg_access_lead_contact__c")
    public String regAccessLeadContactC;

    @Column(name = "reg_preferred_specialty_pharmacies__c")
    public String regPreferredSpecialtyPharmaciesC;

    @Column(name = "reg_infusions__c")
    public String regInfusionsC;

    @Column(name = "reg_of_infusions_in_their_practice__c")
    public String regOfInfusionsInTheirPracticeC;

    @Column(name = "reg_credentialing_required__c")
    public String regCredentialingRequiredC;

    @Column(name = "reg_credentialing_service__c")
    public String regCredentialingServiceC;

    @Column(name = "reg_demographics__c")
    public String regDemographicsC;

    @Column(name = "reg_disease_awareness__c")
    public String regDiseaseAwarenessC;

    @Column(name = "reg_office_manager__c")
    public String regOfficeManagerC;

    @Column(name = "reg_patient_education_needs_lead__c")
    public String regPatientEducationNeedsLeadC;

    @Column(name = "reg_preferred_spp_reason__c")
    public String regPreferredSppReasonC;

    @Column(name = "reg_receptionist__c")
    public String regReceptionistC;

    @Column(name = "reg_role__c")
    public String regRoleC;

    @Column(name = "reg_state_payer__c")
    public String regStatePayerC;

    @Column(name = "primary_parent_vod__c")
    public String primaryParentVodC;

    @Column(name = "reg_340b__c")
    public String reg340bC;

    @Column(name = "reg_sample_lead__c")
    public String regSampleLeadC;

    @Column(name = "reg_allows_samples__c")
    public String regAllowsSamplesC;

    @Column(name = "reg_verification_status__c")
    public String regVerificationStatusC;

    @Column(name = "reg_sample_lead_email__c")
    public String regSampleLeadEmailC;

    @Column(name = "reg_sample_lead_fax__c")
    public String regSampleLeadFaxC;

    @Column(name = "reg_sample_lead_phone__c")
    public String regSampleLeadPhoneC;

    @Column(name = "reg_appeals_lead__c")
    public String regAppealsLeadC;

    @Column(name = "reg_other_preferred_specialty_pharmacies__c")
    public String regOtherPreferredSpecialtyPharmaciesC;

    @Column(name = "reg_other_payer__c")
    public String regOtherPayerC;

    @Column(name = "reg_other_payer_2__c")
    public String regOtherPayer2C;

    @Column(name = "reg_created_by_profile_name__c")
    public String regCreatedByProfileNameC;

    @Column(name = "reg_promotional_material_allowed__c")
    public String regPromotionalMaterialAllowedC;

    @Column(name = "reg_emr__c")
    public String regEmrC;

    @Column(name = "reg_email__c")
    public String regEmailC;

    @Column(name = "reg_last_modified_by_profile__c")
    public String regLastModifiedByProfileC;

    @Column(name = "reg_dupi_allows_samples__c")
    public String regDupiAllowsSamplesC;

    @Column(name = "reg_dupi_lunches__c")
    public String regDupiLunchesC;

    @Column(name = "reg_dupi_disease_awareness__c")
    public String regDupiDiseaseAwarenessC;

    @Column(name = "reg_dupi_co_pay_assistance__c")
    public String regDupiCoPayAssistanceC;

    @Column(name = "reg_dupi_promotional_material_allowed__c")
    public String regDupiPromotionalMaterialAllowedC;

    @Column(name = "reg_derm_credentialing_required__c")
    public String regDermCredentialingRequiredC;

    @Column(name = "reg_derm_credentialing_service__c")
    public String regDermCredentialingServiceC;

    @Column(name = "reg_dupi_demographics__c")
    public String regDupiDemographicsC;

    @Column(name = "reg_dermatology_segment__c")
    public String regDermatologySegmentC;

    @Column(name = "reg_dermatology_target__c")
    public String regDermatologyTargetC;

    @Column(name = "reg_associated_products__c")
    public String regAssociatedProductsC;

    @Column(name = "reg_rheumatology_target__c")
    public String regRheumatologyTargetC;

    @Column(name = "reg_rheumatology_tier__c")
    public String regRheumatologyTierC;

    @Column(name = "reg_cardio_metabolic_tier__c")
    public String regCardioMetabolicTierC;

    @Column(name = "reg_ophthalmology_tier__c")
    public String regOphthalmologyTierC;

    @Column(name = "reg_immunology_tier__c")
    public String regImmunologyTierC;

    @Column(name = "reg_cardio_metabolic_target__c")
    public String regCardioMetabolicTargetC;

    @Column(name = "reg_ophthalmology_target__c")
    public String regOphthalmologyTargetC;

    @Column(name = "reg_immunology_target__c")
    public String regImmunologyTargetC;

    @Column(name = "reg_respiratory_tier__c")
    public String regRespiratoryTierC;

    @Column(name = "reg_pain_tier__c")
    public String regPainTierC;

    @Column(name = "reg_oncology_tier__c")
    public String regOncologyTierC;

    @Column(name = "reg_ta4_tier__c")
    public String regTa4TierC;

    @Column(name = "reg_ta5_tier__c")
    public String regTa5TierC;

    @Column(name = "reg_respiratory_target__c")
    public String regRespiratoryTargetC;

    @Column(name = "reg_pain_target__c")
    public String regPainTargetC;

    @Column(name = "reg_oncology_target__c")
    public String regOncologyTargetC;

    @Column(name = "reg_ta4_target__c")
    public String regTa4TargetC;

    @Column(name = "reg_ta5_target__c")
    public String regTa5TargetC;

    @Column(name = "reg_veevaext__c")
    public String regVeevaextC;

    @Column(name = "reg_office_champion__c")
    public String regOfficeChampionC;

    @Column(name = "reg_derm_triage_process__c")
    public String regDermTriageProcessC;

    @Column(name = "reg_derm_preferred_specialty_pharmacies__c")
    public String regDermPreferredSpecialtyPharmaciesC;

    @Column(name = "reg_derm_other_preferred_specialty_pharm__c")
    public String regDermOtherPreferredSpecialtyPharmC;

    @Column(name = "reg_derm_receptionist__c")
    public String regDermReceptionistC;

    @Column(name = "reg_derm_office_manager__c")
    public String regDermOfficeManagerC;

    @Column(name = "reg_derm_insurance_prior_auth_lead__c")
    public String regDermInsurancePriorAuthLeadC;

    @Column(name = "reg_derm_injection_training_lead__c")
    public String regDermInjectionTrainingLeadC;

    @Column(name = "reg_derm_patient_followup_copaycard_lead__c")
    public String regDermPatientFollowupCopaycardLeadC;

    @Column(name = "reg_derm_patient_education_lead__c")
    public String regDermPatientEducationLeadC;

    @Column(name = "reg_dermatology_emr__c")
    public String regDermatologyEmrC;

    @Column(name = "reg_derm_billing_director__c")
    public String regDermBillingDirectorC;


    @Has(pairsOfParentAndChildFields = {"primaryParentVodC|id"})
    public ArrayList<PersonAccount> personAccounts;
}