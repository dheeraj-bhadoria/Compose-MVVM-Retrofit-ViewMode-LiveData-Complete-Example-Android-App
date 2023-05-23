package com.dheeraj.composemvvm.service

import CreditCardResponse
import com.dheeraj.composemvvm.model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("credit_cards")
    suspend fun getCreditCards(): CreditCardResponse
}