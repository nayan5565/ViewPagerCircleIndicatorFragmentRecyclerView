package com.nayan.candyparty;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nayan on 9/19/2017.
 */
public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MProduct> productArrayList;
    private MProduct mProduct;


    public SizeAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<MProduct> mProducts) {
        this.productArrayList = mProducts;

        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_size, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        mProduct = productArrayList.get(position);
        holder.txtSize.setText(mProduct.getSize());
        GradientDrawable drawable = (GradientDrawable) holder.txtSize.getBackground();
        if (mProduct.getClick() == 1) {
            drawable.setColor(Color.RED);
        } else {
            drawable.setColor(Color.GRAY);
        }


    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSize;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtSize = (TextView) itemView.findViewById(R.id.txtSize);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProduct = productArrayList.get(getAdapterPosition());
                    Utils.pos = getAdapterPosition();
                    for (int i = 0; i < productArrayList.size(); i++) {
                        productArrayList.get(i).setClick(0);
                    }
                    productArrayList.get(getAdapterPosition()).setClick(1);

                    mProduct = productArrayList.get(getAdapterPosition());
                    MainActivity.getInstance().txtPrice.setText(mProduct.getPrice() + "");
                    MainActivity.getInstance().txtDP.setText(mProduct.getDiscountPrice() + "");
                    MainActivity.getInstance().txtDPercn.setText(mProduct.getDiscountParcentage());
                    notifyDataSetChanged();

                }
            });

        }
    }
}
