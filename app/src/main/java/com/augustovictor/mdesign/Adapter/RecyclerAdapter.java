package com.augustovictor.mdesign.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.augustovictor.mdesign.Model.Landscape;
import com.augustovictor.mdesign.R;

import java.util.List;

/**
 * Created by victoraweb on 5/26/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private static final int PRIME_ROW = 1;
    private static final int NOT_PRIME_ROW = 0;
    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case PRIME_ROW:
                ViewGroup primeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_prime, parent, false);
                MyViewHolder viewHolderPrime = new MyViewHolderPrime(primeRow);
                return viewHolderPrime;

            case NOT_PRIME_ROW:
                ViewGroup notPrimeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder viewHolderNotPrime = new MyViewHolderNotPrime(notPrimeRow);
                return viewHolderNotPrime;

            default:
                ViewGroup defaultRow = (ViewGroup) mInflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder defaultHolder = new MyViewHolder(defaultRow);
                return defaultHolder;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape currentRowItem = mData.get(position);

        switch (holder.getItemViewType()) {
            case PRIME_ROW:
                MyViewHolderPrime holderPrime = (MyViewHolderPrime) holder;
                holderPrime.setData(currentRowItem);
                break;

            case NOT_PRIME_ROW:
                MyViewHolderNotPrime holderNotPrime = (MyViewHolderNotPrime) holder;
                holderNotPrime.setData(currentRowItem);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public int getItemViewType(int position) {
        Landscape landscape = mData.get(position);
        if(landscape.isPrime()) {
            return PRIME_ROW;
        } else {
            return NOT_PRIME_ROW;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    class MyViewHolderPrime extends MyViewHolder {

        private TextView mTitle;
        private ImageView mImageThumb, mImgRowType;

        public MyViewHolderPrime(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_row);
            mImageThumb = (ImageView) itemView.findViewById(R.id.img_row);
            mImgRowType = (ImageView) itemView.findViewById(R.id.list_item_img_row_prime);
        }

        public void setData(Landscape currentObj) {
            this.mTitle.setText(currentObj.getTitle());
            this.mImageThumb.setImageResource(currentObj.getImageId());
            this.mImgRowType.setImageResource(R.drawable.ic_add);
        }
    }

    class MyViewHolderNotPrime extends MyViewHolder {
        private TextView mTitle;
        private ImageView mImageThumb, mImgRowType;

        public MyViewHolderNotPrime(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_row);
            mImageThumb = (ImageView) itemView.findViewById(R.id.img_row);
            mImgRowType = (ImageView) itemView.findViewById(R.id.list_item_img_row_not_prime);
        }

        public void setData(Landscape currentObj) {
            this.mTitle.setText(currentObj.getTitle());
            this.mImageThumb.setImageResource(currentObj.getImageId());
            this.mImgRowType.setImageResource(R.drawable.ic_delete);
        }
    }
}
