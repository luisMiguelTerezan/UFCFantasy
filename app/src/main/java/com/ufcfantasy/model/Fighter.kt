package com.ufcfantasy.model

data class Fighter(
    val id: Int,
    val name: String,
    val weightClass: String,
    val points: Int,
    val lastFightPoints: Int?,
    val wins: Int?,
    val losses: Int?,
    val knockouts: Int?,
    val significantStrikes: Int?,
    val knockdowns: Int?,
    val takedowns: Int?,
    val groundControl: String?,
    val imageResId: Int?,
    val heroImageResId: Int? = null
)
