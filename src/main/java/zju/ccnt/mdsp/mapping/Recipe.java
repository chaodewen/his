package zju.ccnt.mdsp.mapping;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by Dewayne on 2016/12/19.
 */
public class Recipe {
    private int id;
    private Date rdate;
    private String name;
    private Integer gender;
    private Integer age;
    private String recordId;
    private String address;
    private String diagnosis;
    private String doctor;
    private Double charge;
    private String checker;
    private Collection<DrugItem> drugItemsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (rdate != null ? !rdate.equals(recipe.rdate) : recipe.rdate != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (gender != null ? !gender.equals(recipe.gender) : recipe.gender != null) return false;
        if (age != null ? !age.equals(recipe.age) : recipe.age != null) return false;
        if (recordId != null ? !recordId.equals(recipe.recordId) : recipe.recordId != null) return false;
        if (address != null ? !address.equals(recipe.address) : recipe.address != null) return false;
        if (diagnosis != null ? !diagnosis.equals(recipe.diagnosis) : recipe.diagnosis != null) return false;
        if (doctor != null ? !doctor.equals(recipe.doctor) : recipe.doctor != null) return false;
        if (charge != null ? !charge.equals(recipe.charge) : recipe.charge != null) return false;
        if (checker != null ? !checker.equals(recipe.checker) : recipe.checker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rdate != null ? rdate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (recordId != null ? recordId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        result = 31 * result + (checker != null ? checker.hashCode() : 0);
        return result;
    }

    public Collection<DrugItem> getDrugItemsById() {
        return drugItemsById;
    }

    public void setDrugItemsById(Collection<DrugItem> drugItemsById) {
        this.drugItemsById = drugItemsById;
    }
}
