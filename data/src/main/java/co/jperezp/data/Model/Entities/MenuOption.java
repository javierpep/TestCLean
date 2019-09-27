package co.jperezp.data.Model.Entities;

public class MenuOption {
    private String text;
    private int idAnimation;

    public MenuOption() {
    }

    public MenuOption(String text, int idAnimation) {
        this.text = text;
        this.idAnimation = idAnimation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdAnimation() {
        return idAnimation;
    }

    public void setIdAnimation(int idAnimation) {
        this.idAnimation = idAnimation;
    }
}
