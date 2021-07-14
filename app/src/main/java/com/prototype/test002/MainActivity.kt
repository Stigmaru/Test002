package com.prototype.test002

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myVM: MyViewModel by viewModels()

        setContent {
            myVM.onMessageChange("Hello")
        }
    }
}


class MyViewModel(
    var message: String,
): ViewModel() {

    init {
        message = ""
    }

    fun onMessageChange(newMessage: String) {
        message = newMessage
        println("ViewModel Updated: $message")
    }
}

