#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_wb_bikeapp_helper_Keys_apiKey(JNIEnv *env, jobject object) {
    std::string api_key = "bba260e02125959afb9c52db0c960f56f7e75bd3";
    return env->NewStringUTF(api_key.c_str());
}