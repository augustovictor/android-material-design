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

    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> mData) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Landscape currentObj = mData.get(position);
        holder.setData(currentObj, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private ImageView mImageThumb, mImageDelete, mImageAdd;
        private int mPosition;
        private Landscape mCurrent;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_row);
            mImageThumb = (ImageView) itemView.findViewById(R.id.img_row);
            mImageDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            mImageAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape currentObj, int position) {
            this.mTitle.setText(currentObj.getTitle());
            this.mImageThumb.setImageResource(currentObj.getImageId());
            this.mPosition = position;
            this.mCurrent = currentObj;
        }
    }
}
