package io.ionic.starter;

import android.app.Application;
import android.util.Log;
import com.alibaba.ha.adapter.AliHaConfig;
public class MyApplication extends Application {
  private final static String mAppKey = "333379717";
  private final static String mAppSecret = "1edc1f4e248c4a6bb4490cbea6d64bd4";
  private final static String mHARSAPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCw7n7jb0XQbGPNlLHO62yU/ma6fvEUtZJBWH1Q7rJZI+OtCve6uNM8FJT2tqonV3BHNkt2Lx0wL9Ed6lifWU7bcpTz+Be0a1zp5YL4aZ4Ob0PuRWl1lljqDX8yiw2Z5Co9iMWO+JrhEZ/SIlZQqeDylR3fo9mfDkTMlURFdQyUlQIDAQAB";

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
