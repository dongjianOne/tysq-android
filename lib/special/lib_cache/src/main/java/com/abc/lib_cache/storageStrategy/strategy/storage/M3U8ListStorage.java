package com.abc.lib_cache.storageStrategy.strategy.storage;

import com.abc.lib_cache.lru.DiskLruCache;
import com.abc.lib_cache.lru.LruUtils;
import com.abc.lib_cache.message.RequestMessage;
import com.abc.lib_cache.urlStrategy.IUrlInfo;
import com.abc.lib_log.JLogUtils;

import java.io.OutputStream;

/**
 * author       : frog
 * time         : 2019-09-26 15:46
 * desc         : m3u8索引的索引存储
 * version      : 1.0.0
 */
public class M3U8ListStorage extends TsStorage {

    public M3U8ListStorage(IUrlInfo urlInfo,
                           RequestMessage requestMessage,
                           OutputStream outputStream,
                           JLogUtils log) {
        super(urlInfo, requestMessage, outputStream, log);
    }

    @Override
    protected DiskLruCache.Snapshot obtainFile() {
        log.title("obtainFile");

        String bodyFileName = getFileName();

        log.add("bodyFileName").colon().add(bodyFileName).enterContent();

        return LruUtils.getInstance().getSnapshot(bodyFileName);
    }

}
