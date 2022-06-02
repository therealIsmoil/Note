package uz.gita.note.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import toNoteData
import uz.gita.note.data.model.NoteData
import uz.gita.note.domain.repository.AppRepository
import uz.gita.note.domain.usecase.NotePageUseCase
import javax.inject.Inject

class NotePageUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    NotePageUseCase {
    override fun getAllNotes(): Flow<List<NoteData>> = flow {
        val list = appRepository.getAllNotes().map {
            it.toNoteData()
        }
        emit(list)
    }.flowOn(Dispatchers.IO)
}