package com.pd.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

/**
 * @Description:
 * @author: youpd@asiainfo.com
 * @create: 2018-03-16 17:34
 */
public class Test1 {
    /**
     * 使用xml配置 简化
     */
    @Test
    public void testCreateTableWithXml() {
        // 引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 获取流程引擎对象
        ProcessEngine processEngine = pec.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void tetDefaultProcessEngine() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment=repositoryService.createDeployment().name("部署的第一个流程").addClasspathResource("activiiti/b.bpmn").deploy();
        System.out.println(deployment);
    }
}
