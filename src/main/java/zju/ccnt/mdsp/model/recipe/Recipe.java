package zju.ccnt.mdsp.model.recipe;

import java.util.Date;
import java.util.List;

/**
 * Created by Cc on 2016/12/15.
 */

public class Recipe {
    private String no;
    private Date date;
    private String name;
    private int gender;
    private int age;
    // 接诊编号
    private String recordId;
    private String address;
    private String diagnosis;
    private String doctor;
    private double charge;
    private String checker;
    private List<DrugItem> drugItems;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public List<DrugItem> getDrugItems() {
        return drugItems;
    }

    public void setDrugItems(List<DrugItem> drugItems) {
        this.drugItems = drugItems;
    }
}