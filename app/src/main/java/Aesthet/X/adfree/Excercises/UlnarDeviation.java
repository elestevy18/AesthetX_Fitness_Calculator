package Aesthet.X.adfree.Excercises;

import android.os.Bundle;
import android.widget.Button;

import com.example.scifit.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import Aesthet.X.adfree.Classes.YoutubeConfig;

public class UlnarDeviation extends YouTubeBaseActivity {
    YouTubePlayerView mYoutubePlayerView;
    Button play;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);
        mYoutubePlayerView = findViewById(R.id.YT);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("36WDREF0Jyw");
                //FOR LIST
               /* List<String> videoList = new ArrayList<>();
                videoList.add("codecode");
                videoList.add("codecode");
                or;
                YouTubePlayer.loadPlaylist(");")*/
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);

    }
}

