#pragma once
#include <jni.h>

jobject create_j_obj_wpc_exception_code(
    JNIEnv* env, jlong exception_code
);