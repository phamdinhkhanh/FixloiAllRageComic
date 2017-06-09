package com.raywenderlich.alltherages;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.raywenderlich.alltherages.adapter.RageComicAdapterAustralia;
import com.raywenderlich.alltherages.adapter.RageComicAdapterFrance;
import com.raywenderlich.alltherages.adapter.RageComicAdapterGermany;
import com.raywenderlich.alltherages.eventbus.RageComicReturn;
import com.raywenderlich.alltherages.utils.FragmentListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RageComicListFragment extends Fragment{
  private static String TAG = RageComicListFragment.class.toString();
  @BindView(R.id.recycler_view_france)
  RecyclerView recyclerViewFrance;
  @BindView(R.id.recycler_view_germany)
  RecyclerView recyclerViewGermany;
  @BindView(R.id.recycler_view_australia)
  RecyclerView recyclerViewAustralia;
  private FragmentListener fragmentListener;
  private Boolean onPause = true;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_rage_comic_list, container, false);
    EventBus.getDefault().register(this);
    setupUI(view);
    return view;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    fragmentListener = (FragmentListener) context;
  }

  @Override
  public void onDestroyView(){
    super.onDestroyView();
    EventBus.getDefault().unregister(this);
  }

  private void setupUI(View view) {
    ButterKnife.bind(this,view);
    RageComicAdapterFrance rageComicAdapterFrance = new RageComicAdapterFrance();
    RageComicAdapterGermany rageComicAdapterGermany = new RageComicAdapterGermany();
    RageComicAdapterAustralia rageComicAdapterAustralia = new RageComicAdapterAustralia();
    if (recyclerViewFrance == null){
      Log.d(TAG,String.format("recyclerViewFrance is null"));
    }
    recyclerViewFrance.setAdapter(rageComicAdapterFrance);
    //recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
    recyclerViewFrance.setLayoutManager(new GridLayoutManager(this.getContext(), 1, LinearLayout.HORIZONTAL, false));
    recyclerViewGermany.setAdapter(rageComicAdapterGermany);
    recyclerViewGermany.setLayoutManager(new GridLayoutManager(this.getContext(), 1, LinearLayout.HORIZONTAL, false));
    recyclerViewAustralia.setAdapter(rageComicAdapterAustralia);
    recyclerViewAustralia.setLayoutManager(new GridLayoutManager(this.getContext(), 1, LinearLayout.HORIZONTAL, false));
  }

  @Subscribe
  public void onChangeFragment(RageComicReturn rageComicReturn){
    RageComicDetailsFragment rageComicDetailsFragment = new RageComicDetailsFragment();
    rageComicDetailsFragment.setRageComic(rageComicReturn.getRageComic());
    getFragmentManager().beginTransaction()
                        .replace(R.id.fl_main, rageComicDetailsFragment)
                        .addToBackStack(null)
                        .commit();
  }
}
