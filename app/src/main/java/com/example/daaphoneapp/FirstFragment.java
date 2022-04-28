package com.example.daaphoneapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.daaphoneapp.databinding.FragmentFirstBinding;

import java.util.Locale;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    TextView priceTV;
    Button priceBtn;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        priceTV = getView().findViewById(R.id.priceTV);
        priceBtn = getView().findViewById(R.id.priceBtn);
        priceBtn.setOnClickListener(obtainPhonePrice);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private final View.OnClickListener obtainPhonePrice = new View.OnClickListener() {
        public void onClick(View v) {
            Integer price = 244990;
            priceTV.setText(String.format(Locale.getDefault(), "$%d.", price));
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}