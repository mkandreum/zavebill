.class public final Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;
.super Landroid/webkit/WebChromeClient;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/zavebill/xyon/pro/MainActivity;->setupWebChromeClient()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0018\u00010\u00072\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000c"
    }
    d2 = {
        "com/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1",
        "Landroid/webkit/WebChromeClient;",
        "onShowFileChooser",
        "",
        "webView",
        "Landroid/webkit/WebView;",
        "filePathCallback",
        "Landroid/webkit/ValueCallback;",
        "",
        "Landroid/net/Uri;",
        "fileChooserParams",
        "Landroid/webkit/WebChromeClient$FileChooserParams;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x0,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/zavebill/xyon/pro/MainActivity;


# direct methods
.method constructor <init>(Lcom/zavebill/xyon/pro/MainActivity;)V
    .locals 0

    iput-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    .line 92
    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onShowFileChooser(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/WebView;",
            "Landroid/webkit/ValueCallback<",
            "[",
            "Landroid/net/Uri;",
            ">;",
            "Landroid/webkit/WebChromeClient$FileChooserParams;",
            ")Z"
        }
    .end annotation

    .line 99
    iget-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    invoke-static {p1}, Lcom/zavebill/xyon/pro/MainActivity;->access$getUploadMessage$p(Lcom/zavebill/xyon/pro/MainActivity;)Landroid/webkit/ValueCallback;

    move-result-object p1

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-interface {p1, v0}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 100
    :cond_0
    iget-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    invoke-static {p1, p2}, Lcom/zavebill/xyon/pro/MainActivity;->access$setUploadMessage$p(Lcom/zavebill/xyon/pro/MainActivity;Landroid/webkit/ValueCallback;)V

    if-eqz p3, :cond_1

    .line 102
    invoke-virtual {p3}, Landroid/webkit/WebChromeClient$FileChooserParams;->createIntent()Landroid/content/Intent;

    move-result-object p1

    goto :goto_0

    :cond_1
    move-object p1, v0

    .line 104
    :goto_0
    :try_start_0
    iget-object p2, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    invoke-static {p2}, Lcom/zavebill/xyon/pro/MainActivity;->access$getFileChooserLauncher$p(Lcom/zavebill/xyon/pro/MainActivity;)Landroidx/activity/result/ActivityResultLauncher;

    move-result-object p2

    invoke-virtual {p2, p1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const/4 p1, 0x1

    return p1

    .line 107
    :catch_0
    iget-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    invoke-static {p1, v0}, Lcom/zavebill/xyon/pro/MainActivity;->access$setUploadMessage$p(Lcom/zavebill/xyon/pro/MainActivity;Landroid/webkit/ValueCallback;)V

    .line 108
    iget-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$setupWebChromeClient$1;->this$0:Lcom/zavebill/xyon/pro/MainActivity;

    check-cast p1, Landroid/content/Context;

    const-string p2, "No se puede abrir el selector de archivos"

    check-cast p2, Ljava/lang/CharSequence;

    const/4 p3, 0x0

    invoke-static {p1, p2, p3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    return p3
.end method
