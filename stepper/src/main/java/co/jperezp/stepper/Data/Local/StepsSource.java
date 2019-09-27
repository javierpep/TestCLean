package co.jperezp.stepper.Data.Local;

import java.util.ArrayList;
import java.util.List;

import co.jperezp.stepper.Data.Model.Entities.StepData;

public class StepsSource {
    private static final StepsSource ourInstance = new StepsSource();

    public static StepsSource getInstance() {
        return ourInstance;
    }

    private StepsSource() {
    }

    public List<StepData> getStepsList(){
        ArrayList<StepData> listSteps;
        listSteps = new ArrayList<>();
        listSteps.add(new StepData("Inicio", "", true));
        listSteps.add(new StepData("Acción", "Opcional", true));
        listSteps.add(new StepData("Acción", "Opcional", true));
        listSteps.add(new StepData("Fin", "", false));
        return listSteps;
    }
}
