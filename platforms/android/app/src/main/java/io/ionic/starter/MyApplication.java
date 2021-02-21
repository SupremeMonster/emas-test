package io.ionic.starter;

import android.app.Application;
import android.util.Log;
import com.alibaba.ha.adapter.AliHaConfig;
public class MyApplication extends Application {
  private final static String mAppKey = "333373704";
  private final static String mAppSecret = "b924dd06634b4ba39becf54b12254af1";
  private final static String mHARSAPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZMnti5Za7TBsE1dV6MdtHneEzpgOeaPB3hB9rKe/LH8idbuNWNvPcLNYA0j9S16ztvRjdtlRYdCHTI91OtgJmvLrwj+g5Rj08JzJ4VJvYHFPm1jQubjpDASeMpLrWzD8nBZ6SlAiAYPgzbPCTbJa60bZ4761d68C6usTtfCSRVwIDAQAB";

  @Override
  public void onCreate() {
    super.onCreate();
    initLogService();
  }

  private void initLogService() {
    Log.e("ha", "init");
    AliHaConfig config = new AliHaConfig();
    config.appKey = mAppKey;
    config.appVersion = BuildConfig.VERSION_NAME;
    config.appSecret = mAppSecret;
    config.channel = "mqc_test";
    config.userNick = "dingyi";
    config.application = this;
    config.context = getApplicationContext();
    config.isAliyunos = false;
    config.rsaPublicKey = mHARSAPublicKey;
    MyTLogService myTLogService = new MyTLogService(config);
    MyCrashReporter myCrashReporter = new MyCrashReporter(config);
    myTLogService.log("MainActivity","TAG","tlog test error ");
//    throw new NullPointerException();
  }
}
