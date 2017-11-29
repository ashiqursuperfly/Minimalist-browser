package s.ashiqur.mybrowser;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {


    String urlNow="https://www.youtube.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView myWebView=(WebView)findViewById(R.id.myWebView);
        final EditText  enterUrleditText=(EditText)findViewById(R.id.editTextEnterUrl);
        Button buttonGoTo=(Button)findViewById(R.id.buttonGo);
        Button buttonRefresh=(Button)findViewById(R.id.buttonRefresh);
        final ProgressBar loadingBar=(ProgressBar)findViewById(R.id.progressBar);
        loadingBar.setProgress(100);

        myWebView.loadUrl(urlNow);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());


        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingBar.setVisibility(View.VISIBLE);
                loadingBar.setProgress(200);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingBar.setProgress(500);
                loadingBar.setVisibility(View.GONE);
            }

        });

        buttonGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                urlNow="https://" + enterUrleditText.getText().toString();
                myWebView.loadUrl(urlNow);

            }
        });

        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.loadUrl(urlNow);
            }
        });



    }
}
