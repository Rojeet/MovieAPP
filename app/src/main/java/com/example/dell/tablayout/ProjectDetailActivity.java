package com.example.dell.tablayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

/**
 * Created by Dell on 1/3/2018.
 */

public class ProjectDetailActivity extends Activity{
private Button play;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_detail);



        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String description = intent.getStringExtra("Description");
        TextView textView = (TextView) findViewById(R.id.project_title);
        TextView textView1 = (TextView)findViewById(R.id.project_description);
        textView.setText(title);
        textView1.setText(description);
       play = (Button) findViewById(R.id.play);
       play.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=yH8YspHM27s&t=927s")));
           }
       });

    }

}
