package com.example.myappcompose02
//https://www.youtube.com/watch?v=6ZZDPILtYlA
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
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
fun MyColumn() {

    var isVisible by remember {
        mutableStateOf(false)
    }
    Column()
    {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Green))
        Row(modifier = Modifier.background(Color.Gray))
        {
            Column()
            {
                Text(text = "Ejemplo 31", modifier = Modifier.background(Color.Yellow))
                Button(onClick = {
                    isVisible = !isVisible
                }) {
                    Text(text = "ClickMe2 A")
                }
                Text(text = "Ejemplo 32", modifier = Modifier.background(Color.Red))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "ClickMe")
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "employee Image"
                )


            }
            Column()
            {
                Button(onClick = {
                    isVisible = !isVisible
                }) {
                    Text(text = "Click Me B")

                }

                AnimatedVisibility(
                    visible = isVisible
                    //,
                    // Modifier
                    //.fillMaxSize()
                    //    .weight(1f)
                ) {
                    Column(modifier = Modifier.width(100.dp))
                    {
                        Button(onClick = {
                            isVisible = !isVisible
                        }) {
                            Text(text = "Click Ani")
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .width(50.dp)
                                .height(100.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Blue)
                                .width(50.dp)
                                .height(100.dp)
                        )
                    }
                }

            }
            Column()
            {
                Canvas(modifier = Modifier
                    .padding(20.dp)
                    .size(300.dp)) {
                    drawRect(
                        Color.Black
                    )
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(100f, 50f),
                        size = Size(150f, 150f),
                        style = Stroke(
                         width = 3f
                        )
                    )
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors= listOf(Color.Blue,Color.Green),
                            center=center,
                            radius=200f
                        )
                    )
                }
            }
        }
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Adaptive(100.dp)
        ) {
            items(8) {
                Sunflower()
            }
        }
    }
}

@Composable
fun MyBox(name: String) {
    //Text(text = "Hello $name!")
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                //.padding(5.dp)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        )
        {
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .width(120.dp)
                    .height(30.dp)
                    .padding(5.dp)
            )
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