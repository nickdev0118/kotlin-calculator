import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Button(
        onClick = {
            onClick()
        },
        elevation = ButtonDefaults.elevatedButtonElevation(
            pressedElevation = 4.dp
        ),
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .padding(end = 0.dp, bottom = 0.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(2.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xDDDDDDDD)
        ),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black,
                style = TextStyle(color = Color.Black),
            )
        }
    }
}

@Preview
@Composable
fun PreviewKeypadButton() {
    KeypadButton("1", onClick = {})
}