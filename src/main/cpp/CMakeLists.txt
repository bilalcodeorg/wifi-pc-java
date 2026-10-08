# CMakeList.txt : CMake project for wlan-pc-bcode, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.10)

project (WifiPcJava VERSION 1.0 LANGUAGES CXX)

# Sub project
add_subdirectory(external/wifipc)
add_subdirectory(external/bstring)

# Add library
add_library(
	WifiPcJava SHARED
    src/com_bilalcode_wifipc_api_external_NativeScan.cpp
    src/create_j_obj.cpp
)
add_library(WifiPc::Java ALIAS WifiPcJava)
target_include_directories(WifiPcJava
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/include
	PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/external/java/include
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/external/java/include/win32
)
target_link_libraries(WifiPcJava PRIVATE WifiPc)
target_link_libraries(WifiPcJava PRIVATE bstr::bstr)
set_target_properties(WifiPcJava PROPERTIES
    OUTPUT_NAME "wifipc_java"
    PREFIX ""
)

# Cmake version
set_target_properties(
    WifiPcJava
    PROPERTIES
        CXX_STANDARD 17
        CXX_STANDARD_REQUIRED ON
        CXX_EXTENSIONS OFF
)