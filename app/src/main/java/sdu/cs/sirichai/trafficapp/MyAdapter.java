package sdu.cs.sirichai.trafficapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Activity นี่สร้าง Layout เสมือน เพือนำไปแสดงผลบนหน้า MainActivity
public class MyAdapter extends BaseAdapter {

    //Explicit
    Context context;
    int[] ints;//ตัวแปรเก็บรูปโลโก้
    String[] titleString, detailString;//ตัวแปร titleString เก็บชื่อโลโก้, ตัวแปร detailString เก็บรูปโลโก้

    public MyAdapter(Context context, int[] ints, String[] titleString, String[] detailString) {
        this.context = context;
        this.ints = ints;
        this.titleString = titleString;
        this.detailString = detailString;
    }

    @Override
    public int getCount() { //นับจำนวนข้อมูลที่ต้องการแสดงผล แล้วส่งต่อไปยัง Method getView
        return ints.length;
    }

    @Override
    public Object getItem(int position) {   //ไม่ได้ไช้
        return null;
    }

    @Override
    public long getItemId(int position) {   //ไม่ได้ไช้
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) { //นำข้อมูลที่จาก Method getView ไปแสดงผลบนหน้าแอบ

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view1 = layoutInflater.inflate(R.layout.my_listview,viewGroup,false);// inflate ดึงค่าจาก xml มาแสดงผลบนแอบ

        //ผูกตัวแปรบน JAVA กับ xml
        ImageView iconImageView = view1.findViewById(R.id.imageView);
        TextView titleTextView = view1.findViewById(R.id.textView2);
        TextView detailTextView = view1.findViewById(R.id.textView3);

        //Show view  นำข้อมูลไปแสดงผลบนแอป
        iconImageView.setImageResource(ints[i]);
        titleTextView.setText(titleString[i]);
        detailTextView.setText(detailString[i]);

        return view1;

    }
}//end Class
