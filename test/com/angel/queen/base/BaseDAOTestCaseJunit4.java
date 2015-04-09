package com.angel.queen.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基于spring test 的Service Base
 * @author JBH
 * @since JDK1.6
 */
//将test任务交给spring容器执行
@RunWith(SpringJUnit4ClassRunner.class)
//读取spring的配置文件，初始化容器数据
@ContextConfiguration(locations = {"classpath:spring-common.xml"})
public class BaseDAOTestCaseJunit4 {

}
