package io.ionic.starter;

import com.alibaba.ha.adapter.AliHaAdapter;
import com.alibaba.ha.adapter.AliHaConfig;
import com.alibaba.ha.adapter.Plugin;

public class MyCrashReporter {
  MyCrashReporter(AliHaConfig config){
    AliHaAdapter.getInstance().addPlugin(Plugin.crashreporter);
    AliHaAdapter.getInstance().start(config);
  }
}
