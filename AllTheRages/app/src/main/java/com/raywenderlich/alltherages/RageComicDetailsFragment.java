package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raywenderlich.alltherages.database.model.RageComic;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RageComicDetailsFragment extends Fragment {
  private static String TAG = RageComicDetailsFragment.class.toString();
  @BindView(R.id.detail_name)
  TextView name;
  @BindView(R.id.comic_image_detail)
  ImageView imageView;
  @BindView(R.id.description)
  TextView description;

  public RageComic rageComic;

  public void setRageComic(RageComic rageComic) {
    this.rageComic = rageComic;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
    View view = layoutInflater.inflate(R.layout.fragment_rage_comic_details,
            container,
            false);
    setupUI(view);
    return view;
  }

  private void setupUI(View view) {
    ButterKnife.bind(this,view);
    String mName = rageComic.getName();
    name.setText(mName);
    Log.d(TAG,String.format("Url comic:%s",rageComic.getUrlPic()));
    Picasso.with(getContext()).load(rageComic.getUrlPic()).into(imageView);
    String mDescription = rageComic.getDescription();
    description.setText(mDescription);
  }
}
