package com.williamtygret.cakeproject.modules.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.williamtygret.cakeproject.R;
import com.williamtygret.cakeproject.mvp.model.Cake;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by williamtygret on 8/1/17.
 */
public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private List<Cake> mCakeList = new ArrayList<>();

    public CakeAdapter(LayoutInflater inflater){
        mLayoutInflater = inflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mCakeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCakeList.size();
    }

    public void addCakes(List<Cake> cakes){
        mCakeList.addAll(cakes);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        @Bind(R.id.cake_icon) protected ImageView mCakeIcon;
        @Bind(R.id.textview_title) protected TextView mCakeTitle;
        @Bind(R.id.textview_preview_description) protected TextView mCakePreviewDescription;

        private Context mContext;


        public Holder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(Cake cake) {

            mCakeTitle.setText(cake.getTitle());
            mCakePreviewDescription.setText(cake.getPreviewDescription());

            Glide.with(mContext).load(cake.getImageURL())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mCakeIcon);

        }
    }

}
