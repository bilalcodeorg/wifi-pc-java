#include <com_bilalcode_wifipc_api_external_Scan.h>
#include <create_j_obj_wpc_exception_code.hpp>
#include <wifi_pc/error_code.hpp>
#include <create_j_obj_wifi_network.hpp>
#include <create_j_obj_wpc_scan.hpp>
#include <wifi_pc/error.hpp>
#include <wifi_pc/scan.hpp>
#include <memory>
#include <jni.h>

JNIEXPORT jobject JNICALL
Java_com_bilalcode_wifipc_api_external_Scan_newScan(
    JNIEnv* env, jclass j_class
) {
    long exception_code = 0;
    jobjectArray j_wifi_network_obj_arr;
    jobject exception_obj;
    jobject wpcScanObj;

    try {
        wpc::Scan scan;

        jclass j_wifi_network_class = env->FindClass(
            "com/bilalcode/wifipc/WpcWifiNetwork"
        );
        j_wifi_network_obj_arr = env->NewObjectArray(
            scan.networks().size(), j_wifi_network_class, NULL
        );
        if (j_wifi_network_obj_arr == NULL) return NULL;

        for (int i = 0; i < scan.networks().size(); i++) {
            const auto& network = scan.networks()[i];
            jobject jWifiNetworkObj = create_j_obj_wifi_network(
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
    wpcScanObj = create_j_obj_wpc_scan(
        env, j_wifi_network_obj_arr,
        exception_obj
    );

    return wpcScanObj;
}