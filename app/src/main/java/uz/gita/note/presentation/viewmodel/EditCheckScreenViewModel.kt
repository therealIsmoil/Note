package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.note.data.model.CheckData

interface EditCheckScreenViewModel {
    val onClickBackLiveData: LiveData<Unit>

    fun onClickBack()
    fun onClickSaveButton(data: CheckData)
    fun onClickDelete(data: CheckData)
}