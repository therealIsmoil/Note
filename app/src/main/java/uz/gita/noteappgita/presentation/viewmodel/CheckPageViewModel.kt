package uz.gita.noteappgita.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.noteappgita.data.model.CheckData

interface CheckPageViewModel {
    val getAllCheckLiveData: LiveData<List<CheckData>>
    val onClickItemLiveData: LiveData<CheckData>
    val noDataLiveData: LiveData<Unit>
    val haveDataLiveData: LiveData<Unit>

    fun loadAllData()
    fun onClickItem(data: CheckData)
    fun onClickCheckBox(data: CheckData)
}