package com.ufcfantasy.data

import com.ufcfantasy.R
import com.ufcfantasy.model.Fighter

object MockData {

    const val USER_POINTS = 5842
    const val GLOBAL_RANK = 412

    val fighters: List<Fighter> = listOf(
        Fighter(
            id = 1,
            name = "Alex Pereira",
            weightClass = "Meio-Pesado",
            points = 1847,
            lastFightPoints = 312,
            wins = 11,
            losses = 2,
            knockouts = 9,
            significantStrikes = 84,
            knockdowns = 4,
            takedowns = 1,
            groundControl = "42s",
            imageResId = R.drawable.fighter_alex,
            heroImageResId = R.drawable.fighter_alex_hero
        ),
        Fighter(
            id = 2,
            name = "Islam Makhachev",
            weightClass = "Peso-Leve",
            points = 1723,
            lastFightPoints = 287,
            wins = null,
            losses = null,
            knockouts = null,
            significantStrikes = null,
            knockdowns = null,
            takedowns = null,
            groundControl = null,
            imageResId = R.drawable.fighter_islam
        ),
        Fighter(
            id = 3,
            name = "Jon Jones",
            weightClass = "Peso-Pesado",
            points = 1691,
            lastFightPoints = 245,
            wins = null,
            losses = null,
            knockouts = null,
            significantStrikes = null,
            knockdowns = null,
            takedowns = null,
            groundControl = null,
            imageResId = R.drawable.fighter_jon
        ),
        Fighter(
            id = 4,
            name = "Charles Oliveira",
            weightClass = "Peso-Leve",
            points = 1580,
            lastFightPoints = 298,
            wins = null,
            losses = null,
            knockouts = null,
            significantStrikes = null,
            knockdowns = null,
            takedowns = null,
            groundControl = null,
            imageResId = R.drawable.fighter_charles
        ),
        Fighter(
            id = 5,
            name = "Tom Aspinall",
            weightClass = "Peso-Pesado",
            points = 1534,
            lastFightPoints = 276,
            wins = null,
            losses = null,
            knockouts = null,
            significantStrikes = null,
            knockdowns = null,
            takedowns = null,
            groundControl = null,
            imageResId = R.drawable.fighter_tom
        )
    )

    fun findById(id: Int): Fighter? = fighters.firstOrNull { it.id == id }
}
