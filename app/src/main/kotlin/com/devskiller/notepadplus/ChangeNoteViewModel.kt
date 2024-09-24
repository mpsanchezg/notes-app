package com.devskiller.notepadplus

import androidx.lifecycle.ViewModel
import java.util.UUID

class ChangeNoteViewModel : ViewModel() {
  fun addOrUpdateNote(
    uuid: UUID?,
    title: String?,
    description: String?
  ): Boolean {
    uuid?.let {
      val note: Note? = NoteLab.getNote(uuid)

      if (note !== null) {
        updateNote(note, title, description)
        return true
      } else {
        title?.let {
          addNewNote(title, description)
          return true
        } ?: return false
      }
    } ?: title?.let {
      addNewNote(title, description)
      return true

    } ?: return false
  }

  private fun addNewNote(title: String, description: String?) {
    NoteLab.addNote(
      Note(
        title = title,
        description = description
      )
    )
  }

  private fun updateNote(note: Note, newTitle: String?, newDescription: String?) {
    note.apply {
      newTitle?.let {
        this.title = newTitle
      }
      newDescription?.let {
        this.description = newDescription
      }
    }
  }
}
