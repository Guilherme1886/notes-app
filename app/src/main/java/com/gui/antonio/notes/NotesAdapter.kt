package com.gui.antonio.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.notes.databinding.ItemNoteBinding

//todo: use ListAdapter with DiffUtil
// https://github.com/android/sunflower/blob/main/app/src/main/java/com/google/samples/apps/sunflower/adapters/PlantAdapter.kt
class NotesAdapter : RecyclerView.Adapter<NoteItemViewHolder>() {

    var onClickNote: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder(
            itemNoteBinding = ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClickNote = onClickNote
        )
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 10
}