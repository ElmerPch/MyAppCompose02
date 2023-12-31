package com.example.myappcompose02

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

private val Brown = Color(0xFF742C0D)
private val Yellow = Color(0xFFF8D314)

@Composable
fun Sunflower() {
    Canvas(Modifier.size(50.dp)) {
        drawSunflower()
    }
}

fun DrawScope.drawSunflower() {
    drawPetals()
    drawCenter()
}

fun DrawScope.drawCenter() {
    val radius = 30f

    drawCircle(color = Brown, radius = radius, center = center)
}
fun DrawScope.drawPetals() {
    val numPetals = 8
    var angle = 0f
    val size = Size(width = 20f, height = 75f)

    repeat(numPetals) {
        rotate(angle) {
            drawOval(
                color = Yellow,
                topLeft = Offset(center.x - size.width / 2, center.y),
                size = size
            )
        }
        angle += 360 / numPetals
    }
}