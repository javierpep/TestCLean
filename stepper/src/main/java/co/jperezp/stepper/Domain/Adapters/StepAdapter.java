package co.jperezp.stepper.Domain.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import co.jperezp.stepper.Data.Interfaces.onStepClick;
import co.jperezp.stepper.Data.Model.Entities.StepData;
import co.jperezp.stepper.R;

/**
 * Created by JavierPerez on 11/02/18.
 */

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.CardViewHolder> {
    private List<StepData> listSteps = new ArrayList<>();
    private onStepClick callback;
    private Context ctx;

    public StepAdapter(onStepClick callback_, Context ctx_) {
        this.callback = callback_;
        this.ctx = ctx_;
    }

    public void swapList(List<StepData> listSteps_) {
        this.listSteps.clear();
        this.listSteps.addAll(listSteps_);
        notifyDataSetChanged();
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_item, parent, false);
        CardViewHolder myViewHolder = new CardViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardView, int position) {
        StepData selStep = listSteps.get(position);
        cardView.selected = selStep;

        if(position == 0){
            cardView.connector_left.setVisibility(View.GONE);
        }else{
            cardView.connector_left.setVisibility(View.VISIBLE);
        }

        if(position == listSteps.size() - 1){
            cardView.connector_rigth.setVisibility(View.GONE);
        }else{
            cardView.connector_rigth.setVisibility(View.VISIBLE);
        }

        if(selStep.getOptionaText().equals("")){
            cardView.step_optional.setVisibility(View.GONE);
        }else{
            cardView.step_optional.setVisibility(View.VISIBLE);
            cardView.step_optional.setText(selStep.getOptionaText());
        }

        cardView.step_circle_text.setText(String.valueOf(position + 1));
        cardView.step_label.setText(selStep.getStepText());

        if(selStep.getActive()){
            cardView.step_circle_layout.setBackground(ctx.getResources().getDrawable(R.drawable.background_circle_primary_no_border));
            cardView.connector_rigth.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));
            cardView.connector_left.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));
            cardView.step_label.setTextColor(ctx.getResources().getColor(R.color.black));
            cardView.step_optional.setTextColor((ctx.getResources().getColor(R.color.gray)));
        }else{
            cardView.step_circle_layout.setBackground(ctx.getResources().getDrawable(R.drawable.background_circle_gray_no_border));
            cardView.connector_rigth.setBackgroundColor(ctx.getResources().getColor(R.color.gray));
            cardView.connector_left.setBackgroundColor(ctx.getResources().getColor(R.color.gray));
            cardView.step_label.setTextColor((ctx.getResources().getColor(R.color.gray)));
            cardView.step_optional.setTextColor((ctx.getResources().getColor(R.color.gray)));
        }
    }

    @Override
    public int getItemCount() {
        return listSteps.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ConstraintLayout step_circle_layout;
        private TextView step_circle_text;
        private View connector_rigth;
        private View connector_left;
        private TextView step_label;
        private TextView step_optional;

        private StepData selected;

        CardViewHolder(View cardView) {
            super(cardView);
            cardView.setOnClickListener(this);
            step_circle_layout = (ConstraintLayout) cardView.findViewById(R.id.step_circle_layout);
            step_circle_text = (TextView) cardView.findViewById(R.id.step_circle_text);
            connector_rigth = (View) cardView.findViewById(R.id.connector_rigth);
            connector_left = (View) cardView.findViewById(R.id.connector_left);
            step_label = (TextView) cardView.findViewById(R.id.step_label);
            step_optional = (TextView) cardView.findViewById(R.id.step_optional);
        }

        @Override
        public void onClick(View v) {
            callback.onStepClick(selected);
        }
    }
}
