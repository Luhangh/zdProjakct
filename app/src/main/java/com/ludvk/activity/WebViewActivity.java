package com.ludvk.activity;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends Activity implements OnClickListener{
	 	private WebView webview;

	    private WebSettings ws;
	    private TextView btn_back,btn_bank_info_save;

	    private String titleName;
	    private String url;
	    private ProgressDialog pd ;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.webview);

	        Intent intent = getIntent();
	        url = intent.getStringExtra("url");
	       // titleName = intent.getStringExtra("name");
	        initInfoWebView(url);
	    }

	    private void initInfoWebView(String url) {
	        webview = (WebView) findViewById(R.id.wv_web_flash);
	       
	       // btn_back = (TextView) findViewById(R.id.btn_back);
	       // btn_back.setOnClickListener((OnClickListener) this);
	        if(TextUtils.isEmpty(url)) {
	            return;
	        }
	        btn_bank_info_save = (TextView) findViewById(R.id.finish_btn);
	        btn_bank_info_save.setText("网页浏览器");
	        btn_bank_info_save.setVisibility(View.VISIBLE);
	        btn_bank_info_save.setOnClickListener((OnClickListener) this);
	        webview.setDownloadListener(new MyWebViewDownLoadListener());
	        webview.setVerticalScrollBarEnabled(false);
	        webview.setHorizontalScrollBarEnabled(false);
	        ws = webview.getSettings();
	        ws.setJavaScriptEnabled(true);
	        ws.setUseWideViewPort(true);
	        ws.setLoadWithOverviewMode(true);
	        ws.setBuiltInZoomControls(false);
	        ws.setSupportZoom(false);

	        int screenDensity = getResources().getDisplayMetrics().densityDpi;
	        WebSettings.ZoomDensity zoomDensity = WebSettings.ZoomDensity.MEDIUM;
	        switch (screenDensity) {
	            case DisplayMetrics.DENSITY_LOW:
	                zoomDensity = WebSettings.ZoomDensity.CLOSE;
	                break;
	            case DisplayMetrics.DENSITY_MEDIUM:
	                zoomDensity = WebSettings.ZoomDensity.MEDIUM;
	                break;
	            case DisplayMetrics.DENSITY_HIGH:
	                zoomDensity = WebSettings.ZoomDensity.FAR;
	                break;
	        }
	        ws.setDefaultZoom(zoomDensity);

	        ws.setBlockNetworkImage(true);
	        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
	        ws.setAppCacheEnabled(true);
	        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
	        // webview.getSettings();
	        webview.setWebViewClient(new WebViewC());

	        webview.setWebChromeClient(wvcc);
	       
	            webview.loadUrl(url);
	        progress();

	    }

	    private class MyWebViewDownLoadListener implements DownloadListener {

	        @Override
	        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
	            Uri uri = Uri.parse(url);
	            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	            startActivity(intent);
	        }
	    }

	    class WebViewC extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return true;
	        }

	        public void onReceivedSslError(WebView view, SslErrorHandler handler) {
	            handler.proceed();
	        }

	        @Override
	        public void onPageStarted(WebView view, String url, Bitmap favicon) {
	            super.onPageStarted(view, url, favicon);
	        }

	        @Override
	        public void onPageFinished(WebView view, String url) {
	            ws.setBlockNetworkImage(false);
	            super.onPageFinished(view, url);
	            pd.cancel();
	        }
	    }

	    // ����WebViewChromeClient
	    WebChromeClient wvcc = new WebChromeClient() {

	        // ����Alert�¼�

	        @Override
	        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {


	            AlertDialog.Builder builder = new AlertDialog.Builder(WebViewActivity.this);


	            builder.setMessage(message);

	            builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

	                @Override
	                public void onClick(DialogInterface dialog, int which) {

	                    result.confirm();

	                }

	            });
	            builder.setCancelable(false);
	            builder.create();
	            builder.show();
	            return true;

	        }

	        @Override
	        public void onReceivedTitle(WebView view, String title) {
	            super.onReceivedTitle(view, title);
	        }


	        @Override
	        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {

	            AlertDialog.Builder builder = new AlertDialog.Builder(WebViewActivity.this);


	            builder.setMessage(message);

	            builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

	                @Override
	                public void onClick(DialogInterface dialog, int which) {

	                    result.confirm();

	                }

	            });

	            builder.setNeutralButton(android.R.string.cancel, new AlertDialog.OnClickListener() {

	                @Override
	                public void onClick(DialogInterface dialog, int which) {

	                    result.cancel();

	                }

	            });

	            builder.setCancelable(false);

	            builder.create();

	            builder.show();

	            return true;

	        }

	        @Override
	        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
	            return super.onJsPrompt(view, url, message, defaultValue, result);
	        }
	    };

	    public void progress() {
	    	pd = new ProgressDialog(WebViewActivity.this);
			pd.setMessage("加载中...");
			pd.setCanceledOnTouchOutside(false);
			pd.show();
	    }


	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {

	        if (webview != null && event.getAction() == KeyEvent.ACTION_DOWN) {
	            switch (keyCode) {
	                case KeyEvent.KEYCODE_BACK:
	                    if (webview.canGoBack() == true) {
	                        webview.goBack();
	                    } else {
	                        finish();
	                    }
	                    return true;
	            }

	        }
	        return super.onKeyDown(keyCode, event);
	    }

	    @Override
	    protected void onDestroy() {
	        webview.clearCache(true);
	        super.onDestroy();
	    }

	    @Override
	    public void onClick(View v) {
	        switch (v.getId()) {
	            /*case R.id.btn_back:
	                webActivity.this.finish();
	                break;
*/	            case R.id.finish_btn:
	                webview.clearCache(true);
	               
	                    webview.loadUrl(url);
	                progress();
	                break;
	        }
	    }
	  
}
