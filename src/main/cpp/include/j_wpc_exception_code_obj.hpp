#pragma once
#include <jni.h>

jobject j_wpc_exception_code_obj(
    JNIEnv* env, jlong exception_code
);