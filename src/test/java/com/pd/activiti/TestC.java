package com.pd.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: youpd@asiainfo.com
 * @create: 2018-03-16 17:34
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestC {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

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

    /**
     * 部署流程
     */
    @Test
    public void tetDefaultProcessEngine() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().name("部署的第一个流程").addClasspathResource("activiiti/d.bpmn").deploy();
        System.out.println(deployment);
    }

    /**
     * 启动流程实例
     */
    @Test
    public void startProcessInstanceByKey() {
        Map<String, Object> var = new HashMap<String, Object>();
//        var.put("userID","1993userid");
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess_d");
        System.out.println(processInstance);
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getProcessDefinitionId());
//        processEngine.getRuntimeService().startProcessInstanceByKey();
    }

    /**
     * 查询当前人的任务
     */
    @Test
    public void createTaskQuery() {
        String name = "王五";//28101
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskAssignee(name).list();
        for (Task task : tasks) {
            System.out.println("任务id：" + task.getId());
            System.out.println("任务名称：" + task.getName());
            System.out.println("任务创建时间：" + task.getCreateTime());
            System.out.println("任务办理人：" + task.getAssignee());
            System.out.println("--------------------");
        }
    }

    /**
     * 完成我的任务
     */
    @Test
    public void complete() {
        String id = "78102";
        processEngine.getTaskService().complete(id);
        System.out.println("完成了我的任务" + id);
    }

    @Test
    public void createTaskQuery1() {
        String name = "张三";
        List<HistoricTaskInstance> tasks = processEngine.getHistoryService().createHistoricTaskInstanceQuery().taskAssignee(name).list();
        for (HistoricTaskInstance task : tasks) {
            System.out.println("任务id：" + task.getId());

        }
    }

    @Test
    public void getVariable() {
        String id = "18102";
//        processEngine.getTaskService().setVariable(id, "name", "youpengda");
        Object a = processEngine.getTaskService().getVariable(id, "name");
        System.out.println(a);
    }

    /**
     * 查询历史活动
     */
    @Test
    public void aa() {
        String id = "5601";
        List<HistoricTaskInstance> historicTaskInstances = processEngine.getHistoryService().createHistoricTaskInstanceQuery().processInstanceId(id).list();
        for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
            System.out.println(historicTaskInstance.getAssignee());
        }
    }

    @Test
    public void bb() {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskCandidateGroupIn(null).list();
    }
}
