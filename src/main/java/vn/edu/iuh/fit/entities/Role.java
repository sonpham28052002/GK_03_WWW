package vn.edu.iuh.fit.entities;

public enum Role {
    ADMINISTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
