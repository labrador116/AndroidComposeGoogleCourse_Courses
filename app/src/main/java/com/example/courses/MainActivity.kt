package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.data.Topic
import com.example.courses.datasource.DataSource
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    GridListLayout(DataSource.topics)
                }
            }
        }
    }

    @Composable
    fun GridListLayout(topicList: List<Topic>) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(topicList) { item: Topic ->
                GridListItem(
                    item.resId,
                    item.name,
                    item.grain
                )
            }
        }
    }

    @Composable
    fun GridListItem(
        @DrawableRes imageRes: Int,
        @StringRes titleStringRes: Int,
        count: Int
    ) {
        Card(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp)

                )

                Column(modifier = Modifier) {
                    Text(
                        text = stringResource(titleStringRes),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    )

                    Row {
                        Image(
                            painter = painterResource(R.drawable.ic_action_name),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )

                        Text(
                            text = count.toString(),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                        )
                    }
                }
            }
        }
    }
}