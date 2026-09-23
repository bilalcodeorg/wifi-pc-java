#include <j_wpc_scan_obj.hpp>
#include <jni.h>

jobject j_wpc_scan_obj(
    JNIEnv* env, jobjectArray networks, jobject exception
) {
    // Find the class
    jclass wpc_scan_class = env->FindClass(
        "com/bilalcode/wifipc/WpcScan"
    );
    if (wpc_scan_class == NULL) return NULL; // exception already thrown

    // Get constructor method ID: MyData(String, int)
    jmethodID wpc_scan_constructor = env->GetMethodID(
        wpc_scan_class, "<init>",
        "([Lcom/bilalcode/wifipc/WpcWifiNetwork;Lcom/bilalcode/wifipc/error/WpcExceptionCode;)V"
    );
    if (wpc_scan_constructor == NULL) return NULL;

    // Create the object
    jobject obj = env->NewObject(
        wpc_scan_class, wpc_scan_constructor,
        networks, exception
    );

    return obj;
}