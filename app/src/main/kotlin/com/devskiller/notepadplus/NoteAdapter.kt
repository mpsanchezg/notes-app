package com.devskiller.notepadplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.devskiller.notepadplus.databinding.ViewNoteListItemBinding

class NoteAdapter(
    private val mNotes: List<Note>,
) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    inner class NoteHolder(
        private val mViewBinding: ViewNoteListItemBinding
    ) : RecyclerView.ViewHolder(mViewBinding.root), View.OnClickListener {

        private var mNote: Note? = null
        var noteTitle: TextView? = mViewBinding.tvNoteTitle

        override fun onClick(view: View) {
          // START YOUR CHANGE
            mNote?.let {
                val intent = ChangeNoteActivity.newIntent(view.context, it.id)
                startActivity(view.context, intent, null)
            }
          // END YOUR CHANGE
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder = NoteHolder(ViewNoteListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: NoteHolder,
        position: Int
    ) {
        // START YOUR CHANGE
        val currentNote = mNotes[position]
        holder.noteTitle?.text = currentNote.title
        // END YOUR CHANGE
    }

    override fun getItemCount(): Int {
        // START REFACTOR OF THIS METHOD
        return mNotes.size
        // END REFACTOR OF THIS METHOD
    }
}
