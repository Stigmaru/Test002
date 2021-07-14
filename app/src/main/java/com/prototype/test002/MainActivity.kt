package com.prototype.test002

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.io.*
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress
import java.util.*
import kotlin.math.*

// TCP Socket variables
var host = "10.0.1.2" // Linux PC IP Address
var port = 53985 // Linux forwarded port on router

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: MyViewModel by viewModels()

        setContent {
            println("View Model Created: ${model}")
        }
    }
}


class MyViewModel : ViewModel() {
    var message by mutableStateOf("")
        private set

    // TCP Socket variables
    var host = "10.0.1.2" // Linux PC IP Address
    var port = 53985 // Linux forwarded port on router

    init {
        println("VM Initialize")
        val socket = Socket()
        tcpConnect(socket)
    }

    private fun tcpConnect(socket: Socket) {
        //val socketAddress: SocketAddress = InetSocketAddress(host, port)
        //println("Socket Address: " + socketAddress.toString())

        try {
            socket.bind(null)
            socket.connect((InetSocketAddress(host, port)), 5000)
            println("Client Socket : " + socket.isConnected)
        }
        catch (e: IOException) {
            //catch logic
            println("Connection Unsuccessful")
        }
    }

    fun onMessageChange(newMessage: String) {
        message = newMessage
        println("ViewModel Updated: $message")
    }
}
