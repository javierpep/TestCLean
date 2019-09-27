package co.jperezp.data.Local;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import co.jperezp.data.Interfaces.onShakeAction;

public class ShakeDetect implements SensorEventListener {
    private static final ShakeDetect ourInstance = new ShakeDetect();
    public static ShakeDetect getInstance() {
        return ourInstance;
    }

    private static final float SHAKE_THRESHOLD_GRAVITY = 3.7F;

    private onShakeAction mListener;

    public void setOnShakeListener(onShakeAction listener) {
        this.mListener = listener;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // ignore
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (mListener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float gX = x / SensorManager.GRAVITY_EARTH;
            float gY = y / SensorManager.GRAVITY_EARTH;
            float gZ = z / SensorManager.GRAVITY_EARTH;

            // gForce will be close to 1 when there is no movement.
            float gForce = (float)Math.sqrt(gX * gX + gY * gY + gZ * gZ);

            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                mListener.shakeAction();
            }
        }
    }
}
