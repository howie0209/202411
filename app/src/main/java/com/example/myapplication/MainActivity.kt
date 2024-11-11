package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.gestures.detectTapGestures


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //PointerEvents()
                    Tap()
                }
            }
        }
    }
}

@Composable
fun Tap() {
    var msg by remember { mutableStateOf("TAP相關手勢實例") }
    var count by remember { mutableStateOf("0") }

    Column {
        Text("\n" + msg + "\n計數:" + count.toString())

        Image(
            painter = painterResource(id = R.drawable.pu0),
            contentDescription = "靜宜之美",
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {msg = "後觸發onTap(短按)"
                                count+1},
                        onDoubleTap = {msg = "雙擊"
                                      count+3},
                        onLongPress = {msg = "長按"
                                      count+2},
                        onPress = {msg = "先觸發onPress(按下)"}
                    )
                }

        )
    }
}
