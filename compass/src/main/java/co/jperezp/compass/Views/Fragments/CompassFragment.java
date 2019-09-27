package co.jperezp.compass.Views.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import co.jperezp.compass.ViewModel.CompassViewModel;
import co.jperezp.compass.R;
import co.jperezp.data.Interfaces.onCompassChange;

import static android.content.Context.SENSOR_SERVICE;

public class CompassFragment extends Fragment implements onCompassChange {

    private CompassViewModel mViewModel;

    private ImageView imageViewCompass;
    private SensorManager mSensorManager;

    public static CompassFragment newInstance() {
        return new CompassFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.compass_fragment, container, false);
        loadObjects(result);
        return result;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CompassViewModel.class);
        mViewModel.initSensorListener(this);
    }

    private void loadObjects(View result){
        imageViewCompass = (ImageView) result.findViewById(R.id.imageViewCompass);
        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners
        mSensorManager.registerListener(mViewModel.getSensorListener(), mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mViewModel.getSensorListener());
    }

    @Override
    public void onRotationChange(String degree, RotateAnimation animCompass) {
        // Start the animation
        imageViewCompass.startAnimation(animCompass);
    }

}
