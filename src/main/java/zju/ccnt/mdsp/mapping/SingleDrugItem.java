package zju.ccnt.mdsp.mapping;

/**
 * Created by Dewayne on 2016/12/19.
 */
public class SingleDrugItem {
    private int id;
    private Integer drugItemId;
    private String name;
    private String purchaseUnit;
    private Double purchaseQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDrugItemId() {
        return drugItemId;
    }

    public void setDrugItemId(Integer drugItemId) {
        this.drugItemId = drugItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public Double getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Double purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleDrugItem that = (SingleDrugItem) o;

        if (id != that.id) return false;
        if (drugItemId != null ? !drugItemId.equals(that.drugItemId) : that.drugItemId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (purchaseUnit != null ? !purchaseUnit.equals(that.purchaseUnit) : that.purchaseUnit != null) return false;
        if (purchaseQuantity != null ? !purchaseQuantity.equals(that.purchaseQuantity) : that.purchaseQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (drugItemId != null ? drugItemId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (purchaseUnit != null ? purchaseUnit.hashCode() : 0);
        result = 31 * result + (purchaseQuantity != null ? purchaseQuantity.hashCode() : 0);
        return result;
    }
}
