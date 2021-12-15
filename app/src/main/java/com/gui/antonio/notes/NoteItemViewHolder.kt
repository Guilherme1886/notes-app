package com.gui.antonio.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.notes.databinding.ItemNoteBinding

//todo: https://github.com/android/architecture-components-samples/tree/main/ViewBindingSample
// see example above

class NoteItemViewHolder(
    private val itemNoteBinding: ItemNoteBinding,
    private val onClickNote: () -> Unit,
    private val onDeleteNote: () -> Unit,
    private val onEditNote: () -> Unit
) : RecyclerView.ViewHolder(itemNoteBinding.root) {

    companion object {
        fun createItemNoteBinding(parent: ViewGroup): ItemNoteBinding =
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
    }

    fun bind() {
        itemNoteBinding.apply {
            root.setOnClickListener { onClickNote.invoke() }
            noteDeleteButton.setOnClickListener { onDeleteNote.invoke() }
            noteEditButton.setOnClickListener { onEditNote.invoke() }
        }
    }


}