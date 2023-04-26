package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    var msg = remember { mutableStateOf("Sabah")}
    var Animals = arrayListOf(R.drawable.sabah1,
        R.drawable.sabah2, R.drawable.sabah3,
        R.drawable.sabah4, R.drawable.sabah5)
    var AnimalsName = arrayListOf("京那巴魯國家公園","丹絨亞路海灘","東姑阿都拉曼公園"," 美人魚島","可可山 Le' One Kokol Elf")

    LazyColumn {
        item {
            Text(text = "沙巴的景点")
            Button(onClick = {
                context.startActivity(Intent(context, VideoActivity::class.java))
            }){
                Text(text = "看见沙巴")
            }
        }

        items(5) { index ->
            Text(text = AnimalsName[index % 10])
            Image(
                painter = painterResource(id = Animals[index % 5]),
                contentDescription = "手掌圖片")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}