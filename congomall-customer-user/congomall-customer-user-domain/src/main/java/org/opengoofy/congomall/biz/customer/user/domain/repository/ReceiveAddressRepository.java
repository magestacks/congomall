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

package org.opengoofy.congomall.biz.customer.user.domain.repository;

import org.opengoofy.congomall.biz.customer.user.domain.mode.ReceiveAddress;

import java.util.List;

/**
 * 用户收货地址仓储层
 *
 * @author chen.ma
 * @github <a href="https://github.com/opengoofy" />
 * @公众号 马丁玩编程，关注回复：资料，领取后端技术专家成长手册
 */
public interface ReceiveAddressRepository {
    
    /**
     * 根据用户 ID 查询收货地址
     *
     * @param customerUserId
     * @return
     */
    List<ReceiveAddress> listReceiveAddressByCustomerUserId(String customerUserId);
    
    /**
     * 新增用户收货地址
     *
     * @param receiveAddress
     */
    void saveReceiveAddress(ReceiveAddress receiveAddress);
    
    /**
     * 根据用户 ID、收货地址 ID 删除收货地址
     *
     * @param customerUserId
     * @param receiveAddressId
     */
    void removeReceiveAddress(String customerUserId, String receiveAddressId);
}
