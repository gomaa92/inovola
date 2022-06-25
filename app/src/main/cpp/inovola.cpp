#include<jni.h>
#include<string>
#include<iostream>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_gomaa_inovola_AppConstantBuilder_developmentURL(JNIEnv *env, jclass clazz) {
    std::string baseURL = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/";
    return env->NewStringUTF(baseURL.c_str());
}