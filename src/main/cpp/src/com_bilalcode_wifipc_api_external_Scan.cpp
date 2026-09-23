#include <com_bilalcode_wifipc_api_external_Scan.h>
#include <j_wpc_exception_code_obj.hpp>
#include <wifi_pc/error_code.hpp>
#include <j_wifi_network_obj.hpp>
#include <j_wpc_scan_obj.hpp>
#include <wifi_pc/error.hpp>
#include <wifi_pc/scan.hpp>
#include <memory>
#include <jni.h>

JNIEXPORT jobject JNICALL
Java_com_bilalcode_wifipc_api_external_Scan_newScan(
    JNIEnv* env, jclass j_class
) {
    long exception_code = 0;
    jobjectArray jWifiNetworkObjArray;
    jobject exception_obj;
    jobject wpcScanObj;

    try {
        wpc::Scan scan;

        jclass jWifiNetworkClass = env->FindClass(
            "com/bilalcode/wifipc/WpcWifiNetwork"
        );
        jWifiNetworkObjArray = env->NewObjectArray(
            scan.networks().size(), jWifiNetworkClass, NULL
        );
        if (jWifiNetworkObjArray == NULL) return NULL;

        for (int i = 0; i < scan.networks().size(); i++) {
            const auto& network = scan.networks()[i];
            jobject jWifiNetworkObj = j_wifi_network_obj(
                env, network.name(), network.signal_quality(),
                network.IsSecured()
            );

            env->SetObjectArrayElement(
                jWifiNetworkObjArray, i, jWifiNetworkObj
            );
        }
    }
    catch (const wpc::Error& e) {
        exception_code = e.code();
    }

    exception_obj = j_wpc_exception_code_obj(env, exception_code);
    wpcScanObj = j_wpc_scan_obj(env, jWifiNetworkObjArray, exception_obj);

    return wpcScanObj;
}