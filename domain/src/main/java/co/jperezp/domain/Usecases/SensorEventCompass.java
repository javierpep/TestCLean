package co.jperezp.domain.Usecases;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import co.jperezp.data.Interfaces.onCompassChange;

public class SensorEventCompass implements SensorEventListener {
    private static final SensorEventCompass ourInstance = new SensorEventCompass();

    private onCompassChange callback;
    private float currentDegree = 0f;

    public static SensorEventCompass getInstance() {
        return ourInstance;
    }

    private SensorEventCompass() {
    }

    public void init(onCompassChange callback_){
        this.callback = callback_;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        RotateAnimation ra = new RotateAnimation(
                currentDegree,
                -degree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        ra.setDuration(210);
        ra.setFillAfter(true);
        currentDegree = -degree;
        callback.onRotationChange(Float.toString(degree), ra);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not in use
    }
}
