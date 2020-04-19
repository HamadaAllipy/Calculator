package pc.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    private int mTOTAL ;


    // Display
    private String disFristNum ;
    private String disSecondNum ;
    private String disThirhNum ;

    // Varaibles
    private int total ;
    private String fristNum ;
    private String secondNum ;
    private String thirthNum ;
    private final String LOG_TOG = MainActivity.class.getSimpleName();
    private char ope ;
    private char ope_2 ;
    private String mDisplayScreen ;
    private int counter ;

    // counter of zoom
    private int count_2 ;
    String text ;
    boolean changeFrom_num_1_to_num_2 = false ;
    boolean changeFrom_num_2_to_num_3 = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        btnShift();
    }
    private void displayScreenLeft(String text) {
        final TextView textView = findViewById(R.id.screen_view);
        textView.setText(text);
        zoomMin(textView);
    }
    private void zoomMin(TextView textView){
        final TextView mTextView = textView ;
        ImageView btnZoomMin = findViewById(R.id.zoom_min);
            btnZoomMin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count_2 == 0 ){
                        mTextView.setTextSize(28);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 0000000000 ::"+count_2 );
                    }
                    else if (count_2 == 1){
                        mTextView.setTextSize(26);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 111111111::"+count_2 );
                    }
                    else if (count_2 == 2){
                        mTextView.setTextSize(24);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 333333333:"+count_2 );
                    }
                    else if (count_2 == 3){
                        mTextView.setTextSize(20);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 333333333:"+count_2 );
                    }
                    else if (count_2 == 4){
                        mTextView.setTextSize(18);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 333333333:"+count_2 );
                    }
                    else if (count_2 == 5){
                        mTextView.setTextSize(16);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 333333333:"+count_2 );
                    }
                    else if (count_2 == 6){
                        mTextView.setTextSize(14);
                        count_2 = count_2 + 1 ;
                        Log.i(LOG_TOG,"cont == 333333333:"+count_2 );
                    }
                }
            });

    }
    private void displayScreenBottom(String text) {
        TextView textView = findViewById(R.id.screen_result);
        textView.setText(text);
    }

    private void btnShift(){
        //TODO   (X-1) button
        RelativeLayout x_1 = findViewById(R.id.x_1);
        x_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayScreenLeft("x^(-1)");
            }
        });
        //TODO   (log_a_x) button
        RelativeLayout log_a_x = findViewById(R.id.log_a_x);
        log_a_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayScreenLeft("log_a\u2061x");
            }
        });
        //TODO   (Shift) button
        Button button = findViewById(R.id.shift_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayScreenLeft("SHIFT");
            }
        });



        //TODO   num (1)
        Button buttonNumOne = findViewById(R.id.one);
        buttonNumOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeFrom_num_1_to_num_2){
                    Log.i(LOG_TOG, "تم الدخول الي وضع الثاني ") ;
                    if (secondNum == null){
                        secondNum = "1";
                    }
                    else {
                        secondNum = secondNum + 1;
                    }
              /*final */      displayScreenLeft(disFristNum+secondNum);

                }
                // thirth
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "1";
                    }
                    else {
                        thirthNum = thirthNum + 1 ;
                    }
                    Log.i(LOG_TOG,"تم التغيير الي وضع الثالث"+changeFrom_num_2_to_num_3);
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode one
                else {
                    Log.i(LOG_TOG,"تم الدخول الي وضع الاول ") ;
                    if (fristNum == null){
                        fristNum = "1";
                        disFristNum = fristNum;
                        Log.i(LOG_TOG,"تم تخزين رقم واحد اول مره من الوضع الاول ") ;
                    }
                    else {
                        fristNum = fristNum +1 ;
                        disFristNum = fristNum;
                        Log.i(LOG_TOG,"تم تخزين رقم واحد اضافي ،ويوجد رقم مخزن مسبقا، من الوضع الاول ") ;
                    }
                    Log.i(LOG_TOG,"الشاشه حاليا "+disFristNum) ;
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (two)
        Button buttonTwo = findViewById(R.id.two);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "2";
                    }
                    else {
                        secondNum = secondNum + 2;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "2";
                    }
                    else {
                        thirthNum = thirthNum + 2 ;
                    }
                    Log.i(LOG_TOG,"تم التغيير الي وضع الثالث"+changeFrom_num_2_to_num_3);
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "2";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +2 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (three)
        Button buttonThree = findViewById(R.id.three);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "3";
                    }
                    else {
                        secondNum = secondNum + 3;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "3";
                    }
                    else {
                        thirthNum = thirthNum + 3 ;
                    }
                    Log.i(LOG_TOG,"تم التغيير الي وضع الثالث"+changeFrom_num_2_to_num_3);
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "3";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +3 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (four)
        Button buttonFour = findViewById(R.id.four);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "4";
                    }
                    else {
                        secondNum = secondNum + 4;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "4";
                    }
                    else {
                        thirthNum = thirthNum + 4 ;
                    }
                    Log.i(LOG_TOG,"تم التغيير الي وضع الثالث"+changeFrom_num_2_to_num_3);
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "4";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +4 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (four)
        Button buttonFive = findViewById(R.id.five);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "5";
                    }
                    else {
                        secondNum = secondNum + 5;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "5";
                    }
                    else {
                        thirthNum = thirthNum + 5 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "5";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +5 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (six)
        Button buttonSix = findViewById(R.id.six);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "6";
                    }
                    else {
                        secondNum = secondNum + 6;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "6";
                    }
                    else {
                        thirthNum = thirthNum + 6 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "6";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +6 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (seven)
        Button buttonSeven = findViewById(R.id.seven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "7";
                    }
                    else {
                        secondNum = secondNum + 7;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "7";
                    }
                    else {
                        thirthNum = thirthNum + 7 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "7";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +7 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (eight)
        Button buttonEight = findViewById(R.id.eight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "8";
                    }
                    else {
                        secondNum = secondNum + 8;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "8";
                    }
                    else {
                        thirthNum = thirthNum + 8 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "8";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +8 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (nine)
        Button buttonNine = findViewById(R.id.nine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "9";
                    }
                    else {
                        secondNum = secondNum + 9;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "9";
                    }
                    else {
                        thirthNum = thirthNum + 9 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "9";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +9 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });

        //TODO (zero)
        Button buttonZero = findViewById(R.id.zero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mode 2
                if (changeFrom_num_1_to_num_2){
                    if (secondNum == null){
                        secondNum = "0";
                    }
                    else {
                        secondNum = secondNum + 0;
                    }
                    /*final */      displayScreenLeft(disFristNum+secondNum);
                }

                //mode 3
                else if (changeFrom_num_2_to_num_3){
                    if (thirthNum == null){
                        thirthNum = "0";
                    }
                    else {
                        thirthNum = thirthNum + 0 ;
                    }
                    displayScreenLeft(disFristNum + disSecondNum + thirthNum);
                }

                //Mode 1
                else {
                    if (fristNum == null){
                        fristNum = "0";
                        disFristNum = fristNum;
                    }
                    else {
                        fristNum = fristNum +0 ;
                        disFristNum = fristNum;
                    }
                    displayScreenLeft(disFristNum);
                }
            }
        });


        //TODO (+)
        Button buttonAdd = findViewById(R.id.addtion);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //first click
                if (counter == 0){
                    ope = '+';
                    disFristNum = fristNum +"+";
                    displayScreenLeft( disFristNum);
                    changeFrom_num_1_to_num_2 = true;
                    counter = counter + 1;
                    Log.i(LOG_TOG, "تم الضغط علي + مره واحده ،التحويل الي وضع الثاني ،الشاشه حاليا "+disFristNum) ;
                }
                //second click
                else if (counter == 1){
                    ope_2 = '+';
                    Log.i(LOG_TOG,"تم الضغط تاني مره");
                    changeFrom_num_1_to_num_2 = false ;
                    changeFrom_num_2_to_num_3 = true ;
                    disSecondNum = secondNum +"+";
                    displayScreenLeft(disFristNum + disSecondNum);
                }
            }
        });

        //TODO (-)
        Button buttonMin = findViewById(R.id.min_main);
        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //first click
                if (counter == 0){
                    ope = '-';
                    disFristNum = fristNum +"-";
                    displayScreenLeft( disFristNum);
                    changeFrom_num_1_to_num_2 = true;
                    counter = counter + 1;
                }
                //second click
                else if (counter == 1){
                    ope_2 = '-';
                    changeFrom_num_1_to_num_2 = false ;
                    changeFrom_num_2_to_num_3 = true ;
                    disSecondNum = secondNum +"-";
                    displayScreenLeft(disFristNum + disSecondNum);
                }
            }
        });

        //TODO (/)
        Button buttonDiv = findViewById(R.id.diction);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //first click
                if (counter == 0){
                    ope = '/';
                    disFristNum = fristNum +"/";
                    displayScreenLeft( disFristNum);
                    changeFrom_num_1_to_num_2 = true;
                    counter = counter + 1;
                }
                //second click
                else if (counter == 1){
                    ope_2 = '/';
                    changeFrom_num_1_to_num_2 = false ;
                    changeFrom_num_2_to_num_3 = true ;
                    disSecondNum = secondNum +"/";
                    displayScreenLeft(disFristNum + disSecondNum);
                }
            }
        });

        //TODO (*)
        Button buttonMulty = findViewById(R.id.multy);
        buttonMulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //first click
                if (counter == 0){
                    ope = '*';
                    disFristNum = fristNum +"*";
                    displayScreenLeft( disFristNum);
                    changeFrom_num_1_to_num_2 = true;
                    counter = counter + 1;
                }
                //second click
                else if (counter == 1){
                    ope_2 = '*';
                    changeFrom_num_1_to_num_2 = false ;
                    changeFrom_num_2_to_num_3 = true ;
                    disSecondNum = secondNum +"*";
                    displayScreenLeft(disFristNum + disSecondNum);
                }
            }
        });

        //TODO (equal)
        Button buttonequal = findViewById(R.id.equal_main);
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (changeFrom_num_1_to_num_2){
                    int result = resultOpertion(ope);
                   displayScreenBottom( String.valueOf(result));
                    Log.i(LOG_TOG,"تم الضغط علي ="+result) ;
                }
                else if (changeFrom_num_2_to_num_3){
                    int result = resultOpertion(ope, ope_2);
                    Log.i(LOG_TOG,"hoooooooo"+ope_2);
                    displayScreenBottom( String.valueOf(result));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this,"يرجي ادخال العمليه صحيحه",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
    private int resultOpertion(char ope){

        int x = Integer.parseInt(fristNum);
        int y = Integer.parseInt(secondNum);

        int result =  0 ;
//        Log.i(LOG_TOG,"special" +ope);

        if (changeFrom_num_1_to_num_2) {
            switch (ope) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '/':
                    result = x / y;
                    break;
                case '*':
                    result = x * y;
            }
        }
        return result ;
    }
    private int resultOpertion(char ope , char ope_2){

        int result =  0 ;
           if (changeFrom_num_2_to_num_3) {
               int x = Integer.parseInt(fristNum);
               int y = Integer.parseInt(secondNum);
               int th = Integer.parseInt(thirthNum);
            if (ope == ope_2) {
                String text = "";
                switch (ope) {
                    case '+':
                        result = x + y + th;
                        text = "الجمع";
                        break;
                    case '-':
                        result = x - y - th;
                        text = "الطرح";
                        break;
                    case '/':
                        result = x / y / th;
                        text = "القسمه";
                        break;
                    case '*':
                        result = x * y * th;
                        text = "الضرب";
                }
                Log.i(LOG_TOG," تم "+ text + " بين 3 ارقام من نفس العلامه ");
            }

            // the opertor is different
            else {
                // 25 + 25 * 2 = 75    //  25 * 25 + 2= 627   // 2 * 25 + 25 = 75
                // TODO (+ , *) (* , +)
                if (ope == '+' && ope_2 == '*' || ope == '*' && ope_2 == '+' ){
                    if (ope ==  '*'){
                        result = x * y + th ;
                    }
                    else {
                        result = x + y * th;
                    }
                }
                // TODO (+ , -) (- , +)
                else if (ope == '+' && ope_2 == '-' || ope == '-' && ope_2 == '+' ){
                    if (ope ==  '-'){
                        result = x - y + th ;
                    }
                    else {
                        result = x + y - th;
                    }
                }
                // TODO (+ , /) (/ , +)
                else if (ope == '+' && ope_2 == '/' || ope == '/' && ope_2 == '+' ){
                    if (ope ==  '/'){
                        result = x / y + th ;
                    }
                    else {
                        result = x + y / th;
                    }
                }
                //TODO -
                // TODO (- , *) (* , -)
                else if (ope == '-' && ope_2 == '*' || ope == '*' && ope_2 == '-' ){
                    if (ope ==  '*'){
                        result = x * y - th ;
                    }
                    else {
                        result = x - y * th;
                    }
                }
                // TODO (- , /) (/ , -)
                else if (ope == '-' && ope_2 == '/' || ope == '/' && ope_2 == '-' ){
                    if (ope ==  '/'){
                        result = x / y - th ;
                    }
                    else {
                        result = x - y / th;
                    }
                }
                //TODO *
                // TODO (* , /) (/ , *)
                else if (ope == '*' && ope_2 == '/' || ope == '/' && ope_2 == '*' ){
                    if (ope ==  '/'){
                        result = x / y * th ;
                    }
                    else {
                        result = x * y / th;
                    }
                }

            }
        }
           else {
               Log.i(LOG_TOG,"Error in method 744");
           }
           return result;
    }
}

//TODO  (+)   (+ +) (+ - ) (+ * ) ( + / )
//TODO  (-)   (- -)  (- * ) ( - / )
//TODO  (*)   (* *)   ( * / )
//TODO  (/)   (/ /)