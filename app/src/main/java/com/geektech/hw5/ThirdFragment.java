package com.geektech.hw5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.hw5.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private String data;
    private FragmentThirdBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!= null){
            data = getArguments().getString("key2");
        }
        binding.textView.setText(data);
        Toast.makeText(getContext(), "ThirdFragment", Toast.LENGTH_SHORT).show();
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key3", binding.textView.getText().toString());
                navController = Navigation.findNavController(requireActivity(), R.id.container);
                navController.navigate(R.id.action_thirdFragment2_to_fourthFragment2, bundle);
            }
        });
    }
}