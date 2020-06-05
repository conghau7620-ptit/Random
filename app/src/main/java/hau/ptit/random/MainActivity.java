package hau.ptit.random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edtMin;
    EditText edtMax;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1 = edtMin.getText().toString().trim();
                String st2 = edtMax.getText().toString().trim();

                if (st1.isEmpty() || st2.isEmpty() ) {
                    Toast.makeText(MainActivity.this,"Please input 2 numbers",Toast.LENGTH_LONG).show();
                    tv.setText("0");
                }
                else {
                    int n1 = Integer.parseInt(st1);
                    int n2 = Integer.parseInt(st2);
                    if (n1>n2) {
                        int tmp = n1;
                        n1 = n2;
                        n2 = tmp;
                    }
                    edtMin.setText(n1+"");
                    edtMax.setText(n2+"");
                    Random random = new Random();
                    int number = random.nextInt(n2 - n1 +1 ) + n1;
                    tv.setText(String.valueOf(number));
                }
            }
        });



    }

    private void mapping    () {
        edtMin = (EditText) findViewById(R.id.editTextMin);
        edtMax = (EditText) findViewById(R.id.editTextMax);
        btn = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.textview3);
    }

}
