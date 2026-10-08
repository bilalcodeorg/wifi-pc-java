#pragma once
#include <jni.h>
#include <string>

jobject create_j_obj_native_scan_result(
    JNIEnv* env, jobjectArray networks, jobject exception
);

jobject create_j_obj_wpc_wifi_network(
    JNIEnv* env, const std::string& name,
    short signal_quality, bool is_secured
);

jobject create_j_obj_wpc_exception_code(
    JNIEnv* env, jlong exception_code
);