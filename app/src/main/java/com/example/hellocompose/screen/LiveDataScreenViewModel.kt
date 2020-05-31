package com.example.hellocompose.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hellocompose.data.Person
import com.example.hellocompose.data.getSuperheroList
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class LiveDataScreenViewModel : ViewModel() {
    private val superheroes = MutableLiveData<List<Person>>()

    init {
        loadSuperheroes()
    }

    fun getSuperheroes(): LiveData<List<Person>> = superheroes
    fun loadSuperheroes() = Single.fromCallable { getSuperheroList() }
        .delay(2000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            superheroes.value = it
        }
        .subscribe()
}
