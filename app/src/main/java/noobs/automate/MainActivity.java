package noobs.automate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button turnon,turnoff;
    String onresponseString,offresponseString;

    private Request onrequest,offrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);




        turnon = (Button) findViewById(R.id.turnon);
//        turnoff = (Button) findViewById(R.id.turnoff);

        turnon.setText("TURN ON");

        turnon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://192.168.0.123/onoff.php";
                String value = "1";
                OkHttpClient okHttpClient = new OkHttpClient();

                RequestBody body = new FormBody.Builder()
                        .add("value",value)
                        .build();

                onrequest = new Request.Builder()
                        .url(url)
                        .method("POST",body.create(null, new byte[0]))
                        .post(body)
                        .build();

                Log.v("insideon", body.toString());


                okHttpClient.newCall(onrequest).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.v("Onfailure","fail");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"Something wrong",Toast.LENGTH_LONG).show();

                            }
                        });

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        onresponseString = response.body().string();
                        Log.v("response", onresponseString);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"Turning on Light",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                });
            }
        });

//        turnoff.setText("TURN OFF");
//
//        turnoff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "http://192.168.43.10/onoff.php";
//                String value = "10";
//                OkHttpClient okHttpClient = new OkHttpClient();
//
//                RequestBody body = new FormBody.Builder()
//                        .add("value",value)
//                        .build();
//
//                offrequest = new Request.Builder()
//                        .url(url)
//                        .method("POST",body.create(null, new byte[0]))
//                        .post(body)
//                        .build();
//
//                okHttpClient.newCall(offrequest).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(MainActivity.this,"Something wrong", Toast.LENGTH_LONG).show();
//
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        offresponseString = response.body().string();
//                        Log.v("response", offresponseString);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(MainActivity.this,"Turning off Light", Toast.LENGTH_LONG).show();
//
//                            }
//                        });
//                    }
//                });
//            }
//        });


    }
}
