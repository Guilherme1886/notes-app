package com.gui.antonio.notes

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//todo: use ListAdapter with DiffUtil
// https://github.com/android/sunflower/blob/main/app/src/main/java/com/google/samples/apps/sunflower/adapters/PlantAdapter.kt
class NotesAdapter : RecyclerView.Adapter<NoteItemViewHolder>() {

    var onClickNote: () -> Unit = {}
    var onDeleteNote: () -> Unit = {}
    var onEditNote: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder(
            itemNoteBinding = NoteItemViewHolder.createItemNoteBinding(parent = parent),
            onClickNote = onClickNote,
            onDeleteNote = onDeleteNote,
            onEditNote = onEditNote
        )
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 10
}