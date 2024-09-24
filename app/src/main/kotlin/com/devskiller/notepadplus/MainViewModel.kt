package com.devskiller.notepadplus

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
  fun areNoteListEmpty(): Boolean {
    return NoteLab.notes.isEmpty()
  }
}
