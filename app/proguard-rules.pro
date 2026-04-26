# TensorFlow Lite
-keep class org.tensorflow.** { *; }
-keepclasseswithmembers class org.tensorflow.** {
  *;
}

# Keep Room entities
-keep class androidx.room.** { *; }
-keep @androidx.room.Entity class * { *; }
-keepclassmembers class * {
  @androidx.room.* <fields>;
}

# Keep data classes
-keepclasses class kotlin.Metadata
-keep class kotlin.reflect.jvm.internal.** { *; }

# Keep our app classes
-keep class com.kaveriuniversity.plantdisease.** { *; }
-keepclassmembers class com.kaveriuniversity.plantdisease.** { *; }

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp3.** { *; }
-keep interface com.squareup.okhttp3.** { *; }
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }

# Gson
-keepattributes *Annotation*,EnclosingMethod
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.** { *; }
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
  public <init>();
}

# Disable obfuscation for debugging
-dontobfuscate
