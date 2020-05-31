package com.example.hellocompose.data

import androidx.ui.graphics.Color

data class Person(
    val name: String,
    val age: Int,
    val profilePictureUrl: String? = null
)

fun getPersonList() = listOf<Person>(
    Person("Grace Hopper", 25),
    Person("Ada Lovelace", 29),
    Person("John Smith", 28),
    Person("Elon Musk", 41),
    Person("Will Smith", 31),
    Person("Robert James", 42),
    Person("Anthony Curry", 91),
    Person("Kevin Jackson", 22),
    Person("Robert Curry", 1),
    Person("John Curry", 9),
    Person("Ada Jackson", 2),
    Person("Joe Defoe", 35)
)

fun getSuperheroList() = listOf(
    Person("Iron Man", 43, "https://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55.jpg"),
    Person("Hulk", 38, "https://i.annihil.us/u/prod/marvel/i/mg/5/a0/538615ca33ab0.jpg"),
    Person("Deadpool", 25, "https://i.annihil.us/u/prod/marvel/i/mg/9/90/5261a86cacb99.jpg"),
    Person("Wolverine", 48, "https://i.annihil.us/u/prod/marvel/i/mg/2/60/537bcaef0f6cf.jpg"),
    Person("Black Widow", 30, "https://i.annihil.us/u/prod/marvel/i/mg/f/30/50fecad1f395b.jpg"),
    Person("Thor", 35, "https://i.annihil.us/u/prod/marvel/i/mg/d/d0/5269657a74350.jpg"),
    Person("Rogue", 28, "https://i.annihil.us/u/prod/marvel/i/mg/3/10/5112d84e2166c.jpg"),
    Person("Groot", 4, "https://i.annihil.us/u/prod/marvel/i/mg/3/10/526033c8b474a.jpg"),
    Person("Professor X", 55, "https://i.annihil.us/u/prod/marvel/i/mg/3/e0/528d3378de525.jpg")
)

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)
