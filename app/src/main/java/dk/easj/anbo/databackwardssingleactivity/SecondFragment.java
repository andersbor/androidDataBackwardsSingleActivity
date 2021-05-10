package dk.easj.anbo.databackwardssingleactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import dk.easj.anbo.databackwardssingleactivity.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    public static String VALID = "valid";
    public static String NAME = "name";
    public static String AGE = "age";

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(view12 -> {
            String name = binding.nameInputField.getText().toString().trim();
            if ("".equals(name)) {
                binding.nameInputField.setError("No name");
                return;
            }
            String ageStr = binding.ageInputField.getText().toString().trim();
            if ("".equals(ageStr)) {
                binding.ageInputField.setError("No age");
                return;
            }
            int age = Integer.parseInt(ageStr); // TODO handle exception
            Bundle bundle = new Bundle();
            bundle.putString(NAME, name);
            bundle.putInt(AGE, age);
            bundle.putBoolean(VALID, true);
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment, bundle);
        });
        binding.buttonCancel.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putBoolean(VALID, false);
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment, bundle);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}