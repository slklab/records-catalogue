package pl.klab.catalogue.domain;

public enum ItemType {
    LONG_PLAY("LP"),
    COMPACT_DISC("CD");

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
