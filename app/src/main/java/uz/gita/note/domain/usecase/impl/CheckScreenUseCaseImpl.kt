package uz.gita.note.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.note.data.model.CheckData
import uz.gita.note.data.sources.entity.CheckEntity
import uz.gita.note.domain.repository.AppRepository
import uz.gita.note.domain.usecase.CheckScreenUseCase
import javax.inject.Inject

class CheckScreenUseCaseImpl @Inject constructor(val appRepository: AppRepository) :
    CheckScreenUseCase {
    override fun insertCheckData(checkData: CheckData): Flow<Unit> = flow {
        val data = appRepository.insertCheck(
            CheckEntity(
                checkData.id,
                checkData.checkText,
                checkData.time,
                checkData.isDeleted,
                checkData.isPinned,
                checkData.state
            )
        )
        emit(data)
    }.flowOn(Dispatchers.IO)
}