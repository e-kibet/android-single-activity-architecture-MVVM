package com.example.todoapp.view.activities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.R

interface TempToolbarTitleListener {
    fun updateTitle(title: String)
}


class MainActivity : AppCompatActivity(), TempToolbarTitleListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun updateTitle(title: String) {
    }
}