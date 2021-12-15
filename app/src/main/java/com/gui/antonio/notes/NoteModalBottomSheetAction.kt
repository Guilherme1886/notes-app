package com.gui.antonio.notes

sealed class NoteModalBottomSheetAction(val model: NoteModalBottomSheetModel? = null) {
    object Adding : NoteModalBottomSheetAction()
    data class Editing(val note: NoteModalBottomSheetModel) : NoteModalBottomSheetAction(model = note)
    data class Removing(val note: NoteModalBottomSheetModel) : NoteModalBottomSheetAction(model = note)
}