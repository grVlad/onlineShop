package com.example.onlineshop.data

import com.example.onlineshop.common.Response
import com.example.onlineshop.domain.api.model.UserInfo
import com.example.onlineshop.domain.impl.data.Repository
import kotlinx.coroutines.delay
import kotlin.random.Random

internal class RepositoryImpl() : Repository {

    override suspend fun getUserInfo(): Response<UserInfo> {
        delay(1500L)

        return when (Random.nextInt(from = 1, until = 5)) {
            1, 2, 3 -> Response.Success(
                data = UserInfo(
                    name = listOf("John", "Sasha", "Vova", "Peter").random(),
                    surname = listOf("Wick", "Ivanov", "Monzikov", "Britt").random(),
                ),
            )

            else -> Response.Failed(IllegalStateException("Sample exception"))
        }
    }
}
