package com.raywenderlich.alltherages.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raywenderlich.alltherages.R;
import com.raywenderlich.alltherages.adapter.viewholder.RageComicViewHolder;
import com.raywenderlich.alltherages.database.DBContext;
import com.raywenderlich.alltherages.database.model.RageComic;
import com.raywenderlich.alltherages.eventbus.RageComicReturn;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by laptopTCC on 5/27/2017.
 */

public class RageComicAdapter extends RecyclerView.Adapter<RageComicViewHolder> {
    private static String TAG = RageComicAdapter.class.toString();
    @Override
    public RageComicViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_rage_comic_list,
                viewGroup,
                false);
        return new RageComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RageComicViewHolder holder, int position) {
        final RageComic rageComic = DBContext.getAllRage().get(position);
        //final String mName = rageComic.getName();
        if(rageComic != null) {
            holder.bindData(rageComic);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new RageComicReturn(rageComic));
            }
        });
    }

    @Override
    public int getItemCount() {
        return DBContext.getAllRage().size();
    }
}