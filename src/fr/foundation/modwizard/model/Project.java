package fr.foundation.modwizard.model;

public class Project extends Model{
    private String modName;
    private String fbxName;

    public Project(String modName, String fbxName) {
        this.modName = modName;
        this.fbxName = fbxName;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }

    public String getFbxName() {
        return fbxName;
    }

    public void setFbxName(String fbxName) {
        this.fbxName = fbxName;
    }


    @Override
    public String generateCode() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
