package com.hhoang.cricutweather.dagger;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by hoahoang on 4/3/17.
 */

@Module
public class AppModule {
  Application mApplication;

  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return mApplication;
  }
}