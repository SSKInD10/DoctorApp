package com.sskind.doctor;

public class Patient {

    private String name;
    private String age;
    private String gender,symptom,pre_diagnosis,curr_diagnosis,drug_name1,drug_name2,dosage1,dosage2;
    private String dosage3,drug_name3,duration1,duration2,duration3,advice;

    public Patient(String name, String age, String gender, String symptom, String pre_diagnosis, String curr_diagnosis, String drug_name1, String drug_name2, String dosage1, String dosage2, String dosage3, String drug_name3, String duration1, String duration2, String duration3, String advice) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.symptom = symptom;
        this.pre_diagnosis = pre_diagnosis;
        this.curr_diagnosis = curr_diagnosis;
        this.drug_name1 = drug_name1;
        this.drug_name2 = drug_name2;
        this.dosage1 = dosage1;
        this.dosage2 = dosage2;
        this.dosage3 = dosage3;
        this.drug_name3 = drug_name3;
        this.duration1 = duration1;
        this.duration2 = duration2;
        this.duration3 = duration3;
        this.advice = advice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getPre_diagnosis() {
        return pre_diagnosis;
    }

    public void setPre_diagnosis(String pre_diagnosis) {
        this.pre_diagnosis = pre_diagnosis;
    }

    public String getCurr_diagnosis() {
        return curr_diagnosis;
    }

    public void setCurr_diagnosis(String curr_diagnosis) {
        this.curr_diagnosis = curr_diagnosis;
    }

    public String getDrug_name1() {
        return drug_name1;
    }

    public void setDrug_name1(String drug_name1) {
        this.drug_name1 = drug_name1;
    }

    public String getDrug_name2() {
        return drug_name2;
    }

    public void setDrug_name2(String drug_name2) {
        this.drug_name2 = drug_name2;
    }

    public String getDosage1() {
        return dosage1;
    }

    public void setDosage1(String dosage1) {
        this.dosage1 = dosage1;
    }

    public String getDosage2() {
        return dosage2;
    }

    public void setDosage2(String dosage2) {
        this.dosage2 = dosage2;
    }

    public String getDosage3() {
        return dosage3;
    }

    public void setDosage3(String dosage3) {
        this.dosage3 = dosage3;
    }

    public String getDrug_name3() {
        return drug_name3;
    }

    public void setDrug_name3(String drug_name3) {
        this.drug_name3 = drug_name3;
    }

    public String getDuration1() {
        return duration1;
    }

    public void setDuration1(String duration1) {
        this.duration1 = duration1;
    }

    public String getDuration2() {
        return duration2;
    }

    public void setDuration2(String duration2) {
        this.duration2 = duration2;
    }

    public String getDuration3() {
        return duration3;
    }

    public void setDuration3(String duration3) {
        this.duration3 = duration3;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
