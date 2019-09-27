package co.jperezp.testclean.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import co.jperezp.compass.Views.Fragments.CompassFragment;
import co.jperezp.shake.Views.Fragments.ShakerFragment;
import co.jperezp.testclean.R;
import co.jperezp.testclean.Views.Fragments.MenuFragment;
import co.jperezp.testclean.Views.Fragments.StepperTestFragment;

public class MainActivity extends AppCompatActivity {

    private MenuFragment fragmentMenu;
    private CompassFragment fragmentCompass;
    private ShakerFragment fragmentShaker;
    private StepperTestFragment fragmentStepperTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMenu();
    }

    public void loadMenu(){
        if(fragmentMenu == null)
            fragmentMenu = MenuFragment.newInstance();

        pushNewFragment(fragmentMenu, "MENU");
    }

    public void loadShaker(){
        if(fragmentShaker == null)
            fragmentShaker = ShakerFragment.newInstance();

        pushNewFragment(fragmentShaker, "SHAKER");
    }

    public void loadCompass(){
        if(fragmentCompass == null)
            fragmentCompass = CompassFragment.newInstance();

        pushNewFragment(fragmentCompass, "COMPASS");
    }

    public void loadStepperTest(){
        if(fragmentStepperTest == null)
            fragmentStepperTest = StepperTestFragment.newInstance();

        pushNewFragment(fragmentStepperTest, "STEPPERTEST");
    }

    private void pushNewFragment(Fragment newFragment, String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .add(R.id.frame_content, newFragment, tag)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }
    }
}
