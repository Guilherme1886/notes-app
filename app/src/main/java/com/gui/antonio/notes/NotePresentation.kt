package com.gui.antonio.notes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotePresentation(
    val title: String,
    val description: String
) : Parcelable