package com.gui.antonio.notes

data class NotePresentation(
    val title: String,
    val description: String
)

fun getNotes() = listOf(
    NotePresentation(
        title = "My day",
        description = "i will to the doctor"
    ),
    NotePresentation(
        title = "Job",
        description = "payment will be today"
    ),
    NotePresentation(
        title = "Study",
        description = "Germany and English study today"
    ),
    NotePresentation(
        title = "Vacation",
        description = "Go to Sao Paulo in the next week"
    )
)