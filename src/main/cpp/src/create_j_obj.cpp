#include <create_j_obj.hpp>
#include <j_class_map.hpp>
#include <j_method_id_map.hpp>

jobject create_j_obj_native_scan_result(
    JNIEnv* env, jobjectArray networks, jobject exception
) {
    // Find the class
    jclass wpc_scan_class = env->FindClass(
        j_wpc::class_map::kNativeScanResult.data()
    );
    if (wpc_scan_class == nullptr) return nullptr; // exception already thrown

    // Get constructor method ID: MyData(String, int)
    jmethodID wpc_scan_constructor = env->GetMethodID(
        wpc_scan_class, "<init>",
        j_wpc::method_id::kNativeScanResult.data()
    );
    if (wpc_scan_constructor == nullptr) return nullptr;

    // Create the object
    jobject obj = env->NewObject(
        wpc_scan_class, wpc_scan_constructor,
        networks, exception
    );

    return obj;
}

jobject create_j_obj_wpc_exception_code(
    JNIEnv* env, jlong exception_code
) {
    // Find the class
    jclass wpc_exception_code_class = env->FindClass(
        j_wpc::class_map::kWpcExceptionCode.data()
    );
    // exception already thrown
    if (wpc_exception_code_class == nullptr) return nullptr;

    // Get constructor method ID: MyData(String, int)
    jmethodID wpc_exception_code_constructor = env->GetMethodID(
        wpc_exception_code_class, "<init>",
        j_wpc::method_id::kWpcExceptionCode.data()
    );
    if (wpc_exception_code_constructor == nullptr) return nullptr;

    // Create the object
    jobject obj = env->NewObject(
        wpc_exception_code_class, wpc_exception_code_constructor,
        exception_code
    );

    return obj;
}

jobject create_j_obj_wpc_wifi_network(
    JNIEnv* env, const std::string& name,
    short signal_quality, bool is_secured
) {
    // Find the class
    jclass wifi_network_class = env->FindClass(
        j_wpc::class_map::kWpcWifiNetwork.data()
    );
    // exception already thrown
    if (wifi_network_class == nullptr) return nullptr;

    // Get constructor method ID: MyData(String, int)
    jmethodID wifi_network_constructor = env->GetMethodID(
        wifi_network_class, "<init>", j_wpc::method_id::kWpcWifiNetwork.data()
    );
    if (wifi_network_constructor == nullptr) return nullptr;

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