package com.android.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper imageFilpper;
    int imageSliders[] = {R.drawable.ic1, R.drawable.ic2, R.drawable.ic3, R.drawable.ic4, R.drawable.ic5};

    public void sliderFlipper(int image) {
//        Log.i("This",this.toString() );
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        imageFilpper.addView(imageView);
        imageFilpper.setFlipInterval(3000);
        imageFilpper.setAutoStart(true);
        imageFilpper.setInAnimation(this, android.R.anim.fade_in);
        imageFilpper.setInAnimation(this, android.R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFilpper = findViewById(R.id.imageFlipper);

        for (int slide : imageSliders) {
            sliderFlipper(slide);
        }
    }
}
