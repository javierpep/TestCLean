package co.jperezp.stepper.ViewModel;

import android.content.Context;

import androidx.appcompat.view.menu.MenuAdapter;
import androidx.lifecycle.ViewModel;
import java.util.List;

import co.jperezp.stepper.Data.Interfaces.onStepClick;
import co.jperezp.stepper.Data.Model.Entities.StepData;
import co.jperezp.stepper.Domain.Adapters.StepAdapter;
import co.jperezp.stepper.Domain.Usecases.StepRepository;

public class StepperViewModel extends ViewModel {

    public StepAdapter getStepAdapter(onStepClick callback, Context ctx){
        return new StepAdapter(callback, ctx);
    }

    public List<StepData> getTestSteps(){
        return StepRepository.getInstance().getTestSteps();
    }

}
