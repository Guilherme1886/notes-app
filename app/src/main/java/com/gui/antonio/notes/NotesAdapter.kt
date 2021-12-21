package com.gui.antonio.notes

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//todo: use ListAdapter with DiffUtil
// https://github.com/android/sunflower/blob/main/app/src/main/java/com/google/samples/apps/sunflower/adapters/PlantAdapter.kt
class NotesAdapter : ListAdapter<NotePresentation, RecyclerView.ViewHolder>(NoteDiffCallback()) {

    var onClickNote: (note: NotePresentation) -> Unit = {}
    var onDeleteNote: ((NotePresentation, Int) -> Unit)? = null
    var onEditNote: ((NotePresentation, Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder(
            itemNoteBinding = NoteItemViewHolder.createItemNoteBinding(parent = parent),
            onClickNote = onClickNote,
            onDeleteNote = onDeleteNote,
            onEditNote = onEditNote
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NoteItemViewHolder).bind(getItem(position), position)
    }
}

class NoteDiffCallback : DiffUtil.ItemCallback<NotePresentation>() {
    override fun areItemsTheSame(oldItem: NotePresentation, newItem: NotePresentation): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NotePresentation, newItem: NotePresentation): Boolean {
        return oldItem == newItem
    }
}
