#include <j_wifi_network_obj.hpp>
#include <jni.h>
#include <string>

jobject j_wifi_network_obj(
    JNIEnv* env, const std::string& name,
    short signal_quality, bool is_secured
) {
    // Find the class
    jclass wifi_network_class = env->FindClass(
        "com/bilalcode/wifipc/WpcWifiNetwork"
    );
    if (wifi_network_class == NULL) return NULL; // exception already thrown

    // Get constructor method ID: MyData(String, int)
    jmethodID wifi_network_constructor = env->GetMethodID(
        wifi_network_class, "<init>", "(Ljava/lang/String;SZ)V"
    );
    if (wifi_network_constructor == NULL) return NULL;

    // Prepare constructor args
    jstring name_ = env->NewStringUTF(name.data());
    jshort signal_quality_ = signal_quality;
    jboolean is_secured_ = is_secured;

    // Create the object
    jobject obj = env->NewObject(
        wifi_network_class, wifi_network_constructor,
        name_, signal_quality_, is_secured_
    );

    return obj;
}