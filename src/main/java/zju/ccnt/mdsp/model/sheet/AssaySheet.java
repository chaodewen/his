package zju.ccnt.mdsp.model.sheet;

import java.util.Date;
import java.util.List;

/**
 * Created by Cc on 2016/12/15.
 */

public class AssaySheet {
    private String no;
    private String assayItem;
    private String patientName;
    // 接诊编号
    private String recordId;
    private String sampleType;
    private int gender;
    private String department;
    private String sampleCondition;
    private int age;
    // 送检医师
    private String demander;
    // 检验员
    private String coroner;
    private String checker;
    private String note;
    private Date assayDate;
    private Date finishDate;
    private List<AssayItem> assayItems;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getAssayItem() {
        return assayItem;
    }

    public void setAssayItem(String assayItem) {
        this.assayItem = assayItem;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSampleCondition() {
        return sampleCondition;
    }

    public void setSampleCondition(String sampleCondition) {
        this.sampleCondition = sampleCondition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDemander() {
        return demander;
    }

    public void setDemander(String demander) {
        this.demander = demander;
    }

    public String getCoroner() {
        return coroner;
    }

    public void setCoroner(String coroner) {
        this.coroner = coroner;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getAssayDate() {
        return assayDate;
    }

    public void setAssayDate(Date assayDate) {
        this.assayDate = assayDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public List<AssayItem> getAssayItems() {
        return assayItems;
    }

    public void setAssayItems(List<AssayItem> assayItems) {
        this.assayItems = assayItems;
    }
}