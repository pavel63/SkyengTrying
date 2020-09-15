package com.pavelwintercompany.skyengtrying.network

object NetworkManager {


    /** @return network service for Retrofit
     */
    fun getNetworkService(): ApiInterface? {
        return ServiceGenerator.createService(ApiInterface::class.java)
    }
}