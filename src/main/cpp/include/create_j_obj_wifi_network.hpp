#pragma once
#include <jni.h>
#include <string>

jobject create_j_obj_wifi_network(
    JNIEnv* env, const std::string& name,
    short signal_quality, bool is_secured
);