package io.tailorweb.musicmachine;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.tailorweb.musicmachine.model.Playlist;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ;
    public static final String KEY_SONG = "song";
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDownloadButton = (Button) findViewById(R.id.downloadButton);
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();
                for (String song : Playlist.songs) {
                    Intent intent = new Intent(MainActivity.this, DownloadService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }
            }
        });
    }

}
