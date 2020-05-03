package ir.hhadanooo.ielts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ir.hhadanooo.ielts.TestAndPracticeMenu.ActivityTestAndPracticeMenu;

public class MainActivity extends AppCompatActivity {

    Button btnListen , btnSpeak , btnRead , btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListen = findViewById(R.id.btnListen);
        btnSpeak = findViewById(R.id.btnSpeak);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);


        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Listen","listen");
                startActivity(intent);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Speak","speak");
                startActivity(intent);
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Read","read");
                startActivity(intent);
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActivityTestAndPracticeMenu.class);
                intent.putExtra("Write","write");
                startActivity(intent);
            }
        });

    }
}
