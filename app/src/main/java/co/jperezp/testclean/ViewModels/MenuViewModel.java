package co.jperezp.testclean.ViewModels;

import androidx.lifecycle.ViewModel;

import java.util.List;

import co.jperezp.data.Interfaces.onMenuOptionAction;
import co.jperezp.data.Local.ShakeDetect;
import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.data.Model.Entities.MenuOption;
import co.jperezp.domain.Adapters.MenuAdapter;
import co.jperezp.domain.Usecases.AnimationRepository;
import co.jperezp.domain.Usecases.MenuOptionsRepository;

public class MenuViewModel extends ViewModel {

    public MenuAdapter getMenuAdapter(onMenuOptionAction callback){
        return new MenuAdapter(callback);
    }

    public List<MenuOption> getMenuOptions(){
        return MenuOptionsRepository.getInstance().getMenuOptions();
    }
}
