package uz.gita.note.domain.repository

import uz.gita.note.data.sources.entity.CheckEntity
import uz.gita.note.data.sources.entity.NoteEntity

interface AppRepository {

    suspend fun getAllNotes(): List<NoteEntity>
    suspend fun insertNote(data: NoteEntity)
    suspend fun updateNote(data: NoteEntity)
    suspend fun deleteNote(data: NoteEntity)

    suspend fun getAllCheck(): List<CheckEntity>
    suspend fun insertCheck(data: CheckEntity)
    suspend fun updateCheck(data: CheckEntity)
    suspend fun deleteCheck(data: CheckEntity)
}