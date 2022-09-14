package com.example.spotify.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spotify.R;

public class TextSongFragment extends Fragment {
    TextView textView;
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_text_song, container, false);

        textView = view.findViewById(R.id.tv_song);
        imageView = view.findViewById(R.id.img_arrow_down);
        textView.setText(R.string.string_em_gai_mua);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getFragmentManager() != null){
                    getFragmentManager().popBackStack();
                }
            }
        });
        return view;
    }
}
