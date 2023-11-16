package org.example;

public class Train {
    private int id;
    private String name;
    private int cartCount;
    private int maxSpeed;
    private boolean inUse;

    public Train(int id, String name, int cartCount, int maxSpeed, boolean inUse) {
        this.id = id;
        this.name = name;
        this.cartCount = cartCount;
        this.maxSpeed = maxSpeed;
        this.inUse = inUse;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"cartCount\":" + cartCount +
                ", \"maxSpeed\":" + maxSpeed +
                ", \"inUse\":" + inUse +
                '}';
    }

    public String getCSV() {
        return id + "," + name + "," + cartCount + "," + maxSpeed + "," + inUse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
