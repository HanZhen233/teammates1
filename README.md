## teammates1







#### 项目功能分析:
#####  比赛信息api:
- [x] 比赛列表获取
- [x] 比赛详细信息获取
##### 用户信息api:
- [x] 用户注册（加密注册）
- [x] 用户登录
- [x]  用户登出
 
##### 队伍信息api:  
- [x]  队伍发起人添加队伍信息
- [x]  有意向的在下评论





---


#### 项目源码分析:  







##### controller package
* CompetitionController:提供比赛信息的相关接口
* UserController:提供对个人数据进行操作的数据接口
* TeamInfoController:提供对队伍信息进行操作的接口



##### entity package: 创建实体类
* User  :个人用户的基本信息
* Role  :用户的角色信息
* CompetitionInfo ：各类比赛相关信息
* CompetitonSimpleInfo :各类比赛的简单信息
* TeamInfo:各类队伍的信息
* TeamCommentsInfo:评论的信息

##### respository:dao 层提供各类jpa等数据库的操作
*  CompeRepository：提供比赛详细信息的操作
*  ComSimRepository：提供对比赛简单信息数的操作
*  SysUserRepository：提供对个人用户信息操作的接口
*  teamInfoRepository：提供对队伍信息进行操作的接口。
*  teamCommentsInfoRepository:提供招募信息评论的接口。
##### service:服务层，提供各类程序服务
* SecurityUser：关于用户细节信息的配置
* UerInfoService：从线程中获取当前用户的相关信息
* UserService：查询登录用户的相关信息
##### securityConfiguration：关于spring security的相关配置
* WebSecurityConfig：进行security 配置的主要文件
* MyPasswordEncoder：自定义的密码加密方式
