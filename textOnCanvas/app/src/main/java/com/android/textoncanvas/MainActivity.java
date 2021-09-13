package com.android.textoncanvas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;


public class MainActivity extends AppCompatActivity {

    final int RQS_IMAGE1 = 1;
    Button btnLoadImage1, btnProcessing;
    TextView txtSource1;
    EditText editTextCaption;
    ImageView imageResult;
    Uri source1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RQS_IMAGE1:
                    source1 = data.getData();
                    txtSource1.setText(source1.toString());
                    break;
            }
        }
    }

    private Bitmap ProcessingBitmap() {
        Bitmap bml = null;
        Bitmap newBitmap = null;
        try {
            bml =
                    BitmapFactory.decodeStream(getContentResolver().openInputStream(source1));
            Bitmap.Config config = bml.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            newBitmap = Bitmap.createBitmap(bml.getWidth(), bml.getHeight(), config);
            Canvas newCanvas = new Canvas(newBitmap);
            newCanvas.drawBitmap(bml, 0, 0, null);
            String captionString = editTextCaption.getText().toString();
            if (captionString != null || !captionString.equals("")) {
                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText.setColor(Color.BLUE);
                paintText.setTextSize(200);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);
                Rect rectText = new Rect();
                paintText.getTextBounds(captionString, 0, captionString.length(),
                        rectText);
                newCanvas.drawText(captionString, 0, rectText.height(), paintText);
                Toast.makeText(getApplicationContext(), "drawText: "+captionString, Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getApplicationContext(),"Caption empty: " +captionString, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newBitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoadImage1 = (Button) findViewById(R.id.loadImage1);
        txtSource1 = (TextView) findViewById(R.id.sourceUril);
        editTextCaption = (EditText) findViewById(R.id.caption);
        btnProcessing = (Button) findViewById(R.id.processing);
        imageResult = (ImageView) findViewById(R.id.source);
        btnLoadImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RQS_IMAGE1);
            }
        });
        btnProcessing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (source1 != null) {
                    Bitmap processedBitmap = ProcessingBitmap();
                    if (processedBitmap != null) {
                        imageResult.setImageBitmap(processedBitmap);
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext()," Select both Image ",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
