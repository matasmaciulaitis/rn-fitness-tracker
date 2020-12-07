package com.fitnesstracker;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.fitnesstracker.GoogleFit.GoogleFitManager;

public class RNFitnessTrackerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private GoogleFitManager googleFitManager;

  public RNFitnessTrackerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.googleFitManager = new GoogleFitManager(reactContext);
  }

  @Override
  public String getName() {
    return "RNFitnessTracker";
  }

  @ReactMethod
  public void authorize(Promise promise) {
    Activity activity = getCurrentActivity();
    this.googleFitManager.authorize(promise, activity);
  }


  @ReactMethod
  public void isTrackingAvailable(Promise promise) {
    Activity activity = getCurrentActivity();
    this.googleFitManager.isTrackingAvailable(promise, activity);
  }

  @ReactMethod
  public void getStepsToday(Promise promise) {
    this.googleFitManager.getStepsToday(promise);
  }

  @ReactMethod
  public void getStepsWeekTotal(Promise promise) {
    this.googleFitManager.getStepsWeekTotal(promise);
  }

  @ReactMethod
  public void getStepsDaily(Promise promise) {
    this.googleFitManager.getStepsDaily(promise);
  }

  @ReactMethod
  public void getDistanceToday(Promise promise) {
    this.googleFitManager.getDistanceToday(promise);
  }

  @ReactMethod
  public void getDistanceWeekTotal(Promise promise) {
    this.googleFitManager.getDistanceWeekTotal(promise);
  }

  @ReactMethod
  public void queryStepsTotal(double startDate, double endDate, Promise promise) {
    long startTime = (long) (startDate/1000); // x = 1234
    long endTime= (long) (endDate/1000); // x = 1234


    this.googleFitManager.queryStepsTotal(promise, startTime, endTime);
  }

  @ReactMethod
  public void queryDistanceTotal(long startDate, long endDate, Promise promise) {
    long startTime = (long) (startDate/1000); // x = 1234
    long endTime= (long) (endDate/1000); // x = 1234

    this.googleFitManager.queryDistanceTotal(promise, startTime, endTime);
  }

  @ReactMethod
  public void getDistanceDaily(Promise promise) {
    this.googleFitManager.getDistanceDaily(promise);
  }
}
