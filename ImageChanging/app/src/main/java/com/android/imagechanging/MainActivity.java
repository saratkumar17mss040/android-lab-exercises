package com.android.imagechanging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    ImageView iv;
    TextView tv;
    boolean flag;
    int images[]={R.drawable.ic1,R.drawable.ic2,R.drawable.ic3,R.drawable.ic4,R.drawable.ic5};
    String text[] = { "Cash register", "Burger", "Smoothie", "Soda", "Water bottle"};
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.img1);
        b1= findViewById(R.id.button);
        tv = findViewById(R.id.tv);

        iv.setImageResource(R.drawable.icon);
        tv.setText("Restaurant");
        flag=true;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(images[i]);
                tv.setText(text[i]);
                i++;
                if(i==5)
                    i=0;
            }
        });
    }
}
