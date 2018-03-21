package com.eugenedondo.todolistingui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MasonryView> {

    private Context context;
    private List<ItemModel> itemModels;
    private RecyclerViewClickListener mListener;

    TodoAdapter(List<ItemModel> itemModelList, Context context, RecyclerViewClickListener listener) {
        this.context = context;
        this.mListener = listener;
        this.itemModels = itemModelList;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_content, parent, false);
        return new MasonryView(layoutView, mListener);
    }

    @Override
    public void onBindViewHolder(MasonryView holder, int position) {

        ItemModel itemModel = itemModels.get(position);

        holder.textView.setText(itemModel.getName());
        holder.subtext.setText(itemModel.getQuantity());

        if (itemModel.isDone()){
            holder.done.setVisibility(View.VISIBLE);
        } else {
            holder.done.setVisibility(View.GONE);
        }

        holder.content.setBackgroundColor(context.getResources().getColor(itemModel.getColor()));

        if (position == 0){
            holder.topView.setBackgroundResource(R.drawable.item_bg);
            ((GradientDrawable)holder.topView.getBackground()).setColor(context.getResources().getColor(itemModel.getColor()));
        } else {
            holder.topView.setVisibility(View.GONE);
        }

        if (position == (itemModels.size()-1)){
            holder.bottomView.setVisibility(View.GONE);
        } else {
            holder.bottomView.setBackgroundResource(R.drawable.item_bg);
            ItemModel itemModelBottom = itemModels.get(position+1);
            ((GradientDrawable)holder.bottomView.getBackground()).setColor(context.getResources().getColor(itemModelBottom.getColor()));
        }
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    class MasonryView extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView, subtext;
        ImageView done;
        View topView, bottomView;
        LinearLayout content;

        MasonryView(View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            topView = itemView.findViewById(R.id.topView);
            bottomView = itemView.findViewById(R.id.bottomView);
            content = itemView.findViewById(R.id.content);
            textView = itemView.findViewById(R.id.mainTitle);
            subtext = itemView.findViewById(R.id.subTitle);
            done = itemView.findViewById(R.id.done);
            mListener = recyclerViewClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }
}
