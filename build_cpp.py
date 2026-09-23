# This build script requires CMake and its
# toolchain components to be installed in this machine

import os
import subprocess
import shutil
import platform

# Constants
CMAKE_SOURCE_FOLDER = os.path.join("src", "main", "cpp")
CMAKE_BUILD_FOLDER = os.path.join(CMAKE_SOURCE_FOLDER, "build")
BIN_DEST = os.path.join("src", "main", "resources", "bin")

# Variable declarations
wifi_pc_lib_file_name = ""
cmake_preset = ""
libraryFilePath = ""
libraryDestPath = ""
target_os = platform.system()
build_target = target_os + platform.machine()

if build_target == "WindowsX86_64" or build_target == "WindowsAMD64":
    cmake_preset = "windows-x64"
else:
    print(build_target)
    raise RuntimeError("Unsupported platform")

if target_os == "Windows":
    wifi_pc_lib_file_name = "wifipc_java.dll"
else:
    raise RuntimeError("Unsupported platform")

result = subprocess.run(
    [
        "cmake",
        "--preset " + cmake_preset

    ],  # command and args as a list
    cwd=CMAKE_SOURCE_FOLDER,  # path to the subfolder
    capture_output=True,  # capture stdout/stderr
    text=True
)
if result.returncode != 0:
    print(result)
    raise RuntimeError("CMake error")

result = subprocess.run(
    [
        "cmake",
        "--build",
        "--preset " + cmake_preset

    ],  # command and args as a list
    cwd=CMAKE_SOURCE_FOLDER,  # path to the subfolder
    capture_output=True,  # capture stdout/stderr
    text=True
)
if result.returncode != 0:
    print(result)
    raise RuntimeError("CMake error")

# Placing binaries in resources of java
libraryFilePath = os.path.join(CMAKE_BUILD_FOLDER, cmake_preset, wifi_pc_lib_file_name)
libraryDestPath = os.path.join(BIN_DEST, cmake_preset, wifi_pc_lib_file_name)
shutil.copy(libraryFilePath, libraryDestPath)

# Success message
print("success")
