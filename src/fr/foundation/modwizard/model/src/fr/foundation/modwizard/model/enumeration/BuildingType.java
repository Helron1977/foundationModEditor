package fr.foundation.modwizard.model.enumeration;

import fr.foundation.modwizard.model.Model;

public enum BuildingType {
    GENERAL,
    MONUMENT,
    DECORATION,
    HOUSING;

    public static String[] toStringList() {
        BuildingType[] temp = BuildingType.values();
        String[] enumListValues = new String[temp.length];
        for(int i=0; i<temp.length; i++) {
            enumListValues[i] = temp[i].toString();
        }

        return enumListValues ;
    }
}
