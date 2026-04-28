package dk.tec.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;

    ImageButton imgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initGui();
    }
    void initGui(){
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        imgBtn = findViewById(R.id.button3);
        btn.setOnClickListener(v -> {
            btn2.setText("Click me");
            btn2.setTextColor(getResources().getColor(R.color.kims_color));
        });
        imgBtn.setOnClickListener(view -> {
           Intent intent = new Intent(this, SecondActivity.class);
           startActivity(intent);
        });
//        imgBtn.setOnClickListener(view -> {
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(Intent.ACTION_SEND);
//            sendIntent.setType("text/plain");
//            sendIntent.putExtra(Intent.EXTRA_TEXT, "test123");
//            startActivity(sendIntent);
//        });
    }
}