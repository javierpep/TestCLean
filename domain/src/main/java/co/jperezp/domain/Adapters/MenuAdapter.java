package co.jperezp.domain.Adapters;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

import co.jperezp.data.Interfaces.onMenuOptionAction;
import co.jperezp.data.Model.Entities.MenuOption;
import co.jperezp.domain.R;

/**
 * Created by JavierPerez on 11/02/18.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.CardViewHolder> {
    private List<MenuOption> listOptions = new ArrayList<>();
    private onMenuOptionAction callback;

    public MenuAdapter(onMenuOptionAction callback_) {
        this.callback = callback_;
    }

    public void swapList(List<MenuOption> listOptions_) {
        this.listOptions.clear();
        this.listOptions.addAll(listOptions_);
        notifyDataSetChanged();
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        CardViewHolder myViewHolder = new CardViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardView, int position) {
        MenuOption selOption = listOptions.get(position);
        cardView.selected = selOption;
        cardView.menu_icon.setAnimation(selOption.getIdAnimation());
        cardView.menu_icon.playAnimation();
        cardView.menu_text.setText(selOption.getText());
    }

    @Override
    public int getItemCount() {
        return listOptions.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LottieAnimationView menu_icon;
        private TextView menu_text;

        private MenuOption selected;

        CardViewHolder(View cardView) {
            super(cardView);
            cardView.setOnClickListener(this);
            menu_icon = (LottieAnimationView) cardView.findViewById(R.id.menu_icon);
            menu_text = (TextView) cardView.findViewById(R.id.menu_text);
        }

        @Override
        public void onClick(View v) {
            callback.onOptionClick(selected);
        }
    }
}
