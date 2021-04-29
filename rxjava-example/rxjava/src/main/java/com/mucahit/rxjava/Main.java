package com.mucahit.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();

        useObserver();

        createColdObservable();

        createHotAndConectableObservable();

        createSingle();

        createMaybe();

        createCompletable();

        helloWorld();

        mergeExample();

    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(integer -> System.out.println(integer));
        System.out.println("******************");

    }

    private static void createObservableFromIterable() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(integers);
        observable.subscribe(System.out::println);
        System.out.println("******************");

    }

    private static void createObservableUsingCreate() {
        Observable observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(1);
            observableEmitter.onNext(2);
            observableEmitter.onNext(3);
            observableEmitter.onNext(4);
            observableEmitter.onNext(5);
            observableEmitter.onComplete();
        });


        //you can not push null object  - throws null pointer exception
        observable.subscribe(item -> System.out.println(item), throwable -> System.out.println(throwable.getClass()), () -> System.out.println("Completed"));
        System.out.println("******************");

    }

    private static void useObserver() {
        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5);

        Observer<Integer> integerObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                System.out.println(throwable.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        };

        integerObservable.subscribe(integerObserver);
        System.out.println("******************");
    }

    private static void createColdObservable() throws InterruptedException {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(integer -> System.out.println("observer 1 ->" + integer));
        Thread.sleep(3000);
        observable.subscribe(integer -> System.out.println("observer 2 ->" + integer));
        System.out.println("******************");

    }

    private static void createHotAndConectableObservable() throws InterruptedException {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();
        observable.subscribe(integer -> System.out.println(integer));
        //observable.connect();
        System.out.println("******************");

    }

    private static void createSingle() throws InterruptedException {
        Single.just("Hello Single").subscribe(System.out::println);
        System.out.println("******************");

    }

    private static void createMaybe() throws InterruptedException {

        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onSuccess(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }

            @Override
            public void onComplete() {

                System.out.println("Done");

            }
        });
        System.out.println("******************");

    }

    private static void createCompletable() throws InterruptedException {
        Completable.fromSingle(Single.just("Hello Completable")).subscribe(() -> System.out.println("Done"));
        System.out.println("******************");

    }


    //Here it is a simple inline “Hello World” code using an observable and immediate subscription:
    private static void helloWorld() {
        Observable.just("Hello World").subscribe(System.out::println);
        System.out.println("******************");

    }

    private static void mergeExample() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> observable2 = Observable.just(7, 8);
        Observable.merge(observable1, observable2).filter(integer -> integer % 2 == 0).map(integer -> integer = integer+1).subscribe(integer -> System.out.println("Square of "+integer+" is "+integer*integer));
        System.out.println("******************");

    }


}
