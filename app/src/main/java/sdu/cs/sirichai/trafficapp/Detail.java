package sdu.cs.sirichai.trafficapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //
        TextView titleTexView = findViewById(R.id.txtTitle);
        TextView detaTextView = findViewById(R.id.txtDetail);
        ImageView logoImageView = findViewById(R.id.imvLogo);

        //intent Xml
        titleTexView.setText(getIntent().getStringExtra("Title"));
        detaTextView.setText(getIntent().getStringExtra("detail"));
        logoImageView.setImageResource(getIntent().getIntExtra("Logo", R.drawable.traffic_01));

    }

    public void clickBack(View view) {
    }
}
