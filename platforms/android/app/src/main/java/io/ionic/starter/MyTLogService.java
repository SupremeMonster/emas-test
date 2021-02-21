package io.ionic.starter;

import com.alibaba.ha.adapter.AliHaAdapter;
import com.alibaba.ha.adapter.AliHaConfig;
import com.alibaba.ha.adapter.Plugin;
import com.alibaba.ha.adapter.service.tlog.TLogLevel;

public class MyTLogService {
   MyTLogService(AliHaConfig config){
    AliHaAdapter.getInstance().addPlugin(Plugin.tlog);             //移动日志，如不需要可注释掉
    AliHaAdapter.getInstance().openDebug(true);          //调试日志开关
    AliHaAdapter.getInstance().start(config);                     //启动
    com.alibaba.ha.adapter.service.tlog.TLogService.updateLogLevel(TLogLevel.VERBOSE);
  }
  public void log(String module,String tag,String content){
    com.alibaba.ha.adapter.service.tlog.TLogService.loge(module,tag,content);
  }

}
