package co.jperezp.domain.Usecases;


import java.util.ArrayList;
import java.util.List;

import co.jperezp.data.Local.AnimationSource;
import co.jperezp.data.Local.MenuOptionSource;
import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.data.Model.Entities.MenuOption;

public class MenuOptionsRepository {
    private static final MenuOptionsRepository ourInstance = new MenuOptionsRepository();

    public static MenuOptionsRepository getInstance() {
        return ourInstance;
    }

    private MenuOptionsRepository() {
    }

    public List<MenuOption> getMenuOptions(){
        return MenuOptionSource.getInstance().getMenuOptions();
    }
}
