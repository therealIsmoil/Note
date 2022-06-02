package uz.gita.note.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.note.data.model.NoteData
import uz.gita.note.domain.usecase.EditNoteScreenUseCase
import uz.gita.note.presentation.viewmodel.EditNoteScreenViewModel
import javax.inject.Inject

@HiltViewModel
class EditNoteScreenViewModelImpl @Inject constructor(private val useCaseNote: EditNoteScreenUseCase) :
    EditNoteScreenViewModel, ViewModel() {
    override val backLiveData = MutableLiveData<Unit>()

    override fun onClickUpdateButton(noteData: NoteData) {
        useCaseNote.updateNote(noteData).onEach {

        }.launchIn(viewModelScope)
    }

    override fun onClickDeleteButton(noteData: NoteData) {
        useCaseNote.deleteNote(noteData).onEach {

        }.launchIn(viewModelScope)
    }

    override fun onClickBack() {
        backLiveData.value = Unit
    }

}