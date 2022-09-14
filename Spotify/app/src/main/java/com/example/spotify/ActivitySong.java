package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.spotify.Fragment.TextSongFragment;
import com.example.spotify.Object.Song;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ActivitySong extends AppCompatActivity {
    private ImageView imgPlay, imgView, imgPrev, imgNext;
    private TextView tvnamesong, tvtitlesong, tvstart, tvend, tvtextsong;
    private SeekBar seekBar;
    private int id;
    static MediaPlayer mediaPlayer;
    ArrayList<Song> mySongs;
    Animation annotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Init();
        overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);

        annotation = AnimationUtils.loadAnimation(this, R.anim.disc_rotate);

        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        mySongs = (ArrayList) bundle.getParcelableArrayList("listsong");
        id = bundle.getInt("idsong");

        imgView.setImageResource(mySongs.get(id).getResourceID());
        tvnamesong.setText(mySongs.get(id).getName());
        tvtitlesong.setText(mySongs.get(id).getDescripsion());

        mediaPlayer = MediaPlayer.create(ActivitySong.this,mySongs.get(id).getMysong());
        mediaPlayer.start();
        SetTimeSong();
        imgPlay.setImageResource(R.drawable.ic_pause);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        imgView.setAnimation(annotation);
        UpdateTime();

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.ic_baseline_play);
                }else {
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id++;
                if(id > mySongs.size() - 1){
                    id = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                imgView.setImageResource(mySongs.get(id).getResourceID());
                tvnamesong.setText(mySongs.get(id).getName());
                tvtitlesong.setText(mySongs.get(id).getDescripsion());
                mediaPlayer = MediaPlayer.create(ActivitySong.this,mySongs.get(id).getMysong());
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.ic_pause);
                seekBar.setMax(mediaPlayer.getDuration());
                SetTimeSong();
                UpdateTime();
            }
        });

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id--;
                if(id < 0){
                    id = mySongs.size() - 1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                imgView.setImageResource(mySongs.get(id).getResourceID());
                tvnamesong.setText(mySongs.get(id).getName());
                tvtitlesong.setText(mySongs.get(id).getDescripsion());
                mediaPlayer = MediaPlayer.create(ActivitySong.this,mySongs.get(id).getMysong());
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.ic_pause);
                seekBar.setMax(mediaPlayer.getDuration());
                SetTimeSong();
                UpdateTime();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        tvtextsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new TextSongFragment();
                loadFragment(fragment);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_text, fragment);
        transaction.commit();
        transaction.addToBackStack(TextSongFragment.class.getName());
    }

    private void Init() {
        imgPlay = findViewById(R.id.imagePlay);
        imgView = findViewById(R.id.imgViewSong);
        imgPrev = findViewById(R.id.imgPrev);
        imgNext = findViewById(R.id.imgNext);
        tvnamesong = findViewById(R.id.tvnamesong);
        tvtitlesong = findViewById(R.id.tvtitlesong);
        tvstart = findViewById(R.id.tvStartTime);
        tvend = findViewById(R.id.tvEndTime);
        seekBar = findViewById(R.id.seekbar);
        tvtextsong = findViewById(R.id.tvloibaihat);
    }

    private void SetTimeSong(){
        SimpleDateFormat formattime = new SimpleDateFormat("mm:ss");
        tvend.setText(formattime.format(mediaPlayer.getDuration()));
    }

    private void UpdateTime(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat formattime = new SimpleDateFormat("mm:ss");
                tvstart.setText(formattime.format(mediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        id++;
                        if(id > mySongs.size() - 1){
                            id = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        imgView.setImageResource(mySongs.get(id).getResourceID());
                        tvnamesong.setText(mySongs.get(id).getName());
                        tvtitlesong.setText(mySongs.get(id).getDescripsion());
                        mediaPlayer = MediaPlayer.create(ActivitySong.this,mySongs.get(id).getMysong());
                        mediaPlayer.start();
                        imgPlay.setImageResource(R.drawable.ic_pause);
                        seekBar.setMax(mediaPlayer.getDuration());
                        SetTimeSong();
                        UpdateTime();
                    }
                });

                handler.postDelayed(this, 500);
            }
        }, 100);
    }
}