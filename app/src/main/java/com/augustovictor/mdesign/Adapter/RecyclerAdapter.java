package com.augustovictor.mdesign.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onCreateViewHolder " + position);
        Landscape currentObj = mData.get(position);
        holder.setData(currentObj, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

        public void setListeners() {
            mImageDelete.setOnClickListener(MyViewHolder.this);
            mImageAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick before operation at Position " + mPosition + " Size: " + mData.size());

            switch (v.getId()) {
                case R.id.img_row_delete:
                    removeItem(mPosition);
                    break;

                case R.id.img_row_add:
                    addItem(mPosition, mCurrent);
                    break;
            }

            Log.d(TAG, "onClick after operation - Size " + mData.size());
        }
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemChanged(position);
    }

    public void addItem(int position, Landscape landscape) {
        mData.add(position, landscape);
        notifyItemInserted(position);
    }
}
