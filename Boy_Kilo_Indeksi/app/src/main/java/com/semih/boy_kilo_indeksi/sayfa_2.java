package com.semih.boy_kilo_indeksi;

import static android.provider.Contacts.SettingsColumns.KEY;
import static android.provider.Telephony.Mms.Part.TEXT;
import static java.sql.Types.INTEGER;
import static java.sql.Types.REAL;
import static java.text.Collator.PRIMARY;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class sayfa_2 extends AppCompatActivity {

    EditText etAd, etSoyad, etYas, etBoy, etKilo;
    TextView txt_Indeks, txt_Sonuc, txt_Rapor;
    ImageView my_img_view;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sayfa2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etAd = findViewById(R.id.etAd);
        etSoyad = findViewById(R.id.etSoyad);
        etYas = findViewById(R.id.etYas);
        etBoy = findViewById(R.id.etBoy);
        etKilo = findViewById(R.id.etKilo);
        my_img_view=findViewById(R.id.imageView);
        txt_Indeks=findViewById(R.id.txt_Indeks);
        txt_Sonuc=findViewById(R.id.txt_Sonuc);
        txt_Rapor=findViewById(R.id.txt_Rapor);
    }

    public void click_sonuc(View view){
        float boyDeger = Float.parseFloat(etBoy.getText().toString());
        float kiloDeger = Float.parseFloat(etKilo.getText().toString());
        boyDeger = boyDeger / 100;
        float degerSonuc = kiloDeger / (boyDeger * boyDeger);

        String sonuc = String.format("%.2f", degerSonuc);


        if (degerSonuc <= 18.5) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Sonuc.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " + "ZAYIFSINIZ");
            txt_Sonuc.setTextColor(Color.parseColor("#FFCC00"));
            my_img_view.setImageResource(R.drawable.yuz_1);
            txt_Rapor.setText("Sonuçlara göre acil doktorla görüşmeli ve sağlıklı kilo almalısınız");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));
        }

        if (degerSonuc > 19 && degerSonuc <= 24.9) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Indeks.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " + "KİLONUZ NORMAL");
            txt_Sonuc.setTextColor(Color.parseColor("#FF0FEA28"));
            my_img_view.setImageResource(R.drawable.yuz_2);
            txt_Rapor.setText("Sonuçlara göre gayet sağlıklısınız aynı şekilde formunuzu korumaya devam edin:)))");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));

        }

        if (degerSonuc > 25 && degerSonuc <= 29.9) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Indeks.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " + "KİLOLU");
            txt_Sonuc.setTextColor(Color.parseColor("#006600"));
            my_img_view.setImageResource(R.drawable.yuz_3);
            txt_Rapor.setText("Sonuçlara göre biraz kilo almışsınız daha dikkatli olun ve çok fazla kilo almamaya çalışın");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));

        }

        if (degerSonuc > 30 && degerSonuc <= 34.9) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Indeks.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " + "ŞİŞMAN");
            txt_Sonuc.setTextColor(Color.parseColor("#CC0000"));
            my_img_view.setImageResource(R.drawable.yuz_4);
            txt_Rapor.setText("Sonuçlara göre şişmanlamışsınız doktorunuzla görüşün ve kilo vermeye çalışın.");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));

        }

        if (degerSonuc > 35 && degerSonuc <= 39.9) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Indeks.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " + "AŞIRI ŞİŞMAN");
            txt_Sonuc.setTextColor(Color.parseColor("#990000"));
            my_img_view.setImageResource(R.drawable.yuz_5);
            txt_Rapor.setText("Vaov!! Sonuçlara göre çok fazla kilolusunuz açil bir doktorla görüşün ve kilo vermeye başlayın ");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));
        }

        if (degerSonuc >40) {

            txt_Indeks.setText("İndeks: "+ " "+sonuc);
            txt_Indeks.setTextColor(Color.parseColor("#000000"));
            txt_Sonuc.setText("Sonuç: " + " " +"AŞIRI AŞIRI ŞİŞMAN" );
            txt_Sonuc.setTextColor(Color.parseColor("#660000"));
            my_img_view.setImageResource(R.drawable.yuz_6);
            txt_Rapor.setText("İnanılmazz!!! Sonuçlara göre aşırı aşırı kilolusunuz çok acil vakit kaybetmeden doktorunuzla görüşün acele edin.");
            txt_Rapor.setTextColor(Color.parseColor("#000000"));

        }


    }

    public void click_sil(View view){

        etBoy.setText("");
        etKilo.setText("");
        etYas.setText("");
        etAd.setText("");
        etSoyad.setText("");
        txt_Indeks.setText("");
        txt_Sonuc.setText("");
        txt_Rapor.setText("");
        my_img_view.setImageResource(0);

    }
}
