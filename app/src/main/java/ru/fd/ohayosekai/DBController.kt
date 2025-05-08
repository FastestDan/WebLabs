package ru.fd.ohayosekai

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Date

class DBController : ViewModel(){

    private val db = Dep.thebake

    val actions = MutableLiveData<List<Action>>()

    fun addUser(type: String, start: Date, finish: Date, latlot: Float){
        viewModelScope.launch {
            db.getActionDao().add(Action(
                type = type,
                start = start.toString(),
                finish = finish.toString(),
                latlot = latlot
            ))
            actions.postValue(db.getActionDao().getAll())
        }
    }
}