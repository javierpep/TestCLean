package co.jperezp.data.Local;

import java.util.ArrayList;
import co.jperezp.data.Model.Entities.AnimationShake;
import co.jperezp.data.R;


public class AnimationSource {
    private static final AnimationSource ourInstance = new AnimationSource();
    private ArrayList<AnimationShake> listAnims;
    private Integer position;
    private Integer maxPosition;

    public static AnimationSource getInstance() {
        return ourInstance;
    }

    private AnimationSource() {
        if(listAnims == null){
            loadAnimsRaw();
            position = -1;
            maxPosition = 3;
        }
    }

    private void loadAnimsRaw(){
        listAnims = new ArrayList<>();
        listAnims.add(new AnimationShake("Anim1", R.raw.shake_anim_1));
        listAnims.add(new AnimationShake("Anim1", R.raw.shake_anim_2));
        listAnims.add(new AnimationShake("Anim1", R.raw.shake_anim_3));
        listAnims.add(new AnimationShake("Anim1", R.raw.shake_anim_4));
    }

    public AnimationShake getNextAnimation(){
        position++;
        if(position > maxPosition)
            position = 0;
        return listAnims.get(position);
    }
}
