package com.example.ta_prakppb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ta_prakppb.databinding.ActivityHomeFBinding;

public class homeF extends AppCompatActivity {

    ActivityHomeFBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeFBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HGFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.HG:
                    replaceFragment(new HGFragment());
                    break;
                case R.id.Movies:
                    replaceFragment(new MoviesFragment());
                    break;
                case R.id.profil:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}