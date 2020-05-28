package fr.foundation.modwizard.model;



import java.util.ArrayList;

public class Building extends Model {

    String dataType = "BUILDING";
    String id = "GALLOWS_01";
    String name = "string";
    String description = "string";
    String orderId = "0"; //Optional
    String buildingType = "GENERAL"; //default: GENERAL
    ArrayList<BuildingPartSet> buildingPartSet ;
    String buildingModel = "PROJECT_PREFAB" ;//name of a previous declared PREFAB (default: nil)
    ArrayList<VillagerStatusQuantityPair> villagerRequired; // (default: nil)
    String desirabilityLayer =""; //DESIRABILITY (default: nil)
    boolean isManuallyUnlocked = false; //boolean (default: false)
    boolean isDestructible = true; //boolean (default: true)
    boolean isEditable = false; //boolean (default: false)
    boolean isHidden = false; //boolean (default: false)
    boolean isClearTrees = false; //default: false
    // ArrayList<MaterialSet> materialSetArrayList; //Optional underConstruction


    public Building(String dataType, String id, String name, String description, String orderId, String buildingType,
                    ArrayList<BuildingPartSet> buildingPartSet, String buildingModel, ArrayList<VillagerStatusQuantityPair> villagerRequired) {
        //, String desirabilityLayer,
        //                    boolean isManuallyUnlocked, boolean isDestructible, boolean isEditable, boolean isHidden, boolean isClearTrees
        this.dataType = dataType;
        this.id = id;
        this.name = name;
        this.description = description;
        this.orderId = orderId;
        this.buildingType = buildingType;
        this.buildingPartSet = buildingPartSet;
        this.buildingModel = buildingModel;
        this.villagerRequired = villagerRequired;
        this.desirabilityLayer = desirabilityLayer;
        this.isManuallyUnlocked = isManuallyUnlocked;
        this.isDestructible = isDestructible;
        this.isEditable = isEditable;
        this.isHidden = isHidden;
        this.isClearTrees = isClearTrees;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public void setBuildingPartSet(ArrayList<BuildingPartSet> buildingPartSet) {
        this.buildingPartSet = buildingPartSet;
    }

    public void setBuildingModel(String buildingModel) {
        this.buildingModel = buildingModel;
    }

    public void setVillagerRequired(ArrayList<VillagerStatusQuantityPair> villagerRequired) {
        this.villagerRequired = villagerRequired;
    }

    public void setDesirabilityLayer(String desirabilityLayer) {
        this.desirabilityLayer = desirabilityLayer;
    }

    public void setManuallyUnlocked(boolean manuallyUnlocked) {
        isManuallyUnlocked = manuallyUnlocked;
    }

    public void setDestructible(boolean destructible) {
        isDestructible = destructible;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void setClearTrees(boolean clearTrees) {
        isClearTrees = clearTrees;
    }

    public Building() {

    }

    @Override
    public String toString() {
        return null;
    }

}
