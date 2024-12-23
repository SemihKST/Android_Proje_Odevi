package com.semih.boy_kilo_indeksi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText et_TCK;
    RadioButton rdb_erkek, rdb_kadin;
    ImageView my_img_rdb;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_TCK=findViewById(R.id.et_TCK);
        rdb_erkek = findViewById(R.id.rdb_erkek);
        rdb_kadin = findViewById(R.id.rdb_kadin);
        my_img_rdb = findViewById(R.id.imageview_C);

    }
       public void click_rbE(View view) {
           if (rdb_erkek.isChecked()) {

               rdb_kadin.setChecked(false);
               my_img_rdb.setImageResource(R.drawable.erkek);

           }
       }

        public void click_rbK(View view) {
            if (rdb_kadin.isChecked()) {

                rdb_erkek.setChecked(false);
                my_img_rdb.setImageResource(R.drawable.kadin);

            }

    }

    public void click_girisYap(View view){

        String tcKimlikNumarasi = et_TCK.getText().toString().trim();


        if (tcKimlikNumarasi.length() != 11) {

                Toast.makeText(MainActivity.this, "TC kimlik numarası 11 haneli olmalıdır.", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(MainActivity.this,sayfa_2.class);
            startActivity(intent);
        }
    }
}