package pl.klab.catalogue.domain;

public enum ItemType {
    LP("Long Play"),
    CD("Compact Disc");

    String itemCode;

    private ItemType(String code) {
        this.itemCode = code;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
