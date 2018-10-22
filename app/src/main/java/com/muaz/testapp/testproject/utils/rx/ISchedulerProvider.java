package com.muaz.testapp.testproject.utils.rx;


import io.reactivex.Scheduler;

/**
 * Created by muazekici on 16.07.2018.
 */

public interface ISchedulerProvider {

     Scheduler schedulerUI();
     Scheduler schedulerIO();
     Scheduler schedulerCPU();


}
