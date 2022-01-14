package com.gui.antonio.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TODO:https://github.com/android/sunflower - to follow
// TODO:https://github.com/PatilShreyas/Foodium - to follow
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun showModal(action: NoteModalBottomSheetAction) {
        val modal = ModalBottomSheet(action = action) {

        }
        modal.show(supportFragmentManager, ModalBottomSheet.TAG)
    }

}