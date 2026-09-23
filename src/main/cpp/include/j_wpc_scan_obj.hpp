#pragma once
#include <jni.h>

jobject j_wpc_scan_obj(
    JNIEnv* env, jobjectArray networks, jobject exception
);