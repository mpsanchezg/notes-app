package com.devskiller.notepadplus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.devskiller.notepadplus.databinding.ActivityMainBinding
import com.devskiller.notepadplus.databinding.FragmentWelcomeBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val viewModel: MainViewModel = MainViewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // START YOUR CHANGE
    setupView()
    // END YOUR CHANGE
  }

  override fun onResume() {
    super.onResume()
    setupView()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    super.onCreateOptionsMenu(menu)

    menuInflater.inflate(R.menu.menu, menu)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
    R.id.create_note -> {
      // START YOUR CHANGE
      goToChangeNote()
      // END YOUR CHANGE
      true
    }

    else -> super.onOptionsItemSelected(item)
  }

  private fun setupView() {

    if (viewModel.areNoteListEmpty()) {
      val welcomeFragment = WelcomeFragment.newInstance()
      supportFragmentManager
        .beginTransaction()
        .add(R.id.fl_fragment_container, welcomeFragment)
        .commitNow()
    } else {
      val noteListFragment = NoteListFragment.newInstance()
      supportFragmentManager
        .beginTransaction()
        .add(R.id.fl_fragment_container, noteListFragment)
        .commitNow()
    }

  }

  private fun goToChangeNote() {
    val intent = ChangeNoteActivity.newIntent(this, UUID.randomUUID())
    startActivity(intent)
  }
}
