/*
 * Copyright 2025 Toint (599818663@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.toint.oktool.model;

import jakarta.annotation.Nullable;
import lombok.Getter;

import java.time.Duration;

/**
 * 重试策略
 *
 * @author Toint
 * @date 2025/5/31
 */
@Getter
public class RetryPolicy {
    /**
     * 重试次数 (不包含首次执行, 小于1表示不重试, 但无论如何方法会执行1次)
     */
    private final int retrySize;

    /**
     * 间隔时间 (null 或 小于等于0, 表示立刻重试不会等待)
     */
    @Nullable
    private final Duration intervalTime;

    /**
     * 匹配异常类型 (null 不会重试)
     */
    @Nullable
    private final Class<? extends Throwable> exceptionClass;

    /**
     * 重试时是否打印异常信息 (默认 false 不打印)
     */
    private final boolean printStackTrace;

    /**
     * @param retrySize      重试次数 (不包含首次执行, 小于1表示不重试, 但无论如何方法会执行1次)
     * @param intervalTime   间隔时间 (null 或 小于等于0, 表示立刻重试不会等待)
     * @param exceptionClass 匹配异常类型 (null 不会重试)
     */
    public RetryPolicy(final int retrySize,
                       @Nullable final Duration intervalTime,
                       @Nullable final Class<? extends Throwable> exceptionClass) {
        this.retrySize = retrySize;
        this.intervalTime = intervalTime;
        this.exceptionClass = exceptionClass;
        this.printStackTrace = false;
    }

    /**
     * @param retrySize       重试次数 (不包含首次执行, 小于1表示不重试, 但无论如何方法会执行1次)
     * @param intervalTime    间隔时间 (null 或 小于等于0, 表示立刻重试不会等待)
     * @param exceptionClass  匹配异常类型 (null 不会重试)
     * @param printStackTrace 重试时是否打印异常信息 (false 不打印)
     */
    public RetryPolicy(final int retrySize,
                       @Nullable final Duration intervalTime,
                       @Nullable final Class<? extends Throwable> exceptionClass,
                       final boolean printStackTrace) {
        this.retrySize = retrySize;
        this.intervalTime = intervalTime;
        this.exceptionClass = exceptionClass;
        this.printStackTrace = printStackTrace;
    }
}
