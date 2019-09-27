package co.jperezp.testclean.Views.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import co.jperezp.data.Interfaces.onMenuOptionAction;
import co.jperezp.data.Model.Entities.MenuOption;
import co.jperezp.data.Util.ConstantList;
import co.jperezp.domain.Adapters.MenuAdapter;
import co.jperezp.testclean.ViewModels.MenuViewModel;
import co.jperezp.testclean.R;
import co.jperezp.testclean.Views.Activities.MainActivity;

public class MenuFragment extends Fragment implements onMenuOptionAction {

    private MenuViewModel mViewModel;
    private RecyclerView menu_list;
    private MenuAdapter menu_adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_menu, container, false);
        loadObjects(result);
        return result;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        menu_adapter = mViewModel.getMenuAdapter(this);
        menu_adapter.swapList(mViewModel.getMenuOptions());
        menu_list.setLayoutManager(mLayoutManager);
        menu_list.setHasFixedSize(true);
        menu_list.setAdapter(menu_adapter);
    }

    private void loadObjects(View result){
        menu_list = (RecyclerView) result.findViewById(R.id.menu_list);
        mLayoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public void onOptionClick(MenuOption selected) {
        switch (selected.getText()){
            case ConstantList.MENU_OPTION_COMPASS:
                ((MainActivity) Objects.requireNonNull(getActivity())).loadCompass();
                break;

            case ConstantList.MENU_OPTION_SHAKER:
                ((MainActivity) Objects.requireNonNull(getActivity())).loadShaker();
                break;

            case ConstantList.MENU_OPTION_STEPPER:
                ((MainActivity) Objects.requireNonNull(getActivity())).loadStepperTest();
                break;
        }
    }
}
