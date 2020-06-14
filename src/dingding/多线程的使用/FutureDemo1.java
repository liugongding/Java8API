package dingding.多线程的使用;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liudingding
 * @ClassName Solution
 * @description
 * @date 2020/6/13 1:44 下午
 */
public class FutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = null;

        for (int i = 0; i < 10; i++) {
            //将任务提交给线程池
            future = executorService.submit(new TaskResult(i));
            //线程池处理任务完成之后会返回一个结果，将这个结果保存在list中
            futureList.add(future);
        }

        for (int i = 0; i < futureList.size(); i++) {
            System.out.println(futureList.get(i).get());
        }
        //当拿到future的结果才返回ture
        if (future.isDone()) {
            System.out.println("完成");
        }

        executorService.shutdown();
    }
}


//Callable方法返回的是String类型的
class TaskResult implements Callable<String>{

    private int taskId;

    TaskResult (int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        return "执行结果：" + taskId;
    }
}