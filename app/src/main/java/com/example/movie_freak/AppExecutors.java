package com.example.movie_freak;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private  static AppExecutors instance;

    public static AppExecutors getInstance() {
        if(instance==null){
            instance=new AppExecutors();
        }
        return instance;



    }

    private final ScheduledExecutorService networkIO= Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService getNetworkIO() {
        return networkIO;
    }
}
