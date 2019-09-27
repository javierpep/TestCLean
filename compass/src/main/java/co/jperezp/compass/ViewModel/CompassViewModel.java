package co.jperezp.compass.ViewModel;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.lifecycle.ViewModel;

import co.jperezp.data.Interfaces.onCompassChange;
import co.jperezp.domain.Usecases.SensorEventCompass;

public class CompassViewModel extends ViewModel {

    public void initSensorListener(onCompassChange callback){
        SensorEventCompass.getInstance().init(callback);
    }

    public SensorEventListener getSensorListener(){
        return SensorEventCompass.getInstance();
    }
}
