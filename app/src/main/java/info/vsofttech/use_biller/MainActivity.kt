package info.vsofttech.use_biller

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var myWebView: WebView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.webView)
        myWebView!!.webViewClient = WebViewClient()
        myWebView!!.loadUrl("http://usebiller.com/")

        // this will enable the javascript settings, it can also allow xss vulnerabilities
        myWebView!!.settings.javaScriptEnabled = true

        myWebView!!.settings.savePassword = true

        // if you want to enable zoom feature
        myWebView!!.settings.setSupportZoom(true)
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (myWebView!!.canGoBack())
            myWebView!!.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}