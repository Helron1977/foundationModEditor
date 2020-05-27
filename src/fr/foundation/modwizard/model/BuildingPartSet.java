package fr.foundation.modwizard.model;

import java.util.ArrayList;

public class BuildingPartSet {

    String dataType = "BUILDING_PART_SET";
    String name = "string";
    ArrayList<String> buildingPartList ;

    public BuildingPartSet(String name, ArrayList<String> buildingPartArrayList) {
        this.name = name;
        this.buildingPartList = buildingPartArrayList;
    }

    @Override
    public String toString() {
        return "{ \n\t name = \""+ name + "\","+
                "\t buildingPartList= " + buildingPartList +
                '}';
    }
}
