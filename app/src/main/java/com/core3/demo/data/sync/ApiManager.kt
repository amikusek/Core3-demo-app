package com.core3.demo.data.sync

import com.core3.demo.data.remote.RetrofitFactory
import com.core3.demo.data.remote.api.PostApi
import com.core3.demo.data.remote.mapper.PostMapper

class ApiManager {

    private fun <T> getApi(clazz: Class<T>) = RetrofitFactory
            .createWithoutAuthorization(clazz)
}
