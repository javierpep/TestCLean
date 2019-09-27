package co.jperezp.testclean.ViewModels;

import androidx.lifecycle.ViewModel;
import java.util.List;

import co.jperezp.stepper.Data.Model.Entities.StepData;
import co.jperezp.stepper.Domain.Usecases.StepRepository;

public class StepperTestViewModel extends ViewModel {

    public List<StepData> getTestSteps(){
        return StepRepository.getInstance().getTestSteps();
    }
}
