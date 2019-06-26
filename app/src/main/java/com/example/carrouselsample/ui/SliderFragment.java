package com.example.carrouselsample.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.carrouselsample.R;
import com.example.carrouselsample.adapter.ImageSliderAdapter;
import com.example.carrouselsample.databinding.FragmentImageSliderBinding;

/**
 * Created by Harsh Gaba on 2019-06-26.
 * harshgaba08@gmail.com
 */
public class SliderFragment extends Fragment {

    private FragmentImageSliderBinding mBinding;
    private int dotCounts;
    private ImageView[] dots;
    private ViewPager viewPagerImageSlider;
    private LinearLayout layoutSliderDots;
    private ImageSliderAdapter imageSliderAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_slider, container, false);
        View view = mBinding.getRoot();
        viewPagerImageSlider = mBinding.viewpagerImageSlider;
        layoutSliderDots = mBinding.linearLayoutSliderDots;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSliderAdapter = new ImageSliderAdapter(getActivity());
        viewPagerImageSlider.setAdapter(imageSliderAdapter);
        dotCounts = imageSliderAdapter.getCount();
        dots = new ImageView[dotCounts];

        for (int i = 0; i < dotCounts; i++) {
            dots[i] = new ImageView(getActivity().getApplicationContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dot_shape_dark));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            layoutSliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dot_shape_grey));
        viewPagerImageSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotCounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dot_shape_dark));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.dot_shape_grey));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
