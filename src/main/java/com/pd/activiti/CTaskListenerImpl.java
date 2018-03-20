package com.pd.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @Description:
 * @author: youpd@asiainfo.com
 * @create: 2018-03-19 15:33
 */
public class CTaskListenerImpl implements TaskListener {
    //指定任务的办理人
    public void notify(DelegateTask delegateTask) {
        //指定个人任务的办理人
        delegateTask.setAssignee("youpeng2_CTaskListener");
        System.out.println("---------------  com.pd.activiti.CTaskListenerImpl");

    }
}
