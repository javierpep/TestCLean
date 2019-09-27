package co.jperezp.stepper.Views.Fragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.jperezp.stepper.Data.Interfaces.onStepClick;
import co.jperezp.stepper.Data.Model.Entities.StepData;
import co.jperezp.stepper.Domain.Adapters.StepAdapter;
import co.jperezp.stepper.R;
import co.jperezp.stepper.ViewModel.StepperViewModel;

public class StepperFragment extends Fragment {

    private StepperViewModel mViewModel;
    private RecyclerView steps_list;
    private StepAdapter step_adapter;
    private LinearLayoutManager mLayoutManager;
    private onStepClick callback;
    private Context ctx;
    private List<StepData> listSteps;

    public static StepperFragment newInstance() {
        return new StepperFragment();
    }

    public void init(onStepClick callback_, List<StepData> listSteps_, Context ctx_){
        this.callback = callback_;
        this.listSteps = listSteps_;
        this.ctx = ctx_;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.stepper_fragment, container, false);
        loadObjects(result);
        return result;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StepperViewModel.class);
        step_adapter = mViewModel.getStepAdapter(callback, ctx);
        steps_list.setLayoutManager(mLayoutManager);
        steps_list.setHasFixedSize(true);
        steps_list.setAdapter(step_adapter);
        step_adapter.swapList(listSteps);
    }

    private void loadObjects(View result){
        steps_list = (RecyclerView) result.findViewById(R.id.steps_list);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    }
}
