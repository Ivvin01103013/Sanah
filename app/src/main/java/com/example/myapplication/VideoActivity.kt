package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.myapplication.ui.theme.MyApplicationTheme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val context = LocalContext.current
    val link = "https://rr2---sn-o097znse.googlevideo.com/videoplayback?expire=1682512439&ei=18VIZMmJLdqU8wSgpKWgDg&ip=198.199.101.47&id=o-AFhvWq3M1ByP61gSw5gVY_nojYh_z8VJ8dRITmX2Hdgi&itag=18&source=youtube&requiressl=yes&mh=D9&mm=31,26&mn=sn-o097znse,sn-a5msenll&ms=au,onr&mv=m&mvi=2&pl=24&initcwndbps=200000&spc=qEK7BxYQ6v0KLvt-UE1RdWODh7iVsl3lR_GU7cIOhQ&vprv=1&mime=video/mp4&ns=esS8SgwLWOuLQcXWToyYnHsN&cnr=14&ratebypass=yes&dur=691.676&lmt=1666648203852321&mt=1682490542&fvip=1&fexp=24007246&c=WEB_EMBEDDED_PLAYER&txp=5538434&n=GmPnfxOutgy7d2MGv&sparams=expire,ei,ip,id,itag,source,requiressl,spc,vprv,mime,ns,cnr,ratebypass,dur,lmt&sig=AOq0QJ8wRgIhAM3yyY2AM1u8ULVj7bdKweq3m4Y0NqCfm5dM74VWqhDSAiEAm7tBspjdNjDdZFSWTbxRwqcTOWOPIrPx7rFcCV013v8=&lsparams=mh,mm,mn,ms,mv,mvi,pl,initcwndbps&lsig=AG3C_xAwRAIgSJ0QUjxYJpMoYl0jWdM1FYvpcNADT-8PxavPR2CrmUkCICD9sz7fBy7wkAqOsOP-jUqos4TnPJrmwoVXiYHzdN9N&title=%E3%80%90%E9%A6%AC%E4%BE%86%E8%A5%BF%E4%BA%9E%E6%B2%99%E5%B7%B4%E7%B3%BB%E5%88%97ep.1%E3%80%91%E7%9B%B4%E6%8E%A5%E5%88%97%E7%82%BA%E5%BC%9F%E5%BC%9F%E6%B5%B7%E5%B3%B6%E5%9C%8B%E5%AE%B6%E7%AC%AC%E4%B8%80%E5%90%8D%E5%95%A6%EF%BC%81"
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)
    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        onDispose{
            exoPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyApplicationTheme {
        Greeting2("Android")
    }
}