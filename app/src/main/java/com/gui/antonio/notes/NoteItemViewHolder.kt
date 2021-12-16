package com.gui.antonio.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.notes.databinding.ItemNoteBinding

//todo: https://github.com/android/architecture-components-samples/tree/main/ViewBindingSample
// see example above

class NoteItemViewHolder(
    private val itemNoteBinding: ItemNoteBinding,
    private val onClickNote: (note: NotePresentation) -> Unit,
    private val onDeleteNote: (note: NotePresentation) -> Unit,
    private val onEditNote: (note: NotePresentation) -> Unit
) : RecyclerView.ViewHolder(itemNoteBinding.root) {

    companion object {
        fun createItemNoteBinding(parent: ViewGroup): ItemNoteBinding =
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
    }

    fun bind(note: NotePresentation) {
        itemNoteBinding.apply {
            noteTitle.text = note.title
            noteDescription.text = note.description

            root.setOnClickListener { onClickNote.invoke(note) }
            noteDeleteButton.setOnClickListener { onDeleteNote.invoke(note) }
            noteEditButton.setOnClickListener { onEditNote.invoke(note) }
        }
    }


}