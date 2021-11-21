package com.geektech.hw5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.hw5.databinding.FragmentFourthBinding;
import com.geektech.hw5.databinding.FragmentThirdBinding;

public class FourthFragment extends Fragment {

    private String data;
    private FragmentFourthBinding binding;
    private  NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFourthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null){
            data = getArguments().getString("key3");
        }

        binding.textView.setText(data);
        Toast.makeText(getContext(), "FourthFragment", Toast.LENGTH_SHORT).show();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key4", binding.textView.getText().toString());
                navController = Navigation.findNavController(requireActivity(), R.id.container);
                navController.navigate(R.id.action_fourthFragment2_to_fifthFragment2);
            }
        });
    }
}