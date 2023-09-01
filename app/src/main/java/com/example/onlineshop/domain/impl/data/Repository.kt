package com.example.onlineshop.domain.impl.data

import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.model.UserInfo

interface Repository {
    suspend fun getUserInfo(): Response<UserInfo>
}