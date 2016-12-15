package zju.ccnt.mdsp.model.recipe;

import java.util.List;

/**
 * Created by Cc on 2016/12/15.
 */

public class DrugItem {
    private String drug;
    private List<SingleDrugItem> singleDrugItems;
    private String dosageUnit;
    private int dosageQuantity;
    private int timePerDay;
    private String note;

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public List<SingleDrugItem> getSingleDrugItems() {
        return singleDrugItems;
    }

    public void setSingleDrugItems(List<SingleDrugItem> singleDrugItems) {
        this.singleDrugItems = singleDrugItems;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public int getDosageQuantity() {
        return dosageQuantity;
    }

    public void setDosageQuantity(int dosageQuantity) {
        this.dosageQuantity = dosageQuantity;
    }

    public int getTimePerDay() {
        return timePerDay;
    }

    public void setTimePerDay(int timePerDay) {
        this.timePerDay = timePerDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}