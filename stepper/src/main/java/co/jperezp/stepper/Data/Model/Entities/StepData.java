package co.jperezp.stepper.Data.Model.Entities;

public class StepData {

    private String stepText;
    private String optionaText;
    private Boolean active;

    public StepData() {
    }

    public StepData(String stepText, String optionaText, Boolean active) {
        this.stepText = stepText;
        this.optionaText = optionaText;
        this.active = active;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    public String getOptionaText() {
        return optionaText;
    }

    public void setOptionaText(String optionaText) {
        this.optionaText = optionaText;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
