package com.nayan.candyparty;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

/**
 * Created by Nayan on 9/19/2017.
 */
public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MProduct> productArrayList;
    private MProduct mProduct;


    public ColorAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MProduct> mProducts) {
        this.productArrayList = mProducts;

        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_color, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        mProduct = productArrayList.get(position);
        GradientDrawable drawable = (GradientDrawable) holder.btnColor.getBackground();
        drawable.setColor(mProduct.getColor());
        if (mProduct.getClick() == 1) {
            holder.imgTick.setVisibility(View.VISIBLE);
        } else {
            holder.imgTick.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView btnColor;
        ImageView imgTick;

        public MyViewHolder(View itemView) {
            super(itemView);
            btnColor = (ImageView) itemView.findViewById(R.id.btnColor);
            imgTick = (ImageView) itemView.findViewById(R.id.imgTick);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < productArrayList.size(); i++) {
                        productArrayList.get(i).setClick(0);
                    }
                    productArrayList.get(getAdapterPosition()).setClick(1);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
