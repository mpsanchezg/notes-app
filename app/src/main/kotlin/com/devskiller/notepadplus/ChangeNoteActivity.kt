package com.devskiller.notepadplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devskiller.notepadplus.databinding.ActivityChangeNoteBinding
import java.util.UUID

class ChangeNoteActivity : AppCompatActivity() {

  private lateinit var binding: ActivityChangeNoteBinding
  private val viewModel: ChangeNoteViewModel = ChangeNoteViewModel()

  companion object {

    private const val EXTRA_NOTE_ID = "com.devskiller.intent.note_id"

    fun newIntent(
      context: Context,
      uuid: UUID
    ): Intent = Intent(context, ChangeNoteActivity::class.java)
      .putExtra(EXTRA_NOTE_ID, uuid)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityChangeNoteBinding.inflate(layoutInflater)

    setContentView(binding.root)

    // START YOUR CHANGE
    setUpView()
    // END YOUR CHANGE
  }

  private fun setUpView() {
    val extras = intent.extras
    val uuid: UUID = extras?.get(EXTRA_NOTE_ID) as UUID

    binding.etTitle.error = getString(R.string.field_not_be_empty_error)
    binding.bSave.setOnClickListener {
      saveNote(uuid)
    }
  }

  private fun saveNote(uuid: UUID) {
    binding.etTitle.text?.let {
      viewModel.addOrUpdateNote(uuid, it.toString(), binding.etDescription.text.toString())
    } ?: run {
      binding.etTitle.error
    }
    goBackToMainActivity()
  }

  private fun goBackToMainActivity() {
    this.finish()
  }

}
