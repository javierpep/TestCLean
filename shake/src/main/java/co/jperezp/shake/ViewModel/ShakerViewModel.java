package co.jperezp.shake.ViewModel;

import androidx.lifecycle.ViewModel;

import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.domain.Usecases.AnimationRepository;
import co.jperezp.data.Local.ShakeDetect;

public class ShakerViewModel extends ViewModel {

    public AnimationShake nextAnimation(){
        return AnimationRepository.getInstance().getNextAnimation();
    }

    public ShakeDetect shakeDetectorInstance(){
        return ShakeDetect.getInstance();
    }
}
