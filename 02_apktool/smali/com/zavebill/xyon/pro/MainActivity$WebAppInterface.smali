.class public final Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;
.super Ljava/lang/Object;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/zavebill/xyon/pro/MainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "WebAppInterface"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"
    }
    d2 = {
        "Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;",
        "",
        "context",
        "Landroid/content/Context;",
        "<init>",
        "(Landroid/content/Context;)V",
        "saveFile",
        "",
        "fileName",
        "",
        "content",
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
.field private final context:Landroid/content/Context;


# direct methods
.method public static synthetic $r8$lambda$zAZHhG5peXxAi7FA2fCO4TVpW2U(Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;->saveFile$lambda$0(Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;->context:Landroid/content/Context;

    return-void
.end method

.method private static final saveFile$lambda$0(Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 164
    iget-object p0, p0, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;->context:Landroid/content/Context;

    check-cast p0, Lcom/zavebill/xyon/pro/MainActivity;

    invoke-virtual {p0, p1, p2}, Lcom/zavebill/xyon/pro/MainActivity;->triggerSaveFile(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public final saveFile(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    const-string v0, "fileName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "content"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 162
    iget-object v0, p0, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;->context:Landroid/content/Context;

    instance-of v1, v0, Lcom/zavebill/xyon/pro/MainActivity;

    if-eqz v1, :cond_0

    .line 163
    check-cast v0, Lcom/zavebill/xyon/pro/MainActivity;

    new-instance v1, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0, p1, p2}, Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface$$ExternalSyntheticLambda0;-><init>(Lcom/zavebill/xyon/pro/MainActivity$WebAppInterface;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/zavebill/xyon/pro/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method
