package com.example.test.android.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidapp.model.DisplayState

// This is the part that display the numbers.
@Composable
fun DisplaySection(displayState: DisplayState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            .padding(30.dp),
        contentAlignment = Alignment.CenterStart
    ) {
//        displayState.displayText.forEachIndexed { index, item ->
//            AnimatedContent(
//                targetState = displayState.displayText,
//                transitionSpec = {
//                if(1 == 0) {
//                    (fadeIn(animationSpec = tween(220, delayMillis = 90)) +             scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))             .togetherWith(fadeOut(animationSpec = tween(90)))
//                } else if (targetState.contentEquals(initialState)) {
//                    println("this is first")
//                    slideInVertically { height -> height } + fadeIn(animationSpec = tween(200, delayMillis = 90)) togetherWith
//                            slideOutVertically { height -> -height } + fadeOut(animationSpec = tween(200, delayMillis = 90))
//                } else {
//                    println("this is second")
//                    slideInVertically { height -> -height } + fadeIn(animationSpec = tween(200, delayMillis = 90)) togetherWith
//                            slideOutVertically { height -> height } + fadeOut(animationSpec = tween(200, delayMillis = 90))
//                }
//            }
//            ) {
//                targetState ->
//                var char_1 = targetState[index]
//
//                Text(
//                    text = "$targetState",
//                    color = Color.Black,
//                    fontSize = 40.sp,
//                    textAlign = TextAlign.Center,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
//                    modifier = Modifier
//                        .background(Color.LightGray)
//                        .padding(10.dp)
//                )
//            }
//        }
        AnimatedContent(
            targetState = displayState.displayText.toList(),
            transitionSpec = {
                if(targetState.isEmpty()) {
                    (fadeIn(animationSpec = tween(220, delayMillis = 90)) +             scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 90)))             .togetherWith(fadeOut(animationSpec = tween(90)))
                } else if (targetState.size > initialState.size) {
                    slideInVertically { height -> height } + fadeIn(animationSpec = tween(200, delayMillis = 90)) togetherWith
                            slideOutVertically { height -> -height } + fadeOut(animationSpec = tween(200, delayMillis = 90))
                } else {
                    slideInVertically { height -> -height } + fadeIn(animationSpec = tween(200, delayMillis = 90)) togetherWith
                            slideOutVertically { height -> height } + fadeOut(animationSpec = tween(200, delayMillis = 90))
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) {
            targetCount ->
            Text(
                text = "$targetCount",
                color = Color.Black,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewDisplaySection() {
    DisplaySection(DisplayState(charArrayOf('1', '2', '3', '4', '5')))
}