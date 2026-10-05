#pragma once
#include <jni.h>

jobject create_j_obj_wpc_scan(
    JNIEnv* env, jobjectArray networks, jobject exception
);