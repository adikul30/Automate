package noobs.automate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    Button turnon, turnoff;
    String url = "http://192.168.43.94:8888/onoff.php";
    private String ON = "1";
    private String OFF = "0";
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        turnon = (Button) findViewById(R.id.turnon);
        turnoff = (Button) findViewById(R.id.turnoff);

        turnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLights();
            }
        });

        turnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLights();
            }
        });

    }

    private void turnOnLights() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(MainActivity.this, "Turning on lights", Toast.LENGTH_SHORT).show();
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(MainActivity.this, "Some error", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("light", "1");
                return params;
            }
        };
        queue.add(stringRequest);

    }

    private void turnOffLights() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(MainActivity.this, "Turning off lights", Toast.LENGTH_SHORT).show();
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(MainActivity.this, "Some error", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("light", "00");
                return params;
            }
        };
        queue.add(stringRequest);

    }
}