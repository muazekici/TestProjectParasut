package com.muaz.testapp.testproject.utils;

import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.muaz.testapp.testproject.base.BaseEvent;

/**
 * Created by muazekici on 15.07.2018.
 */

public final class RXBus {

    private final Relay<Object> RX_BUS = PublishRelay.create().toSerialized();

    public void sendEvent(Object event){
        RX_BUS.accept(event);
    }

    public io.reactivex.Observable<Object> getBusObservable(){
        return RX_BUS;
    }

    public boolean hasObservers() {
        return RX_BUS.hasObservers();
    }

}


