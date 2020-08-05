package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class DiscardOldestNPolicy implements RejectedExecutionHandler {
    private int discardNumber = 5;
    private List<Runnable> discardList = new ArrayList<>();

    public DiscardOldestNPolicy(int discardNumber) {
        this.discardNumber = discardNumber;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        if (executor.getQueue().size()>discardNumber){
            //丢弃前五个
            executor.getQueue().drainTo(discardList,discardNumber);
            discardList.clear();
            if (!executor.isShutdown()){
                //重试任务
                executor.execute(r);
            }
        }

    }
}
