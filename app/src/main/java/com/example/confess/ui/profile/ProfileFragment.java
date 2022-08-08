package com.example.confess.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.confess.R;
import com.example.confess.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    private ImageButton calendarViewSwitch, addJournalButton;
    private LinearLayoutCompat calendarView;
    private TextView miniViewDate, miniViewDay, miniViewYear;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        calendarViewSwitch = root.findViewById(R.id.MPJFCalendarViewSwitch);
        calendarView = root.findViewById(R.id.MPJFCalendarView);
        miniViewDate = root.findViewById(R.id.MPJFMiniViewDate);
        miniViewDay = root.findViewById(R.id.MPJFMiniViewDay);
        miniViewYear = root.findViewById(R.id.MPJFMiniViewYear);

        calendarViewSwitch.setOnClickListener(view -> {
            if(calendarView.getVisibility() == View.GONE) {
                Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.icon_rotation_01);
                rotation.setFillAfter(true);
                calendarViewSwitch.startAnimation(rotation);
                calendarView.setVisibility(View.VISIBLE);
            }
            else if(calendarView.getVisibility() == View.VISIBLE) {
                Animation rotation = AnimationUtils.loadAnimation(getContext(), R.anim.icon_rotation_02);
                rotation.setFillAfter(true);
                calendarViewSwitch.startAnimation(rotation);
                calendarView.setVisibility(View.GONE);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}