# 实验五

## 要求：

（1）学习gradle 部署工具；

（2）clone示例代码到自己的码云源代码管理系统；

（3）配置系统，并运行、分析理解示例代码；

## 目的：

（1）了解Gradle部署工具；

（2）学习优秀的实例代码工程；

（3）为针对该实例工程编写冒烟测试、单元测试、集成测试、系统测试做准备

 

## 实验步骤：

如果不了解grade，则可以参考grade安装实验指南：https://www.cnblogs.com/IcanFixIt/p/6909338.html

 

以gradle版本为例

(1) clone实例代码项目：https://github.com/SERG-Delft/jpacman

(2) 下载到本地，导入你的IDE环境（Eclipse Photon或IntellJ Idea 2019，开发环境支持JUnit5）

(3) 运行冒烟测试：LauncherSmokeTest，在src/default-test/java/nl.tudelft.jpacman下； 

(4) 工程中有两个测试文件夹test和default-test,default-test是工程事先自带的测试，test是以后学生添加自己的测试用例的文件夹；

(5) 打开nl.tudelft.tudelft.jpacman.ui包中的PacManUI类，修改构造函数的第一行super（“JPacman”）,修改为super（“JPacman 2020”）;

(6) 再次运行冒烟测试，应该能发现新的窗口标题；

(7) 提交到自己的源代码库，并编写提交消息：”修改窗口标题”