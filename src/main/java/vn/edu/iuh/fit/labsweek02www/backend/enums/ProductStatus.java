package vn.edu.iuh.fit.labsweek02www.backend.enums;

public enum ProductStatus {
    ACTIVE(1),
    In_ACTIVE(0),
    TERMINATED(-1);
    private int value;
    ProductStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
