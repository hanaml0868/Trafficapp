package sdu.cs.sirichai.trafficapp;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    ListView listView;
    int[] ints = new int[]{R.drawable.traffic_01 , R.drawable.traffic_02 ,R.drawable.traffic_03 , R.drawable.traffic_04 ,R.drawable.traffic_05 ,
            R.drawable.traffic_06 ,R.drawable.traffic_07 ,R.drawable.traffic_08 ,R.drawable.traffic_09 ,R.drawable.traffic_10 ,R.drawable.traffic_11 ,
            R.drawable.traffic_12 ,R.drawable.traffic_13 ,R.drawable.traffic_14 ,R.drawable.traffic_15 ,R.drawable.traffic_16 ,R.drawable.traffic_17 ,
            R.drawable.traffic_18 ,R.drawable.traffic_19 ,R.drawable.traffic_20 ,};

    String[] titleStrings , detailStrings,subStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ผูกตัวแปล
       listView = findViewById(R.id.livTraffic);
        //ดึงมาจาก my_content มาแสดงผลที่ xbl
        titleStrings = getResources(). getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //subStrings Detail
        subStrings = new  String[detailStrings.length];
        for (int i=0; i <detailStrings.length; i++){
            subStrings[i] = detailStrings [i]. substring(0, 20)+ "...";

        }//end for

        //Create Listview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,ints,titleStrings,subStrings);
        listView.setAdapter(myAdapter);


        //เชื่อมโยงแต่ละรายการใน listView ให้ลิ้งค์ไปหน้า Detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent detailIntent = new Intent(MainActivity.this, Detail.class);
                detailIntent.putExtra("Title", titleStrings[i]);
                detailIntent.putExtra("DEtail",detailStrings[i]);
                detailIntent.putExtra("Logo",ints[i]);
                startActivity(detailIntent);




            }
        });




    }//end onCreate Method

    public void clickMoreinfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/"));
    }
}//edn class
