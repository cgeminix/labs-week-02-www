package vn.edu.iuh.fit.labsweek02www.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    In_ACTIVE(0),
    TERMINATED(-1);
    private int value;
    EmployeeStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
