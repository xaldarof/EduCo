package uz.unical.navigation

import androidx.fragment.app.Fragment

val Fragment.toggler: Toggler
    get() = activity as Toggler


interface ReaderObserver {
    fun onFinish()
}

val Fragment.reader: ReaderObserver
    get() = (activity as ReaderObserver)