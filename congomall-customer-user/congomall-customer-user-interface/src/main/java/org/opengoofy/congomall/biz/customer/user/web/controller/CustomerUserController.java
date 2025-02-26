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

package org.opengoofy.congomall.biz.customer.user.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.opengoofy.congomall.biz.customer.user.application.req.UserLoginCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserRegisterCommand;
import org.opengoofy.congomall.biz.customer.user.application.req.UserVerifyCodeCommand;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserLoginRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.resp.UserRegisterRespDTO;
import org.opengoofy.congomall.biz.customer.user.application.service.CustomerUserService;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.opengoofy.congomall.springboot.starter.log.annotation.MLog;
import org.opengoofy.congomall.springboot.starter.web.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * C 端用户控制器
 *
 * @author chen.ma
 * @github <a href="https://github.com/opengoofy" />
 * @公众号 马丁玩编程，关注回复：资料，领取后端技术专家成长手册
 */
@MLog
@RestController
@AllArgsConstructor
@Api(tags = "C 端用户")
public class CustomerUserController {
    
    private final CustomerUserService customerUserService;
    
    @ApiOperation(value = "验证发送", notes = "包含注册验证码、登录验证等")
    @PostMapping("/api/customer-user/verify/code/send")
    public Result<Void> verifyCodeSend(@RequestBody @Valid UserVerifyCodeCommand requestParam) {
        customerUserService.verifyCodeSend(requestParam);
        return Results.success();
    }
    
    @ApiOperation("注册")
    @PostMapping("/api/customer-user/register")
    public Result<UserRegisterRespDTO> register(@RequestBody @Valid UserRegisterCommand requestParam) {
        UserRegisterRespDTO result = customerUserService.register(requestParam);
        return Results.success(result);
    }
    
    @ApiOperation("登录")
    @PostMapping("/api/customer-user/login")
    public Result<UserLoginRespDTO> login(@RequestBody @Valid UserLoginCommand requestParam) {
        UserLoginRespDTO result = customerUserService.login(requestParam);
        return Results.success(result);
    }
}
