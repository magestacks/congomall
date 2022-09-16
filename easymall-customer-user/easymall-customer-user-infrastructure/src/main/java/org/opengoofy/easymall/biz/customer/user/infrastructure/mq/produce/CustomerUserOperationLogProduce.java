/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opengoofy.easymall.biz.customer.user.infrastructure.mq.produce;

import org.opengoofy.easymall.biz.customer.user.domain.common.RocketMQConstants;
import org.opengoofy.easymall.biz.customer.user.domain.event.CustomerOperationLogEvent;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * C 端用户操作日志消息生产者
 *
 * @author chen.ma
 * @github https://github.com/itmachen
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomerUserOperationLogProduce {
    
    private final MessageChannel output;
    
    /**
     * 记录 C 用户用户变更日志
     *
     * @param customerOperationLogEvent
     */
    public void recordCustomerUserOperationLog(CustomerOperationLogEvent customerOperationLogEvent) {
        String keys = UUID.randomUUID().toString();
        Message<?> message = MessageBuilder
                .withPayload(JSON.toJSONString(customerOperationLogEvent))
                .setHeader(MessageConst.PROPERTY_KEYS, keys)
                .setHeader(MessageConst.PROPERTY_TAGS, RocketMQConstants.CUSTOMER_USER_OPERATION_LOG_TAG)
                .build();
        long startTime = System.currentTimeMillis();
        boolean sendResult = false;
        try {
            sendResult = output.send(message, 2000L);
        } finally {
            log.info("C 端用户保存用户日志，发送状态: {}, Keys: {}, 执行时间: {} ms, 消息内容: {}", sendResult, keys, System.currentTimeMillis() - startTime, JSON.toJSONString(customerOperationLogEvent));
        }
    }
}
