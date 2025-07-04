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

package cn.toint.oktool.util;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * @author Toint
 * @date 2025/5/31
 */
public class AssertTest {
    @Test
    void notNull() {
        Assert.notNull("test", "must not be null");
    }

    @Test
    void validate() {
//        // 原生使用
//        // 报错: jakarta.validation.ValidationException: pojo 不能为null
//        final Pojo pojo = new Pojo();
//        pojo.setName("test");
//        pojo.setAge(18);
//        pojo.setPojo(null);
//        Assert.validate(pojo);

//        // 原生使用
//        // 报错: jakarta.validation.ValidationException: pojo.name 不能为空
//        final Pojo pojo = new Pojo();
//        pojo.setName("test");
//        pojo.setAge(18);
//        pojo.setPojo(new Pojo());
//        Assert.validate(pojo);

//        // 模板预留报错信息, 自动填充
//        // 报错: java.lang.IllegalArgumentException: 发生异常, 原因: pojo.pojo 不能为null
//        final Pojo pojo = new Pojo();
//        pojo.setName("test");
//        pojo.setAge(18);
//        pojo.setPojo(new Pojo());
//        Assert.validate(pojo, "发生异常, 原因: {}");

//        // 模板预留报错信息, 并自定义模板与参数, 自动填充
//        // java.lang.IllegalArgumentException: 发生异常, 时间: 2025-05-31 07:30:51, 原因: pojo.name 不能为空
//        final Pojo pojo = new Pojo();
//        pojo.setName("test");
//        pojo.setAge(18);
//        pojo.setPojo(new Pojo());
//        Assert.validate(pojo, "发生异常, 时间: {}, 原因: {}", DateUtil.formatNow());

//        // 模板未预留报错信息, 忽略
//        // java.lang.IllegalArgumentException: 发生异常, 时间: 2025-05-31 07:31:21
//        final Pojo pojo = new Pojo();
//        pojo.setName("test");
//        pojo.setAge(18);
//        pojo.setPojo(new Pojo());
//        Assert.validate(pojo, "发生异常, 时间: {}", DateUtil.formatNow());
    }

    @Data
    private static class Pojo {
        @NotBlank
        private String name;

        @NotNull
        private Integer age;

        @Valid
        @NotNull
        private Pojo pojo;
    }
}