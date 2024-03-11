import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// This is Button UI
@Composable
fun KeypadButton(
    text: String,
    onClick: () -> Unit
) {
    // This represent Mouse Click State.
    var isClicked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                            isClicked = true
                    },
                    onTap = {
                        if (isClicked) {
                            isClicked = false
                            onClick()
                        }
                    }
                )
            }
            .padding(end = 4.dp, bottom = 4.dp)
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(4.dp)
            )
            .background(
                color = if (isClicked) Color(0xEEEEEEEE) else Color.Transparent
            )
//        backgroundColor = Color.Gray
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                style = TextStyle(color = if (isClicked) Color.White else Color.Black),
            )
        }
        if(!isClicked) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(60.dp)
                    .background(color = Color.Black)
                    .align(Alignment.BottomEnd)
            )
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(4.dp)
                    .background(color = Color.Black)
                    .align(Alignment.BottomEnd)
            )
        } else {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(60.dp)
                    .background(color = Color.Black)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(4.dp)
                    .background(color = Color.Black)
                    .align(Alignment.TopStart)
            )
        }
    }
}

@Preview
@Composable
fun PreviewKeypadButton() {
    KeypadButton("1", onClick = {})
}