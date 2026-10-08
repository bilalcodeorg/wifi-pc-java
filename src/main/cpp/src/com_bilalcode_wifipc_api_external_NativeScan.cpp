#include <jni/com_bilalcode_wifipc_api_external_NativeScan.h>
#include <wifi_pc/error_code.hpp>
#include <wifi_pc/error.hpp>
#include <create_j_obj.hpp>
#include <wifi_pc/scan.hpp>
#include <j_class_map.hpp>
#include <memory>
#include <jni.h>

JNIEXPORT jobject JNICALL
Java_com_bilalcode_wifipc_api_external_NativeScan_newScan(
    JNIEnv* env, jclass j_class
) {
    long exception_code = 0;
    jobjectArray j_wifi_network_obj_arr;
    jobject exception_obj;
    jobject nativeScanResult;

    try {
        wpc::Scan scan;

        jclass j_wifi_network_class = env->FindClass(
            j_wpc::class_map::kWpcWifiNetwork.data()
        );
        j_wifi_network_obj_arr = env->NewObjectArray(
            scan.networks().size(), j_wifi_network_class, nullptr
        );
        if (j_wifi_network_obj_arr == nullptr) return nullptr;

        for (size_t i = 0; i < scan.networks().size(); i++) {
            const auto& network = scan.networks()[i];

            jobject jWifiNetworkObj = create_j_obj_wpc_wifi_network(
                env, network.name(), network.signal_quality(),
                network.IsSecured()
            );

            env->SetObjectArrayElement(
                j_wifi_network_obj_arr, i, jWifiNetworkObj
            );
        }
    }
    catch (const wpc::Error& e) {
        exception_code = e.code();
    }

    exception_obj = create_j_obj_wpc_exception_code(env, exception_code);
    nativeScanResult = create_j_obj_native_scan_result(
        env, j_wifi_network_obj_arr,
        exception_obj
    );

    return nativeScanResult;
}