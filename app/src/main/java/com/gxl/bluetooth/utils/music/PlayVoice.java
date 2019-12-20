package com.gxl.bluetooth.utils.music;

import android.content.Context;
import android.media.MediaPlayer;

import com.gxl.bluetooth.activity.R;


//开始播放声音
public class PlayVoice {
    private static MediaPlayer mediaPlayer;

    public static void playVoice(Context context,int tag){
        try {
            if(tag==1){
                mediaPlayer= MediaPlayer.create(context, R.raw.icon_searchvoice);
            }else if(tag==2){
                mediaPlayer= MediaPlayer.create(context, R.raw.icon_countdown);
            }

            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //停止播放声音
    public  static void stopVoice(){
        if(null!=mediaPlayer) {
            mediaPlayer.stop();
        }
    }
}

