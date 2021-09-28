package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp {
                        MyScreenContent2()
                    }


                }
            }
        }
    }

}

@Composable
fun MyApp() {
    MaterialTheme {
        Surface(color = Yellow) {
            Greeting(name = "Android")

        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!", modifier = Modifier.padding(24.dp))

}


@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MyApp(){
            MyScreenContent2()

        }
    }
}

@Composable
fun MyApp(children:@Composable() ()-> Unit){
    MaterialTheme {
        Surface(color= White) {
            children()
        }
        
    }

}

@Composable
fun MyScreenContent(){
    Column {
        Greeting("Elahe")
        Divider(color= Blue)
        Greeting("shirashiyani")

    }
}

@Composable
fun MyScreenContent2(names:List<String> = listOf("Android", "there")){
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Black)
        }

    }
}
@Model
class CounterState(var count:Int =0)

@Composable
fun Counter(state:CounterState){
    Button(onClick = {state.count++}) {
        Text(text = "I've been clicked ${state.count} times")
        
    }
}



