package ders.alper.characterhomeworks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = new Intent(this, SecondActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent returnIntent) {
        super.onActivityResult(requestCode, resultCode, returnIntent);

        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK)
            {
                ArrayList<String> mesaj=returnIntent.getStringArrayListExtra("mesaj");

                int boyut=mesaj.size();
                String text=null;


                for(int i=0;i<boyut;i++)
                {
                    if(text==null)
                    {
                        text=mesaj.get(i);
                    }
                    else{
                        text=text + mesaj.get(i);
                    }
                }


                int intValue = returnIntent.getIntExtra("countWrong", 0);


                Toast.makeText(getApplicationContext(),"Mesajınız : " + text + " Yanlış Girilen Karakter Sayısı :" + intValue,Toast.LENGTH_LONG).show();





            }
        }
    }
}
