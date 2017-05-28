package com.raywenderlich.alltherages.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raywenderlich.alltherages.R;
import com.raywenderlich.alltherages.database.model.RageComic;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class RageComicViewHolder extends RecyclerView.ViewHolder{
    private static String TAG = RageComicViewHolder.class.toString();
    /*@BindView(R.id.comic_image) ImageView
    mImageView;*/
    @BindView(R.id.name) TextView
            name;

    public RageComicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bindData(RageComic rageComic){
        //Picasso.with(itemView.getContext()).load(textUrlPic).into(mImageView);
        name.setText(rageComic.getName());
    }
}
