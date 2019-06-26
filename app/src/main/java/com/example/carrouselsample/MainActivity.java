package com.example.carrouselsample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.carrouselsample.databinding.ActivityMainBinding;
import com.example.carrouselsample.ui.SliderFragment;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frag_container, new SliderFragment()).commit();

    }
}
