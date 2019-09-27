package co.jperezp.shake.Views.Fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.airbnb.lottie.LottieAnimationView;

import co.jperezp.data.Interfaces.onShakeAction;
import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.shake.R;
import co.jperezp.shake.ViewModel.ShakerViewModel;

public class ShakerFragment extends Fragment implements onShakeAction {

    private ShakerViewModel mViewModel;
    private LottieAnimationView lottie_view;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;


    public static ShakerFragment newInstance() {
        return new ShakerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_shaker, container, false);
        loadObjects(fragmentView);
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShakerViewModel.class);
        showAnim(mViewModel.nextAnimation());

        //Shaker detection
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mViewModel.shakeDetectorInstance().setOnShakeListener(this);
    }

    private void loadObjects(View fragmentView){
        lottie_view = (LottieAnimationView) fragmentView.findViewById(R.id.lottie_view);
    }

    private void showAnim(AnimationShake currentAnim){
        lottie_view.setAnimation(currentAnim.getRawId());
        lottie_view.playAnimation();
    }

    @Override
    public void shakeAction() {
        showAnim(mViewModel.nextAnimation());
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mViewModel.shakeDetectorInstance(), mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mViewModel.shakeDetectorInstance());
        super.onPause();
    }
}
