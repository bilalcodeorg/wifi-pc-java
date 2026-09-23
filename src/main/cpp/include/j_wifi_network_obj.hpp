#pragma once
#include <jni.h>
#include <string>

jobject j_wifi_network_obj(
    JNIEnv* env, const std::string& name,
    short signal_quality, bool is_secured
);