package com.example.myappcompose02
//https://www.youtube.com/watch?v=6ZZDPILtYlA
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappcompose02.ui.theme.MyAppCompose02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppCompose02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MyBox("Android")
                    //MyComplexLayout()
                    MyColumn()
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout() {

}

@Composable
fun MyColumn(){
    Column(Modifier.fillMaxSize(), verticalArrangement= Arrangement.Center)
    {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Green))

        Box(modifier = Modifier
            .background(Color.LightGray)
            .width(200.dp)
            .height(500.dp)
            .padding(15.dp))
        {
            var isVisible by remember {
                mutableStateOf(false)
            }
            Column()
            {
                Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Yellow))
                Button(onClick = {
                    isVisible= !isVisible
                }) {
                    Text(text = "ClickMe2 Animated")
                }
                Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Red))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "ClickMe")
                }
                Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription="employee Image")
            }
            Column(modifier = Modifier.fillMaxWidth())
            {
                Button(onClick = {
                    isVisible= !isVisible
                }) {
                    Text(text = "Click Animated")
                }
                AnimatedVisibility(
                    visible = isVisible,
                    Modifier.fillMaxWidth().weight(1f)
                ) {
                    Box(modifier =Modifier.background(Color.Red))
                }
            }
        }
    }
}

@Composable
fun MyBox(name: String) {
    //Text(text = "Hello $name!")
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            //.padding(5.dp)
            .background(Color.Cyan)
            , contentAlignment = Alignment.Center)
        {
            Box(modifier = Modifier
                .background(Color.Yellow)
                .width(120.dp)
                .height(30.dp)
                .padding(5.dp))
            {

            }
            Text("Hola $name :)", Modifier.padding(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppCompose02Theme {
        MyColumn()
    }
}