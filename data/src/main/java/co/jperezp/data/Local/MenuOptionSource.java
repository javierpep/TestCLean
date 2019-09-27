package co.jperezp.data.Local;

import java.util.ArrayList;
import java.util.List;

import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.data.Model.Entities.MenuOption;
import co.jperezp.data.R;
import co.jperezp.data.Util.ConstantList;


public class MenuOptionSource {
    private static final MenuOptionSource ourInstance = new MenuOptionSource();

    public static MenuOptionSource getInstance() {
        return ourInstance;
    }


    public List<MenuOption> getMenuOptions(){
        ArrayList<MenuOption> listOptions;
        listOptions = new ArrayList<>();
        listOptions.add(new MenuOption(ConstantList.MENU_OPTION_COMPASS, R.raw.menu_compass));
        listOptions.add(new MenuOption(ConstantList.MENU_OPTION_SHAKER, R.raw.menu_shake));
        listOptions.add(new MenuOption(ConstantList.MENU_OPTION_STEPPER, R.raw.menu_step));
        return listOptions;
    }
}
