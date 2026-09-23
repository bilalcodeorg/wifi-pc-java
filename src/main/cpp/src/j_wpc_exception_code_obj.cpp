#include <j_wpc_exception_code_obj.hpp>
#include <jni.h>

jobject j_wpc_exception_code_obj(
    JNIEnv* env, jlong exception_code
) {
    // Find the class
    jclass wpc_exception_code_class = env->FindClass(
        "com/bilalcode/wifipc/error/WpcExceptionCode"
    );
    if (wpc_exception_code_class == NULL) return NULL; // exception already thrown

    // Get constructor method ID: MyData(String, int)
    jmethodID wpc_exception_code_constructor = env->GetMethodID(
        wpc_exception_code_class, "<init>", "(J)V"
    );
    if (wpc_exception_code_constructor == NULL) return NULL;

    // Create the object
    jobject obj = env->NewObject(
        wpc_exception_code_class, wpc_exception_code_constructor,
        exception_code
    );

    return obj;
}