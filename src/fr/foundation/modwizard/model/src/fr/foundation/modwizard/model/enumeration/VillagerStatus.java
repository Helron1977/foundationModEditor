package fr.foundation.modwizard.model.enumeration;

public enum VillagerStatus {
    CITIZEN,
    COMMONER,
    MONK,
    MONK_PRIOR,
    NEWCOMER,
    SERF,
    SOLDIER_KNIGHT,
    SOLDIER_ROOKIE,
    SOLDIER_SOLDIER;

    public static String[] toStringList() {
        VillagerStatus[] temp = VillagerStatus.values();
        String[] enumValues = new String[temp.length];
        for(int i=0; i<temp.length; i++) {
            enumValues[i] = temp[i].toString();
        }

        return enumValues ;
    }
}
