package com.raywenderlich.alltherages.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.raywenderlich.alltherages.R;
import com.raywenderlich.alltherages.database.model.RageComic;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class RageComicViewHolder extends RecyclerView.ViewHolder{
    private static String TAG = RageComicViewHolder.class.toString();
    @BindView(R.id.im_comic) ImageView
    mImageView;
    @BindView(R.id.tv_name) TextView
    name;

    public RageComicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bindData(RageComic rageComic){
        Picasso.with(itemView.getContext()).load(rageComic.getUrlPic()).into(mImageView);
        name.setText(rageComic.getName());
    }
}
