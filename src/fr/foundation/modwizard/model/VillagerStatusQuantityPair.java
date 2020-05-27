package fr.foundation.modwizard.model;

public class VillagerStatusQuantityPair {
    String DataType = "VILLAGER_STATUS_QUANTITY_PAIR";
    String Status;
    int quantity = 0;// (default: 0),

    public VillagerStatusQuantityPair(String status, int quantity) {
        Status = status;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " \n\t{ Status= \"" + Status + "\" ,"+
                " quantity= " + quantity +
                "}";
    }
}
