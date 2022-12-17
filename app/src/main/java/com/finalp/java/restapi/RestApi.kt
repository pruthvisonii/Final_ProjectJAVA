package com.finalp.java.restapi

import com.finalp.java.utils.BaseSchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Response

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
object RestApi {
     fun <T> call(disposable: CompositeDisposable, observable: Observable<Response<T>>, restSubscriber: RestSubscriber<T>,schedulerProvider: BaseSchedulerProvider){
         disposable.add(observable
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe { restSubscriber.onRestCallStart() }
            .doOnTerminate { restSubscriber.onRestCallFinish() }
            .subscribe(
                { result -> restSubscriber.onRestCallSuccess(result) },
                { throwable -> restSubscriber.onRestCallError(throwable) }
            )
        )
    }
}
