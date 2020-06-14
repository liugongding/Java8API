package dingding.多线程的使用;

import java.util.concurrent.*;

/**
 * @author liudingding
 * @ClassName FutureDemo2
 * @description
 * @date 2020/6/14 1:44 下午
 */
public class FutureDemo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Task());
        System.out.println("主线程在执行任务。。。");
        Thread.sleep(2000);
        System.out.println("task运行结果："+future.get());
        if (future.isDone()){
            System.out.println("完成");
        }
        System.out.println("所有任务执行完毕");


        executorService.shutdown();
    }

}


class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在执行任务");
        //模拟任务耗时
        Thread.sleep(5000);
        return 1000;
    }
}