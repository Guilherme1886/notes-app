package com.gui.antonio.notes

import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.notes.databinding.ItemNoteBinding

//todo: https://github.com/android/architecture-components-samples/tree/main/ViewBindingSample
// see example above

class NoteItemViewHolder(
    private val itemNoteBinding: ItemNoteBinding,
    private val onClickNote: () -> Unit
) : RecyclerView.ViewHolder(itemNoteBinding.root) {

    fun bind() {
        itemNoteBinding.root.setOnClickListener { onClickNote.invoke() }
    }


}