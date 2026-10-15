package com.zavebill.xyon.pro;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zavebill.xyon.pro.MainActivity;
import com.zavebill.xyon.pro.databinding.ActivityMainBinding;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/zavebill/xyon/pro/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "uploadMessage", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileContentToSave", "", "fileChooserLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "saveFileLauncher", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupWebChromeClient", "triggerSaveFile", "fileName", "content", "writeContentToUri", "uri", "onBackPressed", "WebAppInterface", "app_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MainActivity extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> fileChooserLauncher;
    private String fileContentToSave;
    private final ActivityResultLauncher<Intent> saveFileLauncher;
    private ValueCallback<Uri[]> uploadMessage;
    private WebView webView;

    public MainActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zavebill.xyon.pro.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.fileChooserLauncher$lambda$0(MainActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.fileChooserLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zavebill.xyon.pro.MainActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.saveFileLauncher$lambda$3(MainActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.saveFileLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fileChooserLauncher$lambda$0(MainActivity mainActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            ValueCallback<Uri[]> valueCallback = mainActivity.uploadMessage;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(activityResult.getResultCode(), activityResult.getData()));
            }
        } else {
            ValueCallback<Uri[]> valueCallback2 = mainActivity.uploadMessage;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
        mainActivity.uploadMessage = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveFileLauncher$lambda$3(MainActivity mainActivity, ActivityResult activityResult) {
        Uri data;
        String str;
        if (activityResult.getResultCode() == -1) {
            Intent data2 = activityResult.getData();
            if (data2 != null && (data = data2.getData()) != null && (str = mainActivity.fileContentToSave) != null) {
                mainActivity.writeContentToUri(data, str);
            }
        } else {
            Toast.makeText(mainActivity, "Guardado cancelado", 0).show();
        }
        mainActivity.fileContentToSave = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setContentView(inflate.getRoot());
        WebView webView = inflate.webView;
        this.webView = webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setVerticalScrollBarEnabled(false);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setHorizontalScrollBarEnabled(false);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        WebSettings settings = webView4.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.setWebViewClient(new WebViewClient());
        setupWebChromeClient();
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView6 = null;
        }
        webView6.addJavascriptInterface(new WebAppInterface(this), "AndroidBridge");
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView7;
        }
        webView2.loadUrl("file:///android_asset/index.html");
    }

    private final void setupWebChromeClient() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.zavebill.xyon.pro.MainActivity$setupWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView2, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                ValueCallback valueCallback;
                ActivityResultLauncher activityResultLauncher;
                valueCallback = MainActivity.this.uploadMessage;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                MainActivity.this.uploadMessage = filePathCallback;
                Intent createIntent = fileChooserParams != null ? fileChooserParams.createIntent() : null;
                try {
                    activityResultLauncher = MainActivity.this.fileChooserLauncher;
                    activityResultLauncher.launch(createIntent);
                    return true;
                } catch (Exception unused) {
                    MainActivity.this.uploadMessage = null;
                    Toast.makeText(MainActivity.this, "No se puede abrir el selector de archivos", 0).show();
                    return false;
                }
            }
        });
    }

    public final void triggerSaveFile(String fileName, String content) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        this.fileContentToSave = content;
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/json");
        intent.putExtra("android.intent.extra.TITLE", fileName);
        try {
            this.saveFileLauncher.launch(intent);
        } catch (Exception unused) {
            Toast.makeText(this, "No se puede abrir el diálogo de guardado", 0).show();
            this.fileContentToSave = null;
        }
    }

    private final void writeContentToUri(Uri uri, String content) {
        try {
            OutputStream openOutputStream = getContentResolver().openOutputStream(uri);
            if (openOutputStream == null) {
                return;
            }
            OutputStream outputStream = openOutputStream;
            try {
                byte[] bytes = content.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                outputStream.write(bytes);
                Toast.makeText(this, "¡Respaldo guardado con éxito!", 1).show();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar el archivo", 0).show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        if (webView.canGoBack()) {
            WebView webView3 = this.webView;
            if (webView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                webView2 = webView3;
            }
            webView2.goBack();
            return;
        }
        super.onBackPressed();
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "saveFile", "", "fileName", "", "content", "app_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class WebAppInterface {
        private final Context context;

        public WebAppInterface(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        @JavascriptInterface
        public final void saveFile(final String fileName, final String content) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(content, "content");
            Context context = this.context;
            if (context instanceof MainActivity) {
                ((MainActivity) context).runOnUiThread(new Runnable() { // from class: com.zavebill.xyon.pro.MainActivity$WebAppInterface$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.WebAppInterface.saveFile$lambda$0(MainActivity.WebAppInterface.this, fileName, content);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void saveFile$lambda$0(WebAppInterface webAppInterface, String str, String str2) {
            ((MainActivity) webAppInterface.context).triggerSaveFile(str, str2);
        }
    }
}
