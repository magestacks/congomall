
刚果商城是个从零到一的项目，包含商城业务和基础架构两个大模块，预计 2023.03 月份完成基础业务功能。

项目配套文档移步查看知识星球置顶主题。

## 模块分类

| | 模块名称 | 服务名称 | 访问地址 |
| -- | --- | --- | --- |
| 1 | congomall-message | 消息发送 eg：邮件、公众号、短信等 | http://localhost:8001 |
| 2 | congomall-customer-user | C 端用户 | http://localhost:8002 |
| 3 | congomall-gateway | 外部网关 | http://localhost:8003 |
| 4 | congomall-product | 商品服务 | http://localhost:8004 |
| 5 | congomall-cart | 购物车服务 | http://localhost:8005 |
| 6 | congomall-order | 订单服务 | http://localhost:8006 |

## Why Pay?

### 场景实战

- 解决雪花算法集群环境下生成 ID 重复问题。✅

- MySQL 单表千万深分页优化，拒绝性能深渊。
- 生产按照 ID 分库分表，如何支持按照时间进行高性能查询？✅
- 平滑上线数据库分库分表，支持运行时动态回滚功能。✅
- 按照基因法进行分库分表，通知支持买家 ID 和订单 ID 进行查询。
- 线上出现 OOM，如何第一时间通知对应开发人员？✅
- 千万数据通过并发编程高性能导入三方数据库，比如 ElasticSearch。
- 百万数据量导出，如何保障内存安全和导出性能？
- 高频考点：缓存穿透、雪崩、击穿。写出不一样的代码，拒绝做理论狂人。
- JavaAgent 封装微服务流量监控，EG: API、RocketMQ、XXL-Job...。✅
- 揭秘并行流 parallelStream 极端情况下同步单线程执行。✅
- ......

### 设计模式

多种常用与高内聚、低耦合的设计模式，重构以及扩展既有代码实战。

构建者（Builder）模式：

- 

模板方法模式：

- 分布式雪花 ID 标识位生成，使用模板方法抽象以及扩展生成方案。

- 用户注册&登陆使用邮箱验证时，模板方法复用以及扩展逻辑行为。

策略模式：

- 用户使用手机号或者邮箱或者其它方式登陆行为，通过策略模式抽象根据标识符选择。

装饰器模式：

- 通过装饰器模式本地 JVM 内存以及远端 Redis 缓存多级封装。

动态代理模式：

- 

## 功能清单

https://www.processon.com/view/link/62984d1b0e3e74603c573306

## 接口文档

https://www.apifox.cn/apidoc/project-1038592/api-21806863
