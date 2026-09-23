# CMakeList.txt : CMake project for wlan-pc-bcode, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.10)

# Enable Hot Reload for MSVC compilers if supported.
if (POLICY CMP0141)
  cmake_policy(SET CMP0141 NEW)
  set(CMAKE_MSVC_DEBUG_INFORMATION_FORMAT "$<IF:$<AND:$<C_COMPILER_ID:MSVC>,$<CXX_COMPILER_ID:MSVC>>,$<$<CONFIG:Debug,RelWithDebInfo>:EditAndContinue>,$<$<CONFIG:Debug,RelWithDebInfo>:ProgramDatabase>>")
endif()

project (WifiPcJava VERSION 1.0 LANGUAGES CXX)

# Sub project
add_subdirectory(external/wifipc)

# Add library
add_library(
	WifiPcJava SHARED
	src/test.cpp
)
add_library(WifiPc::Java ALIAS WifiPcJava)
target_include_directories(WifiPc
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}/include
	PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/external/wifi/include
	PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/external/java/include
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/external/java/win32/include
)
target_link_libraries(WifiPcJava PRIVATE WifiPc::CAbi)

# Cmake version
set_target_properties(
    WifiPcJava
    PROPERTIES
        CXX_STANDARD 20
        CXX_STANDARD_REQUIRED ON
        CXX_EXTENSIONS OFF
)