package com.devskiller.notepadplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devskiller.notepadplus.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

  private lateinit var binding: FragmentWelcomeBinding

  companion object {

    fun newInstance(): WelcomeFragment = WelcomeFragment()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // START REFACTOR OF THIS METHOD
    binding = FragmentWelcomeBinding.inflate(inflater, container, false)
    // END REFACTOR OF THIS METHOD
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupView()
  }

  private fun setupView() {
    binding.tvWelcome.text = getString(R.string.welcome_message)
  }
}
