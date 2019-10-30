package ders.alper.characterhomeworks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    EditText etText;
    Button btnSend;

    int wrong_character=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etText=findViewById(R.id.etText);
        btnSend=findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String metin= etText.getText().toString();
                ArrayList<String> text=new ArrayList<>();



                for(int i=0;i<=metin.length()-1;i++){
                    boolean durum=testChar(metin.charAt(i));
                    if(durum==true){
                        text.add(String.valueOf(metin.charAt(i)));
                    }
                    else{
                        wrong_character++;

                    }


                }
                Intent returnIntent=new Intent();
                returnIntent.putStringArrayListExtra("mesaj",text);
                returnIntent.putExtra("countWrong",wrong_character);

                setResult(Activity.RESULT_OK,returnIntent);
                finish();


            }
        });
    }



        public boolean testChar(char girilen){
            boolean durum=false;
            int deger=girilen;

            if(deger>64 && deger<91 || deger>96 && deger<123 || deger==32 || deger==39 || deger==44 || deger==46 || deger==58 || deger==59 || deger>=48 && deger<=57|| deger==34){
                durum=true;
            }

        return durum;

        }
}
