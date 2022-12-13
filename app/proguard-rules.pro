#AppsFlyer
-keep class com.appsflyer.** { *; }
-keep public class com.android.installreferrer.** { *; }
#Coroutines
-keep class kotlinx.coroutines.**
-dontwarn kotlinx.coroutines.**


# Retrofit
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class retrofit.** { *; }
-keepattributes *Annotation*
-keepattributes Signature
-keep class com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.*

#Dagger
-keep class javax.inject.** { *; }
-keep class **$$ModuleAdapter
-keep class **$$InjectAdapter
-keep class **$$StaticInjection

-keep class dagger.** { *; }
-keep class * extends dagger.** { *; }
-keep interface dagger.** {*;}
-dontwarn dagger.internal.codegen.**

-keep class * extends dagger.hilt.*


#Onesignal
-dontwarn com.onesignal.**
-keep class com.onesignal.ActivityLifecycleListenerCompat** {*;}

#Hawk
-keepclassmembers @com.facebook.crypto.proguard.annotations.KeepGettersAndSetters class * {
  void set*(***);
  *** get*();
}
