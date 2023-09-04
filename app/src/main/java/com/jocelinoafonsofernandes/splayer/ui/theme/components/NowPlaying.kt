package com.jocelinoafonsofernandes.splayer.ui.theme.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme

@Composable
fun CostumeSlider() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "4:30",
            fontWeight = FontWeight.Bold,
            color = costumeTheme().textBold
        )
        Spacer(modifier = Modifier.width(5.dp))
        Slider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = 10f,
            onValueChange = {},
            colors = SliderDefaults.colors(
                thumbColor = costumeTheme().primary,
                activeTrackColor = costumeTheme().primary,
                inactiveTrackColor = costumeTheme().secondary
            )
        )
        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = "4:30",
            fontWeight = FontWeight.Bold,
            color = costumeTheme().textBold
        )

    }

}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun NowPlaying() {
    Scaffold(
        Modifier
            .background(costumeTheme().primaryContainer)
            .fillMaxSize(),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(costumeTheme().primaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CostumeSlider()
                Spacer(modifier = Modifier.height(30.dp))
                PlayOption()
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(costumeTheme().primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .heightIn(min = 300.dp, max = 400.dp),
                painter = painterResource(id = R.drawable.nf_the_search),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.Center,

                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "kid see ghost",
                color = costumeTheme().lightWeightText,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Dimensions Of Horizon Feat Post Malone",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                color = costumeTheme().textBold,
                modifier = Modifier.basicMarquee()
                    .padding(horizontal=10.dp)
            )

        }

    }

}

@Preview(
    name = "NowPlaying",
    showSystemUi = true,
    showBackground = true
)
@Preview(
    name = "NowPlaying",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NowPlayingPreview() {
    NowPlaying()
}
