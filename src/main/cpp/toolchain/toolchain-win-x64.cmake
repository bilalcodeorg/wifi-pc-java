# Toolchain file: Windows x86_64 via MinGW-w64
set(CMAKE_SYSTEM_NAME Windows)
set(CMAKE_SYSTEM_PROCESSOR x86_64)

# Cross-compiler prefix (Debian/Ubuntu: apt install mingw-w64)
set(TOOLCHAIN_PREFIX x86_64-w64-mingw32)

set(CMAKE_C_COMPILER   ${TOOLCHAIN_PREFIX}-gcc)
set(CMAKE_CXX_COMPILER ${TOOLCHAIN_PREFIX}-g++)
set(CMAKE_RC_COMPILER  ${TOOLCHAIN_PREFIX}-windres)
set(CMAKE_AR           ${TOOLCHAIN_PREFIX}-ar)
set(CMAKE_RANLIB       ${TOOLCHAIN_PREFIX}-ranlib)

# Where the target environment lives
set(CMAKE_FIND_ROOT_PATH /usr/${TOOLCHAIN_PREFIX})

# Search for programs on the host, but libraries/headers/packages in the target
set(CMAKE_FIND_ROOT_PATH_MODE_PROGRAM NEVER)
set(CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY)
set(CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY)
set(CMAKE_FIND_ROOT_PATH_MODE_PACKAGE ONLY)

# Optional: statically link the runtime
# so the .exe has no extra DLL dependencies
set(CMAKE_EXE_LINKER_FLAGS_INIT "-static-libgcc -static-libstdc++")