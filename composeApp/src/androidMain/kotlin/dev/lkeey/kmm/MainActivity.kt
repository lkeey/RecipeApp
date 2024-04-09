package dev.lkeey.kmm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {

    private val homeModel: HomeModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = homeModel.count.collectAsState()
            val scroll = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scroll)
            ) {
                state.value.receipts.forEach { receipt ->
                    Card(
                        modifier = Modifier
                            .size(160.dp)
                            .padding(top = 16.dp),
                    ) {
                        AsyncImage(
                            model = receipt.recipe?.image ?: "null",
                            contentDescription = null,
                        )
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = receipt.recipe?.name ?: "null", style = TextStyle(
                                fontSize = 17.sp,
                                fontWeight = FontWeight(600),
                                color = Color.White,
                                letterSpacing = 0.4.sp,
                            )
                        )
                    }
                }
            }
        }
    }
}
