package dk.easj.anbo.databackwardssingleactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import dk.easj.anbo.databackwardssingleactivity.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(view1 -> {
                    Bundle bundle = new Bundle();
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
                    Log.d("Apple", "FirstFragment: after navigation");
                }
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Apple", "onResume");
        Bundle bundle = getArguments();
        if (bundle == null) {
            Log.d("Apple", "onResume: bundle is null");
            return;
        }
        boolean valid = bundle.getBoolean(SecondFragment.VALID);
        Log.d("Apple", "onResume: valid: " + valid);
        if (valid) {
            String name = bundle.getString(SecondFragment.NAME, "No name");
            int age = bundle.getInt(SecondFragment.AGE, -1);
            binding.textviewFirst.setText("Welcome " + name + " " + age);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}