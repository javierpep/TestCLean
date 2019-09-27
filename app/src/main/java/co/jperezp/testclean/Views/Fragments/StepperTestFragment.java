package co.jperezp.testclean.Views.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.jperezp.stepper.Data.Interfaces.onStepClick;
import co.jperezp.stepper.Data.Model.Entities.StepData;
import co.jperezp.stepper.Views.Fragment.StepperFragment;
import co.jperezp.testclean.App.App;
import co.jperezp.testclean.R;
import co.jperezp.testclean.ViewModels.StepperTestViewModel;

public class StepperTestFragment extends Fragment implements onStepClick {

    private StepperTestViewModel mViewModel;
    private StepperFragment fragmentStepper;
    private TextView text_step;

    public static StepperTestFragment newInstance() {
        return new StepperTestFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_stepper_test, container, false);
        loadObjects(result);
        return result;
    }

    private void loadObjects(View result){
        text_step = (TextView) result.findViewById(R.id.text_step);
    }

    private void loadStepper(){
        fragmentStepper = new StepperFragment();
        fragmentStepper.init(this, mViewModel.getTestSteps(), App.getContext());
        pushNewFragment(fragmentStepper, "STEPPER");
    }

    private void pushNewFragment(Fragment newFragment, String tag){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_stepper, newFragment, tag)
                .commit();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StepperTestViewModel.class);
        loadStepper();
    }

    @Override
    public void onStepClick(StepData selected) {
        text_step.setText(selected.getStepText());
    }

}
