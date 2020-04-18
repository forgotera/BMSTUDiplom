package ru.skillbranch.places.utils

import androidx.lifecycle.MutableLiveData

inline fun <reified T> mutableLiveData(value: T) = MutableLiveData<T>()

inline fun <reified T> mutableLiveData() = MutableLiveData<T>()