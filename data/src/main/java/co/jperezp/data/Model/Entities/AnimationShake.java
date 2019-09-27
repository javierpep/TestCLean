package co.jperezp.data.Model.Entities;

public class AnimationShake {

    private String name;
    private int rawId;

    public AnimationShake() {
    }

    public AnimationShake(String name, int rawName) {
        this.name = name;
        this.rawId = rawName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRawId() {
        return rawId;
    }

    public void setRawId(int rawId) {
        this.rawId = rawId;
    }
}
