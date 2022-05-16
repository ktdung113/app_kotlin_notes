package com.example.noteapp_lamlai.ViewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.noteapp_lamlai.DataBases.Repository.NoteRepository
import com.example.noteapp_lamlai.Models.Note
import kotlinx.coroutines.launch
class NoteViewModel(app: Application) : ViewModel() {

    private  val noteRepository : NoteRepository = NoteRepository(app)

    fun  insertNote(note : Note) = viewModelScope.launch {
        noteRepository.insertNote(note)

    }
    fun  updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)

    }
    fun  deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }
    fun getAllNote(): LiveData<List<Note>> = noteRepository.getAllNote()

    class NoteViewModelFactory(private  val  app: Application): ViewModelProvider.Factory{

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
                return  NoteViewModel(app) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }

    }



}