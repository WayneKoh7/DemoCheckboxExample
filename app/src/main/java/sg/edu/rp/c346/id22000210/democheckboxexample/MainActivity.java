package sg.edu.rp.c346.id22000210.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaring the Variables
    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                //Action to handle button click event
                if (cbEnabled.isChecked()) {
                    double pay = calcPay(100,20);
                    tvShow.setText("The discount is given. You need to pay $" + pay);
                } else {
                    double pay = calcPay(100, 0);
                    tvShow.setText("The discount is not given. You need to pay $" + pay);
                }
            }
        });


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Action for Toast message to show "Button Click"
                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                //context: The context to use, usually the application or the activity object
                //text: the text to show in the Toast message
                //duration: how long the display the message. Either LENGTH_LONG or LENGTH_SHORT
            }
        });
    }
    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount / 100);
        return pay;
    }
}