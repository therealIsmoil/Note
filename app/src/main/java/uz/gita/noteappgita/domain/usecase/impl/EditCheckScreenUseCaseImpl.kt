package uz.gita.noteappgita.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.data.sources.entity.CheckEntity
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.usecase.EditCheckScreenUseCase
import javax.inject.Inject

class EditCheckScreenUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    EditCheckScreenUseCase {
    override fun updateCheckData(data: CheckData): Flow<Unit> = flow {
        appRepository.updateCheck(
            CheckEntity(
                data.id,
                data.checkText,
                data.time,
                data.isDeleted,
                data.isPinned,
                data.state
            )
        )
        emit(Unit)
    }.flowOn(Dispatchers.IO)

    override fun deleteCheckData(data: CheckData): Flow<Unit> = flow {
        val newData = appRepository.deleteCheck(
            CheckEntity(
                data.id,
                data.checkText,
                data.time,
                data.isDeleted,
                data.isPinned,
                data.state
            )
        )
        emit(newData)
    }.flowOn(Dispatchers.IO)
}