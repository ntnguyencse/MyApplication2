package com.example.ntnguyen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    Button nutNhan;
    TextView txtNoiDung;
    EditText Ran_min,Ran_max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        txtNoiDung = (TextView) findViewById(R.id.NoiDung);
        nutNhan = (Button) findViewById(R.id.NutNhan);
        Ran_min = (EditText) findViewById(R.id.Ran_min);
        Ran_max = (EditText) findViewById(R.id.Ran_max);
        // viết code

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_num_min=Ran_min.getText().toString();

                String s_num_max=Ran_max.getText().toString();

                Random ran = new Random();
                if ((s_num_max.length()!=0)&&(s_num_min.length()!=0)&&(s_num_max.length()<6)&&(s_num_min.length()<6)){
                    int num_min =Integer.parseInt(s_num_min);
                    int num_max =Integer.parseInt(s_num_max);
                    if((num_min < num_max)&&(num_max <65535)&&(num_min <65535)) {
                        int random_ = (ran.nextInt(num_max - num_min + 1) + num_min);
                        txtNoiDung.setText(random_ + "");
                    } else {
                        txtNoiDung.setText("Xin mời nhập giá trị min và max và min < max <65535");
                    }
                }
                else {
                    txtNoiDung.setText("Xin mời nhập giá trị min và max và min < max");
                };
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
