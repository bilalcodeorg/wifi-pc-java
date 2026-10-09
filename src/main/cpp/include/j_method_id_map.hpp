#include <j_class_map.hpp>
#include <bstr/format.hpp>
#include <string.h>

namespace j_wpc { namespace method_id {
    
const std::string kNativeScanResult =
    bstr::format("([L{};L{};)V", 
                class_map::kWpcWifiNetwork, class_map::kWpcExceptionCode);

const std::string kWpcExceptionCode = "(J)V";
    
const std::string kWpcWifiNetwork = bstr::format("(L{};SZ)V",
                                                class_map::kJString);

}}