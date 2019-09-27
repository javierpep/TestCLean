package co.jperezp.stepper.Domain.Usecases;


import java.util.List;

import co.jperezp.stepper.Data.Local.StepsSource;
import co.jperezp.stepper.Data.Model.Entities.StepData;

public class StepRepository {
    private static final StepRepository ourInstance = new StepRepository();

    public static StepRepository getInstance() {
        return ourInstance;
    }

    private StepRepository() {
    }

    public List<StepData> getTestSteps(){
        return StepsSource.getInstance().getStepsList();
    }
}
