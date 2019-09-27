package co.jperezp.domain.Usecases;


import co.jperezp.data.Local.AnimationSource;
import co.jperezp.data.Model.Entities.AnimationShake;

public class AnimationRepository {
    private static final AnimationRepository ourInstance = new AnimationRepository();

    public static AnimationRepository getInstance() {
        return ourInstance;
    }

    private AnimationRepository() {
    }

    public AnimationShake getNextAnimation(){
        return AnimationSource.getInstance().getNextAnimation();
    }
}
