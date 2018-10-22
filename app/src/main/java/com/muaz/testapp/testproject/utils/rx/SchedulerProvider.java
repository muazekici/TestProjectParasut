package com.muaz.testapp.testproject.utils.rx;


import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by muazekici on 16.07.2018.
 */

public class SchedulerProvider implements ISchedulerProvider {

    @Override
    public Scheduler schedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler schedulerIO() {
        return Schedulers.io();
    }

    @Override
    public Scheduler schedulerCPU() {
        return Schedulers.computation();
    }
}
