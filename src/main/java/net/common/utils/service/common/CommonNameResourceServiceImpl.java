package net.common.utils.service.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import net.common.utils.service.INameResourceService;

/**
 * 提供了通用的池，与继承了ServiceLoader的类联合使用
 */
public class CommonNameResourceServiceImpl<T> implements INameResourceService<T> {
    //存放服务的缓存池
    private final Cache<String, T> clientCache;

    public CommonNameResourceServiceImpl(CacheLoader<String, T> cacheLoader) {
        this.clientCache = CacheBuilder.newBuilder().build(cacheLoader);
    }

    @Override
    public T get(String name) throws Exception {
        return clientCache.getIfPresent(name);
    }
}