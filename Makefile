generate_cpp_headers:
	javac -h src/main/cpp/include/jni -d build/temp -cp src/main/java src/main/java/com/bilalcode/wifipc/api/external/*.java