package zju.ccnt.mdsp.model.recipe;

/**
 * Created by Cc on 2016/12/15.
 */

public class SingleDrugItem {
    private String purchaseUnit;
    private int purchaseQuantity;

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}