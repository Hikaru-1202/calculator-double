package com.example.selfmade_double;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button num_1,num_2,num_3,num_4,num_5,num_6,num_7,num_8,num_9,num_0,num_add,num_min,num_mul,num_div,num_dot,num_eq,num_C;
    private String number_1,number_2,number_3,number_4,number_5,number_6,number_7,number_8,number_9,number_0,number_add,number_min,number_mul,number_div,number_dot,number_eq,number_C;
    private TextView numres;
    private double numint1 = 0;
    private double numint2 = 0;
    private boolean checker = false;
    private boolean numdec = false;
    private int arithmetic = 0;
    private double numcal = 0;
    private double decbox = 1;
    private int decdig = 0;
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

        numres = findViewById(R.id.numLabel);
        numres.setText(String.valueOf(numint1));

        num_1 = findViewById(R.id.numBtn1);
        num_2 = findViewById(R.id.numBtn2);
        num_3 = findViewById(R.id.numBtn3);
        num_4 = findViewById(R.id.numBtn4);
        num_5 = findViewById(R.id.numBtn5);
        num_6 = findViewById(R.id.numBtn6);
        num_7 = findViewById(R.id.numBtn7);
        num_8 = findViewById(R.id.numBtn8);
        num_9 = findViewById(R.id.numBtn9);
        num_0 = findViewById(R.id.numBtn0);
        num_add = findViewById(R.id.numBtnadd);
        num_min = findViewById(R.id.numBtnmin);
        num_mul = findViewById(R.id.numBtnmul);
        num_div = findViewById(R.id.numBtndiv);
        num_dot = findViewById(R.id.numBtndot);
        num_eq = findViewById(R.id.numBtneq);
        num_C = findViewById(R.id.numBtnC);

        num_1.setOnClickListener(this);
        num_2.setOnClickListener(this);
        num_3.setOnClickListener(this);
        num_4.setOnClickListener(this);
        num_5.setOnClickListener(this);
        num_6.setOnClickListener(this);
        num_7.setOnClickListener(this);
        num_8.setOnClickListener(this);
        num_9.setOnClickListener(this);
        num_0.setOnClickListener(this);
        num_add.setOnClickListener(this);
        num_min.setOnClickListener(this);
        num_mul.setOnClickListener(this);
        num_div.setOnClickListener(this);
        num_dot.setOnClickListener(this);
        num_eq.setOnClickListener(this);
        num_C.setOnClickListener(this);

        numberChecker();
    }
    private void numberChecker(){
        number_1 = "1";
        number_2 = "2";
        number_3 = "3";
        number_4 = "4";
        number_5 = "5";
        number_6 = "6";
        number_7 = "7";
        number_8 = "8";
        number_9 = "9";
        number_0 = "0";
        number_add = "+";
        number_min = "-";
        number_mul = "*";
        number_div = "/";
        number_dot = ".";
        number_eq = "=";
        number_C = "C";
    }
    @Override
    public void onClick(View v) {
        Button numBtn = findViewById(v.getId());
        String btnText = numBtn.getText().toString();
        if (btnText.equals(number_1)){
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.1;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.1;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+1;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.1;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.1;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+1;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_2)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.2;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.2;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+2;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.2;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.2;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+2;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_3)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.3;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.3;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+3;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.3;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.3;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+3;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_4)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.4;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.4;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+4;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.4;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.4;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+4;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_5)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.5;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.5;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+5;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.5;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.5;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+5;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_6)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.6;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.6;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+6;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.6;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.6;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+6;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_7)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.7;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.7;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+7;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.7;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.7;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+7;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_8)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.8;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.8;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+8;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.8;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.8;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+8;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_9)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint1 = numint1+decbox*0.9;
                        decbox = 1;
                    }else {
                        numint1 = numint1 + 0.9;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10+9;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        numint2 = numint2+decbox*0.9;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        numint2 = numint2 + 0.9;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10+9;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_0)) {
            if (checker ==false){//第一項判定
                if (numdec == true){//小数点判定
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        ++decdig;
                        decbox = 1;
                    }else {
                        ++decdig;
                    }
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint1 = numint1*10;
                    numres.setText(String.valueOf(numint1));
                    Log.v("MY_LOG",String.valueOf(numint1));
                }
            }else {//第二項判定
                if (numdec == true){
                    if (decdig > 0){
                        for (int i = 0; i < decdig;i++){
                            decbox = decbox*0.1;
                        }
                        ++decdig;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                        decbox = 1;
                    }else {
                        ++decdig;
                        if(arithmetic == 1){
                            numres.setText(String.valueOf(numint1+"+"+numint2));
                        } else if (arithmetic == 2) {
                            numres.setText(String.valueOf(numint1+"-"+numint2));
                        } else if (arithmetic == 3) {
                            numres.setText(String.valueOf(numint1+"*"+numint2));
                        }else {
                            numres.setText(String.valueOf(numint1+"/"+numint2));
                        }
                    }
                    Log.v("MY_LOG",String.valueOf(numint2));
                    ++decdig;
                    Log.v("MY_LOG",String.valueOf("digit:"+decdig));
                }else {
                    numint2 = numint2*10;
                    if(arithmetic == 1){
                        numres.setText(String.valueOf(numint1+"+"+numint2));
                    } else if (arithmetic == 2) {
                        numres.setText(String.valueOf(numint1+"-"+numint2));
                    } else if (arithmetic == 3) {
                        numres.setText(String.valueOf(numint1+"*"+numint2));
                    }else {
                        numres.setText(String.valueOf(numint1+"/"+numint2));
                    }
                }
            }
            Log.v("MY_LOG",String.valueOf(numdec));
        } else if (btnText.equals(number_add)) {
            checker = true;
            arithmetic = 1;
            numdec = false;
            decdig = 0;
            decbox = 1;
            numres.setText(String.valueOf(numint1)+"+");
        } else if (btnText.equals(number_min)) {
            checker = true;
            arithmetic = 2;
            numdec = false;
            decdig = 0;
            decbox = 1;
            numres.setText(String.valueOf(numint1)+"-");
        } else if (btnText.equals(number_mul)) {
            checker = true;
            arithmetic = 3;
            numdec = false;
            decdig = 0;
            decbox = 1;
            numres.setText(String.valueOf(numint1)+"*");
        } else if (btnText.equals(number_div)) {
            checker = true;
            arithmetic = 4;
            numdec = false;
            decdig = 0;
            decbox = 1;
            numres.setText(String.valueOf(numint1)+"/");
        } else if (btnText.equals(number_dot)) {
            Log.v("MY_LOG", ".");
            numdec = true;
        } else if (btnText.equals(number_eq)) {
            if(arithmetic == 1){
                numint1 += numint2;
                numres.setText(String.valueOf(numint1));
                numint2 = 0;
                numdec = false;
                decdig = 0;
                decbox = 1;
            } else if (arithmetic == 2) {
                numint1 -= numint2;
                numres.setText(String.valueOf(numint1));
                numint2 = 0;
                numdec = false;
                decdig = 0;
                decbox = 1;
            } else if (arithmetic == 3) {
                numint1 *= numint2;
                numres.setText(String.valueOf(numint1));
                numint2 = 0;
                numdec = false;
                decdig = 0;
                decbox = 1;
            }else {
                if (numint2 == 0){
                    numres.setText("Error");
                    numint2 = 0;
                    numdec = false;
                    decdig = 0;
                    decbox = 1;
                }else {
                    numint1 /= numint2;
                    numres.setText(String.valueOf(numint1));
                    numint2 = 0;
                    numdec = false;
                    decdig = 0;
                    decbox = 1;
                }
            }
        } else if (btnText.equals(number_C)) {
            numint1 = 0;
            numint2 = 0;
            numdec = false;
            checker = false;
            decdig = 0;
            decbox = 1;
            numres.setText(String.valueOf(numint1));
            Log.v("MY_LOG",String.valueOf(numint1));
        }
    }
}